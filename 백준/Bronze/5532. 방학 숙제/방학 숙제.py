li=[]
for _ in range(5):
    li.append(int(input()))
a= li[1]//li[3]
b= li[2]//li[4]
if li[1]%li[3]==0 and li[2]%li[4]==0:
    print(li[0]-max(a,b))
elif li[1]%li[3]==0:
    if a>b:
        print(li[0]-a)
    else:
        print(li[0]-max(a,b)-1)
elif li[2]%li[4]==0:
    if a>b:
        print(li[0]-max(a,b)-1)
    else:
        print(li[0]-b)
else:
    print(li[0]-max(a,b)-1)