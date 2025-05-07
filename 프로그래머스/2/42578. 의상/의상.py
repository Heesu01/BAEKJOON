def solution(clothes):
    answer = 1
    dic={}
    for i,j in clothes:
        if j in dic.keys():
            dic[j]+=[i]
        else:
            dic[j]=[i]
    for i in dic.values():
        answer*= (len(i)+1)
    return answer -1