minn=list(map(int,input().split()))
man=list(map(int,input().split()))

if sum(minn)>=sum(man):
    print(sum(minn))
else:
    print(sum(man))