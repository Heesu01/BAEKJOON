
T = int(input())

for test_case in range(1, T + 1):
    A,B,N = map(int,input().split())
    answer=0
    while max(A,B) <= N:
        if A < B:
            A += B
        else:
            B += A
        answer +=1
    print(f"{answer}")