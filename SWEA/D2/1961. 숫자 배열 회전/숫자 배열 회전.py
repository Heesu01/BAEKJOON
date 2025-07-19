T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    matrix = [input().split() for _ in range(N)]

    rotate90 = list(zip(*matrix[::-1]))
    rotate180 = list(zip(*rotate90[::-1]))
    rotate270 = list(zip(*rotate180[::-1]))

    print(f"#{test_case}")
    for i in range(N):
        row90 = ''.join(rotate90[i])
        row180 = ''.join(rotate180[i])
        row270 = ''.join(rotate270[i])
        print(f"{row90} {row180} {row270}")