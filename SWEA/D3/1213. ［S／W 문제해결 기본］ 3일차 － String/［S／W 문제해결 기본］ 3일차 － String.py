for _ in range(10):
    T = int(input())
    word = input()
    text = input()
    cnt=0
    for j in range(len(text) - len(word) + 1):
        if text[j:j+len(word)] == word:
            cnt+=1
    print(f"#{T} {cnt}")
    