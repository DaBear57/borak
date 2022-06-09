def sum(n):
    sum = 0
    for i in range(1,n+1):
        sum += i
    return sum
    #return n * (n + 1) / 2

def sum_sq(n):
    sum = 0
    for i in range(1,n+1):
        sum += i ** 2
    return sum
    #return n * (n + 1) * (2 * n + 1) / 6

def sum_cb(n):
    sum = 0
    for i in range(1,n+1):
        sum += i ** 3
    return sum
    #return n * n * (n + 1) * (n + 1) / 4

print(sum(100))
print(sum_sq(100))
print(sum_cb(100))