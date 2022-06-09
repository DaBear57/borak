load 'lsd-radix.rb'
nums = []
for i in 0...1000
    nums << rand(10000)
end
nums = lsd_radix(nums,16)
puts "range: " + (nums[nums.length - 1] - nums[0]).to_s
puts "median: " + nums[nums.length / 2].to_s
sum = 0
for i in 0...nums.length
    sum += nums[i]
end
puts "mean: " + (sum / nums.length).to_s