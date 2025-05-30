def solution(my_strings, parts):
    answer = ''
    for i in range(len(my_strings)):
        word = my_strings[i]
        answer += word[parts[i][0]:parts[i][1]+1]
    return answer