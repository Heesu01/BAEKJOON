from itertools import combinations

N = int(input())
li = [tuple(map(int, input().split())) for _ in range(N)]

min_diff = float('inf')

for i in range(1, N + 1):
    for comb in combinations(li, i):
        sour = 1 
        bitter = 0 
        for s, b in comb:
            sour *= s
            bitter += b
        min_diff = min(min_diff, abs(sour - bitter))
print(min_diff)