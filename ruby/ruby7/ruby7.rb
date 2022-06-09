def is_prime(n)
    for i in 2...n
        if (n % i == 0)
            return false
        end
    end
    return true
end

number = 2
primes = []
until (primes.length == 100)
    if (is_prime(number))
        primes << number
    end
    number += 1
end

puts primes