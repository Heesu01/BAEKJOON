def solution(participant, completion):
    answer = ''
    dic={}
    for i in participant:
        if i in dic:
            dic[i]+=1
        else:
            dic[i]=1
            
    for i in completion:
        if i in dic:
            dic[i]-=1 
            
    for key,value in dic.items():
        if value==1:
            answer = key
        
    return answer