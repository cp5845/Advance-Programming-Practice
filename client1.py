import socket

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

client.connect(('localhost', 12345))

reg_no = input("Enter Register Number: ")

client.send(reg_no.encode())

result = client.recv(1024).decode()

print("Student Result:", result)

client.close()