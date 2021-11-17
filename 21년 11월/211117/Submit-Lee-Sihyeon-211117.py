def solution(new_id):
    #1단계
    new_id = new_id.lower()
    answer = new_id
    #2단계
    for c in new_id:
        if not c.isalpha() and not c.isdigit() and c not in ['-','_','.']:
            answer = answer.replace(c,'')

    #3단계
    answer = list(answer)
    for i,c in enumerate(answer):
        if c == '.':
            for j,cc in enumerate(answer[i+1:]):
                if cc == '.':
                    answer[i+j+1] = ''
                else: break
    answer = ''.join(answer)
    
    #4단계
    answer = answer.strip('.')
    #5단계
    if answer =='':
        answer = 'a'
    #6단계
    if len(answer) >= 15:
        answer = answer[:15]
        answer = answer.strip('.')
    #7단계
    if len(answer) <=2:
        while len(answer) != 3:
            answer += answer[-1]
            
    return answer
            
    
            
