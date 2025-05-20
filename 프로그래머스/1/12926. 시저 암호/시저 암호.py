def solution(s, n):
    answer = 'abcdefghijklmnopqrstuvwxyz'
    result=[]
    for i in s:
        if i.islower():
            result.append(answer[(answer.index(i)+n)%len(answer)])
        elif i.isupper():
            i = i.lower()
            result.append(answer[(answer.index(i)+n)%len(answer)].upper())
        elif i == " ":
            result.append(i)
    return ''.join(result)