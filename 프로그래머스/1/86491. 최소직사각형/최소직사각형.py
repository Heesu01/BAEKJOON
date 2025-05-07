def solution(sizes):
    answer = 0
    li = [(max(w,h),min(w,h)) for w,h in sizes]
    max_w = max(w for w,_ in li)
    max_h = max(h for _,h in li)
    return max_w * max_h