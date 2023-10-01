# Review
- 전형적인 DFS 문제
  - 턴제가 적용된 BFS 문제 
- 오렌지가 썩어가는 과정이 DFS
  - recursion 또는
  - 큐를 이용한 BFS처럼 풀이 

- 신선한 오렌지의 개수, 상한 오렌지의 개수를 잘 카운팅해야

## 풀이
- pure한 DFS? BFS? 풀이
- oc : 전체 오렌지의 개수 = rc : 썩은 오렌지의 개수
- 사이즈를 하나의 턴에 다 소진하는 식 -> 사이즈는 어딘가에다가 캐싱해두는 식으로..

- if (ny < 0 || nx < 0 ..)
  - 늘 수행하는 그래프 바운더리 체크 
![image](https://github.com/eunbileeme/algorithm/assets/103405457/bd416819-5cc8-4dd3-b458-6de41d56ed39)
