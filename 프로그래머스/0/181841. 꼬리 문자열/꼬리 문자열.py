def solution(str_list, ex):
    answer = ''
    for word in str_list:
        if ex in word:
            continue
        else:
            answer+=word
    return answer