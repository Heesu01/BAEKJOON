def solution(myString):
    answer=''
    print(chr(108))
    for i in myString:
        if i < 'l':
            answer += 'l'
        else:
            answer += i
    return answer
