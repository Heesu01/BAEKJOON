T = int(input())

for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    if N > M:
        A, B = B, A
        N, M = M, N
		
    max_sum = 0
    for i in range(M - N + 1):
        sum = 0
        for j in range(N):
            sum += A[j] * B[i + j]
        max_sum = max(max_sum, sum)

    print(f"#{test_case} {max_sum}")