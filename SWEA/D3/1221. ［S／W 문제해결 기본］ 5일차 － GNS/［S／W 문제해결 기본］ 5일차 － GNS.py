dict = {"ZRO": 0, "ONE": 1, "TWO": 2, "THR": 3, "FOR": 4, "FIV": 5, "SIX": 6, "SVN": 7, "EGT": 8, "NIN": 9}

T = int(input())
for t in range(1, T + 1):
    _ = input() 
    text = input().split() 
    
    result = sorted(text, key=lambda x: dict[x])

    print(f"#{t}")
    print(*result)
