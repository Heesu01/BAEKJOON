def solution(myString):
    answer=''
    print(chr(108))
    for i in myString:
        if ord(i) < 108:
            answer += 'l'
        else:
            answer += i
    return answer
