def solution(my_string, queries):
    answer=list(my_string)
    for i,j in queries:
        answer[i:j+1] = answer[i:j+1][::-1]
    return "".join(answer)