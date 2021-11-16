s,e=map(int, input().rstrip().split())
sum_list = [0 for _ in range(0,1001)]

now = 1
cnt = 0

#누적합 구하기
for i in range(1,1001):
    sum_list[i] = sum_list[i-1] + now
    cnt += 1
    if cnt % now ==0:
        now+= 1
        cnt =0
print(sum_list[e] - sum_list[s-1])