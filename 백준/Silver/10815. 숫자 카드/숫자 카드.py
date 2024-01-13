n = int(input())
card = list(map(int, input().split()))
m = int(input())
check = list(map(int, input().split()))

card.sort()

def binary_search(array,target,start,end):
    while start<=end:
        mid = (start+end)//2
        
        if array[mid]==target:
            return 1
        elif array[mid]>target:
            end=mid-1
        else:
            start=mid+1
    return 0
    
for i in range(m):
    print(binary_search(card,check[i],0,n-1),end=" ")