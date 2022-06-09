def lsd_radix(arr, bits)
    for i in 0...bits
        narr = []
        for j in 0...arr.length
            if ((arr[j] & (1 << i)) == 0)
                narr << arr[j]
            end
        end
        for j in 0...arr.length
            if ((arr[j] & (1 << i)) != 0)
                narr << arr[j]
            end
        end
        arr = narr
    end
    return arr
end