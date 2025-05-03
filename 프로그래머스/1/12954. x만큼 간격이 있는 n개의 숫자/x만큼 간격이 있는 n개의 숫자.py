def solution(x, n):
    answer = []
    sum=x
    for i in range(n):
        answer.append(sum)
        sum+=x
    return answer