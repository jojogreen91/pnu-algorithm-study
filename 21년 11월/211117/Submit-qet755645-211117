import re
def solution(new_id):
    answer = new_id
    answer = answer.lower() #1
    answer = re.sub('[^a-z\d\-\_\.]', '', answer) #2
    answer = re.sub('\.\.+', '.', answer) #3
    answer = answer.strip('.') # 4
    if answer == '':
        answer = 'a'
    if len(answer) >= 16:
        answer = answer[:15]
        answer = answer.strip('.')
    while len(answer) < 3:
        answer += answer[-1]
    return answer
