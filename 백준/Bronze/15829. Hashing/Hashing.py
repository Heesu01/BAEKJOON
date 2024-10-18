L = int(input())
text = input()

r = 31
m = 1234567891
ans=0

for i in range(L):
    ans += (ord(text[i])-96) * (r ** i)
    
print(ans % m)