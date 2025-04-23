def solution(sequence, k):
    n=len(sequence)
    left = 0
    sum = 0
    best_len= n+1
    answer = []
    
    for right in range(n):
        sum += sequence[right]
        
        while sum >= k:
            if sum == k:
                curr_len= right-left+1
                if curr_len < best_len:
                    best_len = curr_len
                    answer=[left,right]
            sum -= sequence[left]
            left+=1
                    
    return answer