N = int(input())
switch = list(map(int,input().split()))
M = int(input())
for _ in range(M):
    gender,num = map(int,input().split())
    num -= 1 
    if gender ==1:
        for i in range(N):
            if (i+1) %(num+1)==0:
                switch[i]= 1 if switch[i]==0 else 0
    elif gender == 2:
        switch[num] = 1 if switch[num] == 0 else 0
        i = 1
        while num - i >= 0 and num + i < N and switch[num - i] == switch[num + i]:
            switch[num - i] = 1 if switch[num - i] == 0 else 0
            switch[num + i] = 1 if switch[num + i] == 0 else 0
            i += 1
for i in range(N):
    print(switch[i], end=' ')
    if (i + 1) % 20 == 0:
        print()