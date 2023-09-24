# Reivew
- Binary Search Tree
- 보통 DFS or Recursion으로 풀이
  - 리커전으로 푼다면 *노드별로 있을 수 있는 케이스 + 리턴했을 때 해야할 행동을 고려*

- 예제 2같은 경우는
  - root : 1, 왼쪽 : null, 오른쪽 : 3
 
## Tree는 recursion하게 생각하자
- 이 문제는 오른쪽에서 바라보므로 오른쪽 노드의 값만 넣으면 됨 -> 이 값이 다음 depth의 값이 될 것
  - 없다면, 왼쪽 노드의 값만..
  - 없다면, 다음 depth의 값만..
 
## 풀이
- result.size() == depth : 해당 노드가 tree에 없는 상태 -> 따라서 삽입

![image](https://github.com/eunbileeme/algorithm/assets/103405457/06f82f01-7ee5-4e3c-bba9-75365bedce4d)

## 해석
![image](https://github.com/eunbileeme/algorithm/assets/103405457/7ef918d5-5f9a-4dc4-912b-d7c1bd4ff6de)

1. 노드 1을 만났을 때 : [] (size = 0) -> 노드 2로 넘어가기 전 : [1] (size = 1)
2. 노드 2를 만났을 때 : [1] (size = 1) -> 노드 3으로 넘어가기 전 : [1, 2] (size = 2)
3. 노드 3을 만났을 때 : [1, 2] (size = 2) -> 노드 4로 넘어가기 전 : [1, 2, 3] (size = 3)
4. ..
5. (위 그림처럼 노드 5가 오른쪽 노드의 가장 마지막 depth일 때) 노드 5를 만났을 때 : [1, 2, 3, 4] (size = 4) -> [1, 2, 3, 4, 5] (size = 5) --> result.size() == depth
6. 왼쪽 노드인 6으로 넘어감..
