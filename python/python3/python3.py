n1 = int(input("enter first number: "))
n2 = int(input("enter second number: "))
n3 = int(input("enter third number: "))

if n1 > 10:
    print("kinda big number")

if n1 > 0:
    print("positive")
else:
    print("negative")

if n1 < n2 and n1 < n3:
    print("n1 smallest")
elif n1 > n2 and n1 > n3:
    print("n1 biggest")
else:
    print("n1 median")