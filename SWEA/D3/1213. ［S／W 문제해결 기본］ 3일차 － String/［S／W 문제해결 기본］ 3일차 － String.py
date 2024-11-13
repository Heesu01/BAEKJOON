for _ in range(1,11):
    T = int(input())
    word = input()
    text = input()
    ans = text.count(word)
    print(f"#{T} {ans}")
