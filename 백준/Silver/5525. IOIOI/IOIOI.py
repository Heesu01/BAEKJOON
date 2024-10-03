n = int(input())
m = int(input())
s = input()

p = "IO" * n + "I"
cnt=0

for i in range(0,m-len(p)+1):
    if s[i]=="I":
        if s[i:i+len(p)] == p:
            cnt+=1

print(cnt)