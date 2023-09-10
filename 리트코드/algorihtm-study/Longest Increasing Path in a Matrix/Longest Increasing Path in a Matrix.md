# Review
- 커야만 이동할 수 있음
  - 즉, a -> b로 갔다면 a로 돌아오는 건 불가능
  - 경로가 한 번 정해지고 나면, 그 값이 fix된다는 특징을 가지고 있음

- 즉, dfs 문제(recursion을 하는 형태로)
  - 갈 수 있는 만큼 가고, 해당 값들이 fix가 됨
  - 그리고 지나간 값들은 1로 처리
 
### 시간 복잡도
- public - for문 : O(m * n)
- private - for문 : O(m * n)
  - 따라서 총 2O(m * n)이지만 상수는 무시하므로 O(m * n)

## 풀이
- dx, dy : 4방향 탐색
![image](https://github.com/eunbileeme/algorithm/assets/103405457/dae74bb1-8ad1-45a8-b103-57efeeeb690f)

