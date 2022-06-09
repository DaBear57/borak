pi = 0
for i in range(10000):
    pi += (i % 2 * -2 + 1) / (i * 2 + 1);
pi *= 4
print(pi)