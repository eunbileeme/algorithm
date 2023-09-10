# Review
- 트리 관련 문제는 재귀(리커전)로 풀었을 때 장점이 있음
  - 하위 노드의 개수가 정해져 있기 때문

- 특히, 트리 문제는 이진 탐색 트리인 경우가 많음
  - 왼쪽과 오른쪽 노드만 있음

- 해당 노드에서 정해진 규칙이 상위 노드에도 그대로 정해짐
  - 1. ..

## 관련 그림
![image](https://github.com/eunbileeme/algorithm/assets/103405457/ab006c40-8dda-4737-8871-29414ee92430)

### 시간 복잡도 : O(n)
- iteration = recursion

- min & max가 둘 다 주어진 노드의 예시
![image](https://github.com/eunbileeme/algorithm/assets/103405457/685ca9ad-59ff-4ef7-abce-285ec55e34ee)


## 풀이
- 왼쪽으로 갈 경우 -> max 값(= 루트 노드)만 알고 있는 상황
- 오른쪽으로 갈 경우 -> min 값(= 루트 노드)만 알고 있는 상황
![image](https://github.com/eunbileeme/algorithm/assets/103405457/91dad1d2-833c-4c74-886b-730016f617e3)
