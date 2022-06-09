import random

num = random.randint(0,100)
guess = -1
guesses = 0

while guess != num:
    if guesses >= 7:
        if guess == num:
            print("You won in %s guesses. Luck was on your side." % guesses)
            break
        print("You lost, you idiotic being. 7 guesses is all you need")
        break
    guess = int(input("Enter Guess: "))
    guesses += 1
    if guess > num:
        print("You are terrible and an idiot. Your insipid guess was too high. You have used %s guess(es) so far" % guesses)
    elif guess < num:
        print("You are an idiotic fool. Your terrible guess was too low. You have used %s guess(es) so far" % guesses)
    else:
        print("You won in %s guesses. Luck was on your side." % guesses)