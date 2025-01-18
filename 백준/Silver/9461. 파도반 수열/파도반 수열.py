import sys
input = sys.stdin.readline
arr = [0 for i in range(101)]

arr[1]=1
arr[2]=1
arr[3]=1
for i in range(4,101):
    arr[i]=arr[i-3]+arr[i-2]

t = int(input())
for i in range(t):
    n = int(input())
    print(arr[n])
