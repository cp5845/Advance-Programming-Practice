import socket

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

server.bind(('localhost', 12345))
server.listen(1)

print("Server is waiting for connection...")

while True:
    conn, addr = server.accept()
    print("Connected to:", addr)

    reg_no = conn.recv(1024).decode()

    results = {
        "101": "Pass - 85%",
        "102": "Pass - 90%",
        "103": "Fail - 35%",
        "104": "Pass - 78%"
    }

    result = results.get(reg_no, "Register number not found")

    conn.send(result.encode())

    conn.close()