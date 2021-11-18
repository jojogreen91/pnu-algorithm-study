gCount = 0
gDepth = 0
gTarget = 0
def dfs(n,s,d):
    global gCount
    if d==gDepth:
        if s == gTarget:
            gCount +=1
        return
    dfs(n,s+n[d],d+1)
    dfs(n,s-n[d],d+1)
    
def solution(numbers, target):
    global gDepth,gTarget
    gDepth=len(numbers)
    gTarget = target
    dfs(numbers,0,0)
    return gCount
    