def solution(nums):
    answer = 0
    li=[]
    for i in nums:
        if i not in li:
            li.append(i)
    answer = len(li)
    while len(nums)//2 < answer:
        answer-=1
    return answer