N = int(input())
li = list(map(int, input().split()))
new = sorted(list(set(li)))

dic = {}
for i in range(len(new)):
  dic[new[i]] = i

for i in li:
  print(dic[i], end=" ")
