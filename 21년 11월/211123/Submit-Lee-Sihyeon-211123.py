import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline


T = int(input())
primeArray = [0 for _ in range(10001)]
primeArray[0], primeArray[1] = 1,1
for i in range(2,100):
    for j in range(i*i, 10001, i): # i*i 부터 시작해서 i만큼 더하면서 체크
        primeArray[j] = 1


for _ in range(T):
    n = int(input())
    s = n//2 # 가운데부터 시작해서 양쪽으로 갈라지는 방식.
    for i in range(s):
        if primeArray[s-i] ==0 and primeArray[s+i] == 0:
            print(s-i, s+i)
            break

