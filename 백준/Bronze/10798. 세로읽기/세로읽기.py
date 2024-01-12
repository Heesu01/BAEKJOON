li=[]
for _ in range(5):
    text=input()
    li.append(text)

for i in range(15):
    for j in range(5):
        if i<len(li[j]):
            print(li[j][i],end='')