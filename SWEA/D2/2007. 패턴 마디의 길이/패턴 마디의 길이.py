T = int(input())
for test_case in range(1, T + 1):
    text = input()
    for i in range(1, len(text)): 
        if text[:i] == text[i:i*2]: 
            print(f"#{test_case} {i}")
            break
