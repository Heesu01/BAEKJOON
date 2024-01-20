t=int(input())
for _ in range(t):
    text=list(input().split())
    for i in text:
        print(i[::-1],end=" ")
    