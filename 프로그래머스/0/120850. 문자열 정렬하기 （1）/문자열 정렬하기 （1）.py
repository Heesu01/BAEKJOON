def solution(my_string):
    answer = []
    li = [str(i) for i in range(10)] 
    for i in range(0,len(my_string)):
        if my_string[i] in li:
            answer.append(my_string[i] )
    answer.sort()
    answer = [int(x) for x in answer]
    return answer