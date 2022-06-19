def solution(n, times):
    answer = 0
    left = 1
    right = max(times) * n

    while left <= right:
        mid = (left + right) // 2
        people = 0
        for time in times:
            people += mid // time

        # 심사받을 사람보다 심사한 사람이 많을 경우 시간 단축
        if n <= people:
            answer = mid
            right = mid - 1
        # 그렇지 않은 경우 시작 시간 추가
        else:
            left = mid + 1

    print('answer', answer)
    return answer

solution(6, {7, 10})
