import sys
from itertools import combinations
sys.stdin = open('input.txt')
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())

board = []
chicken = []
house = []
for _ in range(N):
    board.append(list(map(int,input().rstrip().split())))

for i in range(N):
    for j in range(N):
        if board[i][j] ==1:
            house.append([i,j])
        elif board[i][j] ==2:
            chicken.append([i,j])

print(house, chicken)

combi = list(combinations(chicken,M))

result =10000
for com in combi:
    dist_sum = 0
    for hx, hy in house:
        dist_min = 999
        for cx, cy in com:
            dist = abs(cx-hx)+ abs(cy-hy)
            dist_min=min(dist_min, dist)
        dist_sum += dist_min
    result = min(result, dist_sum)
print(result)



