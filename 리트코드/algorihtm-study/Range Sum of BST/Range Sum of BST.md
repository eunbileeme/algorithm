# Review
- 이진 탐색 트리 : recursion
- 주어진 배열의 요소들이 low와 high 사이에 속하는지 확인


## 풀이
- 현재 노드가 range 안에 있는지 밖에 있는지 판단해야
  - range 밖에 있는 경우 : 현재 값이 low보다 작은 경우
  - 현재 노드가 low보다 작기 때문에, 현재 노드보다 작은 값들은 필요가 없음 -> 오른쪽의 값들을 모아 recursion
  - range 밖에 있는 경우 : high보다 큰 경우
  - 현재 노드가 range보다 크기 때문에, 현재 노드보다 큰 값들은 볼 필요가 없음 -> 왼쪽의 값들을 모아 recursion
  - range 안에 있는 경우 : 현재 값이 사이에 있는 경우
  - 좌/우 노드가 사이에 있을 가능성이 있기 때문에 recursion
