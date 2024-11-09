li = [int(input()) for _ in range(9)]
for i in li:
    for j in li:
        if (sum(li)-i-j)==100:
            num1, num2 = i, j
            break
            
li.remove(num1)
li.remove(num2)
for i in li:
    print(i)