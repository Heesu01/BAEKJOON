T = int(input())
for Tc in range(1,T+1):
    text = input()
    if text == text[ ::-1]:
        result=1
    else:
        result=0
    print(f"#{Tc} {result}")