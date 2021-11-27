def solution(lottos, win_nums):
    dic = {}
    answer = []
    zeros = 0
    cnt = 0
    for i in win_nums:
        dic[i] = 0
    for i in lottos:
        if i == 0:
            zeros+=1
        else:
            if i in dic:
                cnt+=1
    low = min(7-cnt,6) # 최저순위 최소 6까지 (cnt가 0인경우 6으로 바뀌어야 하기때문)
    high = max(low-zeros, 1) # low-zeros가 0이 될수 있음.
    
    answer = [high,low]
    return answer