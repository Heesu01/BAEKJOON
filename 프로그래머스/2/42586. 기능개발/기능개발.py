def solution(progresses, speeds):
    answer = []
    days=[]
    for i in range(len(progresses)):
        if (100 - progresses[i]) % speeds[i] > 0:
            days.append((100 - progresses[i]) // speeds[i] + 1)
        else:
            days.append((100 - progresses[i]) // speeds[i])
    
    index = 0
    n = len(days)
    while index < n:
        day = days[index]
        cnt = 0
        while index < n and days[index] <= day:
            cnt += 1
            index += 1
        answer.append(cnt)
    
    return answer