T = int(input())
for _ in range(T):
   N = bin(int(input()))[2:]
   for i in range(len(N)):
       if N[-i-1] == '1':
           print(i, end = ' ')