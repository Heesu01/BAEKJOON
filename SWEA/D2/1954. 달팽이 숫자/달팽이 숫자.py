T = int(input())

dx = [0,1,0,-1]
dy = [1,0,-1,0]

for T in range(1,T+1):
    N = int(input())
    li = [[0]*N for _ in range(N)]
    
    x,y = 0,0
    direction = 0
    num =1
    
    for _ in range(N*N):
        li[x][y] = num
        num+=1
        
        nx = x + dx[direction]
        ny = y+ dy[direction]
        
        if 0<=nx<N and 0<=ny<N and li[nx][ny]==0:
            x,y = nx,ny
        else:
            direction = (direction +1)%4
            x+= dx[direction]
            y +=dy[direction]
            
    print(f"#{T}")
    for row in li:
        print(" ".join(map(str,row)))
        
    
    
    