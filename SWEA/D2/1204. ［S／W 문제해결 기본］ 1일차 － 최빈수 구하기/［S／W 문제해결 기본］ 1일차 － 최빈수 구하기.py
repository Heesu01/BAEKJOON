T = int(input())
for test_case in range(1, T + 1):
    test_num= int(input())
    cnt=[0] * 101
    li = map(int, input().split())

    for num in li:
        cnt[num]+=1
        
    m = cnt.index(max(cnt))
    
    for i in range(101):
        if cnt[i] == max(cnt):
            m = i  
    print(f"#{test_case} {m}")