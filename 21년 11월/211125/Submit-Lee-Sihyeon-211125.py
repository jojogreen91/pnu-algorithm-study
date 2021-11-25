import sys
from collections import deque
input = sys.stdin.readline

I = int(input())
"""
[최초 문서 index,priority] 를 쌍으로 묶고,
priority는 따로 저장해서 내림차순 정렬해두자.
"""
for _ in range(I):
    # 입력 및 저장 
    # M = 찾아야되는 인덱스
    N , M = map(int, input().rstrip().split())
    dq = deque()
    li_prio = list()
    inp = list(map(int, input().rstrip().split()))
    for i, prio in enumerate(inp):
        dq.append([i,prio])
        li_prio.append(prio)
    li_prio.sort(reverse= True) #내림차순 정렬
    flag = False #M을 찾았는지
    count =1 # 몇번째에 찾았는지 + 현재 target prio가 몇인지 index로 활용
    while True:
        target_prio = li_prio[count-1] # 찾아야되는 prio
        while True:
            i, prio = dq.popleft() # 하나씩 빼서 비교해보고
            if prio == target_prio: #찾았으면 다음꺼 찾아야하는데
                if M == i: # 인덱스 같은지 비교해보고 맞으면 전체 종료
                    flag = True
                    break
                else: # 찾던게 아니면 그냥 현재 while문만 종료
                    break
            else: #안맞으면 맨 뒤로 뺀거 넣어줌
                dq.append([i,prio])
        if flag:
            result = count
            break
        else: 
            count += 1    
    print(result)