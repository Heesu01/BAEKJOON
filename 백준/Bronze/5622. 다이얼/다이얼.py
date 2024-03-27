li=['ABC','DEF','GHI','JKL','MINO','PQRS','TUV','WXYZ']
t=0
text=input()
for i in text:
    t+=2
    for j in range(len(li)):
        if i in li[j]:
            t+= j+1
            break
        else:
            continue

print(t)