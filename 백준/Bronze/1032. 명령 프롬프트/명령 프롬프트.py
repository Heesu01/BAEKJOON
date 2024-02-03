n=int(input())
li=[]
for i in range(n):
    a=input()
    li.append(a)
word=list(li[0])
for i in range(n):
    for j in range(len(word)):
        if word[j]!= li[i][j]:
            word[j] ='?'
        else:
            continue
print(''.join(word))