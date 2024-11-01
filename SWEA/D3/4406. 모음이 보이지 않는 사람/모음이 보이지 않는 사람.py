T = int(input())
li = ['a', 'e', 'i', 'o', 'u']
for T in range(1,T+1):
    text = input()
    result=[]
    for i in text:
      	if i not in li:
            result.append(i)
    print(f"#{T} {''.join(result)}")