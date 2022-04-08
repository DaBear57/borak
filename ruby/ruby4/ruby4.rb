i = 1
while (i < 5)
    puts "loop #1 has run " + i.to_s + " times"
    i += 1
end

for j in 1..4
    puts "loop #2 has run " + j.to_s + " times"
end

for k in 1...5
    puts "loop #3 has run " + k.to_s + " times"
end

l = 1
until (l == 5)
    puts "loop #4 has run " + l.to_s + " times"
    l += 1
end

4.times { puts "loop #5 has run" }

4.times do
    puts "loop #6 has run"
end