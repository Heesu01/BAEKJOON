li=[int(input()) for _ in range(9)]
li.sort()
s= sum(li)

for i in range(9):
    for j in range(i+1,9):
        if s - (li[i]+li[j])==100:
            a=li[i]
            b=li[j]
            
li.remove(a)
li.remove(b)

for i in range(7):
    print(li[i])