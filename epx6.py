from automata.fa.nfa import NFA

nfa = NFA(
    states={'q0', 'q1', 'q2'},
    input_symbols={'a', 'b'},
    transitions={
        'q0': {
            'a': {'q0', 'q1'},
            'b': {'q0'}
        },
        'q1': {
            'b': {'q2'}
        },
        'q2': {
            'a': {'q2'},
            'b': {'q2'}
        }
    },
    initial_state='q0',
    final_states={'q2'}
)

# Test strings
test_strings = ['ab', 'aab', 'bab', 'abba', 'aaa', 'bbb']

for string in test_strings:
    if nfa.accepts_input(string):
        print(string, "- Accepted")
    else:
        print(string, "- Rejected")