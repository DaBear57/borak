#Ben DeBear

price = float(input("Enter price of car: "))

def tax(p):
    return 0.06625 * p

print("tax:", tax(price))

def total_price(p):
    return 1.06625 * p

print("total price:", total_price(price))