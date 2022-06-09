print "enter string: "
str = gets.chomp
count = 0
str.each_byte { |x| count = (x.chr == str[0]) ? count + 1 : count}
puts count