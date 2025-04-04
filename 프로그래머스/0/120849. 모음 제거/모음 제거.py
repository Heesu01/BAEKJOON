def solution(my_string):
    li = ['a','e','i','o','u']
    for i in li: 
        my_string = my_string.replace(i, '')
    return my_string