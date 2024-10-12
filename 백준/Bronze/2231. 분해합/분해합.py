n = int(input())

for num in range(0,n+1):
    li = list(map(int,str(num)))
    num_sum = num + sum(li)
        
    if num_sum == n:
        print(num)
        break
    if num == n:
        print(0)