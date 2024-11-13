for T in range(10):
    t = int(input())  
    li= [input() for _ in range(100)]
    max_len = 1

    # 가로 방향 검사
    for row in li:
        for length in range(100, 1, -1): 
            for start in range(100 - length + 1):  
                ans = row[start:start + length]
                if ans == ans[::-1]:  
                    max_len = max(max_len, length)
                    break  

    # 세로 방향 검사
    # for col in range(100):
    #     for length in range(100, 1, -1):
    #         for start in range(100 - length + 1):
    #             substring = ''.join(li[start + i][col] for i in range(length))
    #             if substring == substring[::-1]:  
    #                 max_len = max(max_len, length)
    #                 break

    for col in zip(*li):
        for length in range(100, 1, -1): 
            for start in range(100 - length + 1):  
                ans = col[start:start + length]
                if ans == ans[::-1]:  
                    max_len = max(max_len, length)
                    break  

    print(f"#{t} {max_len}")
