s1 = "Hello World"
s2 = ""

s1.each_byte do |x|
    s2 = x.chr + x.chr + s2
end

puts s2