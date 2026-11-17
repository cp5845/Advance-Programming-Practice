import socket

server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

server.bind(('localhost', 12346))

print("Temperature Server Started...")

while True:
    data, addr = server.recvfrom(1024)

    temperature = data.decode()

    print("Temperature Received:", temperature, "°C")
    print("From:", addr)