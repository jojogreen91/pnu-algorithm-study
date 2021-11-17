def solution(numbers, target):
    answer = 0
    max_case = 2 ** len(numbers)
    cases = []
    for i in range(max_case):
        num = bin(i)[2:]
        while(len(num) < len(numbers)):
            num = "0" + num
        cases.append(num)
    for case in cases:
        sum = 0
        for i in range(len(case)):
            if case[i] == "1":
                sum += numbers[i]
            else:
                sum -= numbers[i]
        if sum == target:
            answer += 1
    return answer
