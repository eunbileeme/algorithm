# Review
- 전체 맵을 스캔하며 섬의 개수를 카운트하는게 가장 normal한 방법이지만..
  - 시간 복잡도 초과

- "특정 원소들이 그래프 상에서 연결되어 있냐?" or "사이클을 판단할 때"
  - disjoint set(= 구분되어 있냐) & union find set(= 합쳐서 find)

## disjoint set & union find set (root를 array에 저장)
1. 어떤 노드와도 연결되어 있지 않은 상태(= 본인이 root인 상태)

![image](https://github.com/eunbileeme/algorithm/assets/103405457/05da88b3-b40e-4b79-93ba-3125bc979db4)

2. 노드 1과 3을 연결

![image](https://github.com/eunbileeme/algorithm/assets/103405457/e0d103eb-e30e-4925-bb24-09122c0c9b68)

3. 노드 1, 2, 3이 연결되어 있는 상태
- root : idx와 root의 값이 동일

![image](https://github.com/eunbileeme/algorithm/assets/103405457/3fdbd077-f7e5-47c9-8197-96cffbed2db0)

즉, root를 찾는 과정은 idx와 root의 값이 동일할 때까지 찾아가게 됨
- ex. 2부터 찾을 때 : 2 -> 1 -> 3

![image](https://github.com/eunbileeme/algorithm/assets/103405457/d6b86743-7918-4fef-b206-40d706aa82d7)

결과적으로 다음과 같음
- root를 가리키고 있는 체이닝을 타고타고 가서 찾는 것

![image](https://github.com/eunbileeme/algorithm/assets/103405457/19a0defb-69c9-442e-90e7-e9d27cc87c85)

- root를 호출하는 과정을 할 때마다 최적화를 할 수 있음
  - 어떤 노드에서 root를 찾기 위해 호출할 때마다 최종 root를 return 하도록 구현할 수 있음
  - 즉, 한스텝만에 root를 가리킬 수 있게 되므로..
  - 전체 스캔에 걸리는 O(n)에 비해 O(logn)의 시간 복잡도를 가짐

## 풀이
- disjoint set -> root가 다르다면 섬을 연결할 수 있음

- 노드가 추가될 때마다 섬의 개수는 증가
  - 상/하/좌/우를 탐색하며 섬을 연결하려고 시도
  - 이때, root가 다른 섬을 연결하려고 시도해야 함

![image](https://github.com/eunbileeme/algorithm/assets/103405457/57b12add-8c7e-4945-a174-d6d5289b9672)

### 질문
- root node가 되는 조건이 뭐지? -> 없음
  - 한 덩어리가 되는 것이 중요함
  - 즉, 무방향(=양방향)일 때, p[fp] = tp 또는 p[tp] = fp처럼 뭐가 root node가 되어도 상관이 없음
 
![image](https://github.com/eunbileeme/algorithm/assets/103405457/e75bcc33-56ea-4140-a7a6-f7f62c8e905b)
 
