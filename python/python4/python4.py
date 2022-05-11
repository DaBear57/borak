for i in range(3):
    print("loop a:", i)

for i in range(7,12):
    print("loop b:", i)

i = 2
while i < 8:
    print("loop c:", i)
    i += 1

i = 11
while True:
    print("loop d:", i)
    i -= 1;
    if i < 8:
        break