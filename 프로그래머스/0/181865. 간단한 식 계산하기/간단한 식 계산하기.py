def solution(binomial):
    answer = 0
    li=binomial.split(" ")
    if li[1] =="*":
        answer = int(li[0]) * int(li[2])
    elif li[1] =="+":
        answer = int(li[0]) + int(li[2])
    elif li[1] =="-":
         answer = int(li[0]) - int(li[2])
    return answer