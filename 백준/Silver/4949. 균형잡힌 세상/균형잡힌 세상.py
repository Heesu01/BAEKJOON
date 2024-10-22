while(True):
    text = input()
    if(text == "."):
        break
    stack = []


    for i in text:
        if(i == "(" or i == "["):
            stack.append(i)
        if(i == ")"):
            if(len(stack) != 0 and stack[-1] == "("):
                stack.pop()
            else:
                stack.append(")")
                break
        if(i == "]"):
            if(len(stack) != 0 and stack[-1] == "["):
                stack.pop()
            else:
                stack.append("]")
                break


    if(len(stack) == 0):
        print("yes")
    else:
        print("no")