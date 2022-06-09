print "enter string: "
str = gets.chomp
arr = str.split("e")
narr = []
arr.each do |x|
    narr << x.reverse!
end
print "\n", narr