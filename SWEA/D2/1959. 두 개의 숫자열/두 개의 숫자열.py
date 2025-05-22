T = int(input())
for test_case in range(1, T + 1):
    N,M = map(int,input().split())
    A = list(map(int,input().split()))
    B = list(map(int,input().split()))
    ans=0
    
    if N<M:
        for i in range(M-N+1):
            sum=0
            for j in range(N):
                sum += A[j] * B[j+i]
            if ans<sum:
                ans = sum
    else:
        for i in range(N-M+1):
            sum=0
            for j in range(M):
                sum += A[j+i] * B[j]
            if ans<sum:
                ans = sum
            
    print(f"#{test_case} {ans}")