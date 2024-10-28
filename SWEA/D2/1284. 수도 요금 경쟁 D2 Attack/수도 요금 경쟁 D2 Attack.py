T = int(input())

for t in range(1, T + 1):
    P, Q, R, S, W = map(int,input().split())
    A= P*W 
    if W<=R:
        B = Q
    else:
        B = Q + (W-R)*S
    result = A if A < B else B
    print(f"#{t} {result}")
