import math

pi = 0
i = 0
while abs(pi * 4 - math.pi) >= 0.00001:
    pi += (i % 2 * -2 + 1) / (i * 2 + 1);
    i += 1
print(i)