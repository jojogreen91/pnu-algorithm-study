from itertools import combinations
def solution(orders, course):
    countDict = dict()
    tmp = []
    answer = []

    # 조합 문제로 풀겠습니다.
    
    for c in course: #각 2, 3, 4, 5개의 조합마다 해줘야해서.
        for i, ord in enumerate(orders):
            orders[i] = sorted(list(ord)) #들어온 order를 알파벳 단위로 쪼개서 정렬시킴 ex ) "CAB" =  ['C','A','B'] --> ['A','B','C']
            combi = list(combinations(orders[i],c)) #해당 배열의 조합을 구함
            for com in combi: # 각 조합을 Dictionary에서 처리
                if com in countDict: 
                    countDict[com] += 1 # Dictionary에 있으면 +1
                else:
                    countDict[com] = 1 # 처음 들어온 조합이면 1로 초기화
        a = sorted(countDict.items(),key= lambda x : x[1], reverse = True) #value를 기준으로 정렬하되, 내림차순 정렬
        for i, (k, v) in enumerate(a):
            if v >=2: 
                tmp.append(k) #2번 이상 주문 된것만 넣고,
            
            if i == len(a)-1 or v > a[i+1][1]: #내림차순이라 4-4-3-1 이런식이면 4,4 둘다 포함되야해서.
                break

        countDict = dict() #다음 조합에 쓰기위한 초기화
    
    for t in tmp: 
        ans = ''.join(t) #tmp에 담아둔 쪼개진 알파벳 합침.
        answer.append(ans) 
    answer.sort() # 정렬해서 정답 반환
    return answer
