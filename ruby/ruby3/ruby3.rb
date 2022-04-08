a = 57
b = 2089

c = "borak"
d = "strawberry"

if (c == "borak")
    puts "c is borak"
end

if (c.eql? d)
    puts "strings equal"
else
    puts "strings unequal"
end

if (a < b)
    puts "a less than b"
elsif (a == b)
    puts "a equal to b"
else
    puts "a greater than b"
end

unless (b < 100)
    puts "b is big"
end