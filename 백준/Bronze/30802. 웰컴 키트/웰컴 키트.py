n = int(input())
li=list(map(int, input().split()))
t, p = map(int, input().split())

t_cnt=0

for i in li:
    if i>0:
        if i % t == 0:
            t_cnt += i // t
        else: 
            t_cnt += i // t + 1
         
print(t_cnt)
print(n//p , n%p )
        