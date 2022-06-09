def power(b, e)
    if (e == 0)
        return 1
    end
    return b * power(b,e-1)
end

print "3^5: ", power(3,5)