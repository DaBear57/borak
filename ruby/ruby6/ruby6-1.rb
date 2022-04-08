s = "Hello World"
puts s[3]
puts s.strip
puts s.index("World")
puts s.index("l",6)
puts s[3,s.length]
puts s[3..7]
puts s.gsub("World", "Orak")
puts s.upcase
puts s.downcase
puts s.eql? "Goodbye World"
puts s <=> "Goodbye World"
puts s.length