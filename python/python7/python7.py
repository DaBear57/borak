import random
minimum = 999999999
maximum = 0
sum = 0

for i in range(0,10000):
    num = random.randint(0,10000)
    minimum = min(num,minimum)
    maximum = max(num,maximum)
    sum += num

print("Minimum:",minimum)
print("Maximum:",maximum)
print("Range:",maximum-minimum)
print("Mean:",sum/10000)