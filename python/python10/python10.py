from random import randint

def lsd_sort(l,b):
	n = l
	for i in range(b):
		n0 = []
		n1 = []
		for j in n:
			if (j & (2 << i)) == 0:
				n0.append(j)
			else:
				n1.append(j)
		n = n0 + n1
	return n

arr = []
sum = 0
for i in range(0, randint(0,1000)):
    num = randint(0,1000)
    sum += num
    arr.append(num)

arr = lsd_sort(arr,10)

print("array:", arr)
print("mean:", sum/len(arr))
print("range:", arr[-1] - arr[0])
print("median:", arr[len(arr) // 2])