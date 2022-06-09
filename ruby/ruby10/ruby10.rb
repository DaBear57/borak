load 'lsd-radix.rb'
nums = []
for i in 0...10
    nums << rand(5)
end
nums = lsd_radix(nums,16)
modes = []
count = 1
index = 0
for i in 0...nums.length
    if (nums[i] != nums[index])
        index = i
    end
    if (i - index + 1 == count)
        modes << nums[i]
    elsif (i - index + 1 > count)
        modes = [nums[i]]
        count += 1
    end
end
print nums
puts
print modes, " ", count
    