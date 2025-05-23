from itertools import combinations

T = int(input())

for test_case in range(1, T + 1):
    li=[1,2,3,4,5,6,7,8,9,10,11,12]
    answer=0
    N,K = map(int,input().split())
    for com in combinations(li,N):
        if sum(com)==K:
            answer+=1
    print(f"#{test_case} {answer}")