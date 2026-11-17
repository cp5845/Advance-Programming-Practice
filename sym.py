import sympy as sp

# Define symbolic variables
x, y = sp.symbols('x y')

# Expansion
expr = (x + 2)**2
expanded = sp.expand(expr)

print("Expanded Expression:", expanded)

# Factorization
expr2 = x**2 + 5*x + 6
factored = sp.factor(expr2)

print("Factorized Expression:", factored)

# Simplification
expr3 = (x**2 - 1)/(x - 1)
simplified = sp.simplify(expr3)

print("Simplified Expression:", simplified)

# Solve quadratic equation
equation = x**2 - 5*x + 6

solution = sp.solve(equation, x)

print("Quadratic Equation:", equation)
print("Solutions:", solution)