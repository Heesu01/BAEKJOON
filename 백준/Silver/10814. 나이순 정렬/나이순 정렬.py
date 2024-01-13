n = int(input())
list=[]

for _ in range(n):
    age,name = input().split()
    list.append([int(age),name])
list.sort(key=lambda x:int(x[0]))

for i in list:
    print(i[0],i[1])