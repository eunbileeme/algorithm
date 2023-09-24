# Reivew
- Binary Search Tree
- 보통 DFS or Recursion으로 풀이

- 예제 2같은 경우는
  - root : 1, 왼쪽 : null, 오른쪽 : 3
 
## Tree는 recursion하게 생각하자
- 이 문제는 오른쪽에서 바라보므로 오른쪽 노드의 값만 넣으면 됨 -> 이 값이 다음 depth의 값이 될 것
  - 없다면, 왼쪽 노드의 값만..
  - 없다면, 다음 depth의 값만..
 
## 풀이
- result.size() == depth : 해당 노드가 tree에 없는 상태 -> 따라서 삽입

![image](https://github.com/eunbileeme/algorithm/assets/103405457/06f82f01-7ee5-4e3c-bba9-75365bedce4d)
