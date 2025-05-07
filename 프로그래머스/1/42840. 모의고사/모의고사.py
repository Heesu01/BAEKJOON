def solution(answers):
    count = [0,0,0]
    st = [[1,2,3,4,5],[2, 1, 2, 3, 2, 4, 2, 5],[3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    
    for j in st:
        while len(j)<len(answers):
            j+=j
        j[:] = j[:len(answers)]
    
    for i in range(len(answers)):
        for j in range(len(st)):
            if answers[i]==st[j][i]:
                count[j]+=1
    
    answer=[]
    for i in range(len(count)):
        if count[i] == max(count):
            answer.append(i+1)
    
    return answer