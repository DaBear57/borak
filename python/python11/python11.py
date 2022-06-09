import random

nums = []
for i in range(10):
    nums.append(random.randint(0,10))
print("Nums:", nums)

target = int(input("enter target number: "))

def is_present(arr,t):
    if len(arr) == 0:
        return False
    if arr[0] == t:
        return True
    return is_present(arr[1:], t)

print("target is present" if is_present(nums, target) else "target is not present")
    