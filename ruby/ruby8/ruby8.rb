load 'lsd-radix.rb'
nums = []
for i in 0...1000000
    nums << rand(1000)
end
nums = lsd_radix(nums,10)
print nums