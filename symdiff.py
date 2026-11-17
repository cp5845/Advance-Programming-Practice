import sympy as sp

# Define symbolic variable
t = sp.symbols('t')

# Displacement function
s = t**3 - 6*t**2 + 9*t + 5

print("Displacement:", s)

# Velocity = First derivative
v = sp.diff(s, t)

print("Velocity:", v)

# Acceleration = Second derivative
a = sp.diff(v, t)

print("Acceleration:", a)

# Find when vehicle is at rest
rest_time = sp.solve(v, t)

print("Vehicle at rest at:", rest_time)

# Definite integration from t=0 to t=3
distance = sp.integrate(v, (t, 0, 3))

print("Displacement over interval:", distance)