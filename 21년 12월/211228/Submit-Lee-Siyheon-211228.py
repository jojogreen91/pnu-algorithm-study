import sys
from collections import deque
inp = sys.stdin.readline

r,c =map(int, inp().rstrip().split())
x, y, d = map(int, inp().rstrip().split())

#값 초기화
board=[]
q = deque()
result = 0
visited = [[0 for _ in range(c)] for _ in range(r)]
dir = {
    0 : (0,-1), #북
    1 : (-1,0), #동
    2 : (0, 1), #남
    3 : (1, 0)  #서
}

for _ in range(r):
    board.append(list(map(int, inp().rstrip().split())))
# 첫 지점이 벽에 떨어진경우.
if board[x][y] ==0:
    q.append((x,y,d))
    visited[x][y]= 1
    result +=1

while q:
    nr,nc,d = q.popleft()
    next = False
    #4방향 탐색
    for i in range(4):
        nx,ny, d = nr+dir[d][0], nc+dir[d][1], (d+3)%4        
        if 0<= nx <r and 0<= ny < c:
            if board[nx][ny] == 0 and visited[nx][ny] == 0:
                result+=1
                visited[nx][ny] = 1
                q.append((nx,ny,d))
                next=True
                break
    #위 탐색에 청소할 곳 찾지 못하고 후진해야하는 경우
    if next==False:
        nx,ny = nr+dir[(d-1)%4][0], nc+dir[(d-1)%4][1]
        #후진하는곳이 벽이면 청소 종료.
        if board[nx][ny] ==1:
            break;
        else:
            q.append((nx,ny,d))
    
print(result)


