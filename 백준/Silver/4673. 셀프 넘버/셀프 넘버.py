li=[]
for i in range(1,10000):
  num = list(map(int,str(i)))
  li.append(i+sum(num))

for i in range(1,10000):
    if i not in li:
        print(i)