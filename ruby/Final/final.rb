#Ben DeBear

print "Enter name: "
finalString = gets.chomp
finalArr = []
finalArr = finalString.split("")
print finalArr
puts #for spacing

(finalArr.length).times do
    puts "RUBY"
end

puts "Ruby " + (2.2).to_s