def method1()
    puts "three\nline\nmessage"
end

def method2(lower, upper)
    sum = 0
    for i in 0...100
        sum += lower + rand(upper)
    end
    return sum / 100.0
end

method1
puts "enter lower bound"
l = gets.chomp.to_i
puts "enter upper bound"
u = gets.chomp.to_i
puts method2(l,u)