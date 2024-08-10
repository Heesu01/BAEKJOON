n = int(input())
cards = list(map(int,input().split()))
m = int(input())
check = list(map(int,input().split()))

cards.sort()
count = {}

for i in cards:
    if i in count:
        count[i] +=1
    else:
        count[i]=1
        

def binary_search(array,target,start,end):
    if start > end:
        return 0
    mid = (start+end)//2
    if array[mid] == target:
        return count[target]
    elif array[mid] > target:
        return binary_search(array,target,start,mid-1)
    else:
        return binary_search(array,target,mid+1,end)
            
for i in range(m):
    print(binary_search(cards,check[i],0,n-1), end=" ")
        