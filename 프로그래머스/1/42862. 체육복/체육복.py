def solution(n, lost, reserve):
    lost_s = set(lost) - set(reserve)
    reserve_s = set(reserve) - set(lost)
    
    for i in reserve_s:
        if i-1 in lost_s:
            lost_s.remove(i-1)
        elif i+1 in lost_s:
            lost_s.remove(i+1)
        
    return n-len(lost_s)