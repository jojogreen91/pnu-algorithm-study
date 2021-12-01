def solution(absolutes, signs):
    ans = 0
    for a, s in zip(absolutes, signs):
        if s: ans += a
        else: ans -= a
    return ans
