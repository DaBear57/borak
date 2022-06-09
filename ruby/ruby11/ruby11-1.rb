def fib(a)
    if (a == 0 or a == 1)
        return 1
    end
    return fib(a-1) + fib(a-2)
end

puts "fibs:"
for i in 0...10
    print fib(i), ", "
end

def factorial(a)
    if (a == 0)
        return 1
    end
    return a * factorial(a-1)
end

puts "\n\nfactorials:"
for i in 0...10
    print factorial(i), ", "
end