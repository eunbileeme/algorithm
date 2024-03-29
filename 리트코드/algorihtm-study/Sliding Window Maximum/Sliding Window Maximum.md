# Review
- 슬라이딩 윈도우
- 크기는 정해져있고, 윈도우가 이동할 때마다 첫 값은 제외되고 값 하나가 추가됨

- 문제에선 윈도우 내의 최대값에 관심이 있음
- 즉, 내가 추가하는 값보다 작은 값들은 관심이 없음

- 최소 한 개의 값은 없어지고, 내가 추가하는 값보다 작은 값은 (큐? = 윈도우?) 내에서 의미가 없음
- 최대값이 윈도우의 맨 앞으로 가져와서 비교를 진행하는 것이 베스트

- 슬라이딩 윈도우의 맨 앞에 가장 큰 값이 오도록 빼주는 작업을 진행하고, 새로 추가하는 값보다 작은 값들이 있으면 빼버리는 방식으로 진행?

## 풀이
- 값이 빠지는 작업이 앞 뒤로 발생 중 -> 슬라이딩 윈도우 = Deque

- 윈도우 범위 밖에 넘어간 원소들을 빼줌 -> 디큐 뒤에 값을 넣을 때, 디큐의 마지막 값보다 넣을려는 값이 작으면 빼줌
- 즉, 인덱스를 벗어난 값을 빼고 + 넣을려는 값보다 작은 값을 뺌

- 윈도우 내에는 넣는 값 + 윈도우 상에서 가장 큰 값이 맨 앞에 남아있게 됨

### 시간 복잡도
- O(2n)
