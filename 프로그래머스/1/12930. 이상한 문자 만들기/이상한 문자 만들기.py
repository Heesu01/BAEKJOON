def solution(s):
    answer=[]
    li=s.split(" ")
    for word in li:
        word = list(word)
        for i in range(len(word)):
            if i%2==0:
                word[i]=word[i].upper()
            else:
                word[i]=word[i].lower()
        answer.append("".join(word))
    return " ".join(answer)