import sys
input = sys.stdin.readline
blocks = [
    [[1,1,1,1]], # 일자 (ㅡ)
    [[1],[1],[1],[1]], # 일자 (ㅣ)
    [[1,1],[1,1]], # 네모 (ㅁ)

    #니은(ㄴ)
    [[1,0],[1,0],[1,1]],
    [[0,1],[0,1],[1,1]],
    [[1,1],[0,1],[0,1]],
    [[1,1],[1,0],[1,0]],

    [[1,1,1],[1,0,0]],
    [[1,1,1],[0,0,1]],
    [[1,0,0],[1,1,1]],
    [[0,0,1],[1,1,1]],

    #Z모양(Z)
    [[1,0],[1,1],[0,1]], 
    [[0,1,1],[1,1,0]],
    [[0,1],[1,1],[1,0]],
    [[1,1,0],[0,1,1]],

    [[1,1,1],[0,1,0]], #우 (ㅜ)
    [[0,1],[1,1],[0,1]], #어(ㅓ)
    [[0,1,0],[1,1,1]], # 오(ㅗ)
    [[1,0],[1,1],[1,0]] # 아 (ㅏ)
]

n, m = map(int,input().rstrip().split())
board = []
for i in range(n):
    board.append(list(map(int,input().rstrip().split())))

sumMax = 0
for r in range(n):
    for c in range(m):
        for block in blocks:
            s = 0
            if r + len(block)-1 < n and c+len(block[0])-1 < m:
                for row in range(len(block)):
                    for col in range(len(block[0])):
                        if block[row][col] == 1:
                            s += board[r+row][c+col]
            sumMax = max(s, sumMax)
print(sumMax)    



