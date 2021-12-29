import sys
sys.stdin = open("input.txt")

input = sys.stdin.readline

board =[]
count =0
for i in range(8):
    board.append(list(input()))

for i in range(8):
    if i%2 == 0: # 짝수 row일떄. 흰색부터.
        for j in range(8):
            if j%2 == 0 and board[i][j] == 'F':
                count += 1
    else:
        for j in range(8):
            if j%2 == 1 and board[i][j] == 'F':
                count +=1

print(count)



