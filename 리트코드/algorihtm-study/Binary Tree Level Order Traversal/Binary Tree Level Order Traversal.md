# Review
- 트리 문제
  - 왼쪽 -> 오른쪽 노드 순으로 삽입(in-order) 
- 레벨 : 한 칸이 한 레벨
  - 한 칸에 한 레벨

> ex. 3 Level

![image](https://github.com/eunbileeme/algorithm/assets/103405457/4c4e0e55-2341-4e6a-9a7f-22915a9ec38e)

- DFS : "현재가 어떤 레벨에 있느냐?"
  - 한 노드를 내려갈 때마다 + 1 Depth
  - pre-order
- BFS : ..

## 풀이
- DFS - 리커전 형태로 내려가면서..
  - 레벨 값을 인덱스로 사용
![image](https://github.com/eunbileeme/algorithm/assets/103405457/65e89fa6-a4ee-425d-8bb8-c07e6d96f004)

### 위 코드에서 왼쪽 노드부터 탐색하는 부분은?
