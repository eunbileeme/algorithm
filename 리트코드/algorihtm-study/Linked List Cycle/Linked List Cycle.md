# Review
- pos는 내부적으로 사이클을 가지고 있다는 것

- space complexity O(1)로 할 수 있는 방법을 필수로 생각해보아야 함
  - "내가 지나온 경로를 어딘가에 저장을 해둔다면, 보통 HashSet으로 저장"
  - 단, O(1)으로 진행하기 위해서는 ..
    - "floyd cycle finding algorithm"
   
## 풀이
- 연결 리스트는 "dummy"를 통해 null일 경우를 수월하게 처리할 수 있음
- slow라는 노드는 한 칸 이동
  - fast라는 노드는 두 칸 이동
    - 사이클이 있다는 가정 하에, 두 노드는 언젠가 만나게 됨
   
- 1) 사이클 내에서 slow와 fast가 만난다.
  2) 만난 이후부터, 다시 시작 지점부터 slow와 fast를 한 칸씩 이동시키면 사이클의 시작 지점에서 만난다.

![image](https://github.com/eunbileeme/algorithm/assets/103405457/4c6d1ffb-cc52-477c-8ec1-1ea600243a0f)
