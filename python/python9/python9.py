minimum = 1
maximum = 100
count = 0

while True:
    guess = (minimum + maximum) // 2
    print(guess)
    count += 1
    response = input("h/l/c: ")
    if response == "l":
        maximum = guess - 1
    elif response == "h":
        minimum = guess + 1
    elif response == "c":
        break
    else:
        print("invalid response")
        count -= 1

print("guessed in %i tries" % count)
