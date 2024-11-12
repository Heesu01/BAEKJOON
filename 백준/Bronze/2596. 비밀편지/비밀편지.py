dict = {
    "000000": "A", "001111": "B", "010011": "C", "011100": "D",
    "100110": "E", "101001": "F", "110101": "G", "111010": "H"
}

N = int(input())
text = input()

result = ""

for i in range(1, N + 1):
    word = text[6 * (i - 1):6 * i]
    found = False

    if word in dict:
        result += dict[word]
        found = True
    else:
        for num in dict.keys():
            cnt = sum(1 for j in range(6) if word[j] != num[j])
            if cnt == 1: 
                result += dict[num]
                found = True
                break

    if not found:
        print(i)
        break
else:
    print(result)
