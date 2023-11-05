# Review
- "부케 하나 당 k개의 꽃이 필요할 때, 최소 m개의 부케를 만들려면 몇 일이 걸리는가?" 
  - 단, 인접한 꽃들로만 만들 수 있음
  - 연속되는 꽃들?

## 풀이
- 꽃이 하나라도 생성되려면 bloomDay 안의 최솟값만큼 시간이 지나야 함
  - // 최댓값
  - 이 사이에서 조건을 만족하기 위한 최솟값을 체크해야 함

- bqCnt : 부케를 만드는데 쓰이는 꽃의 개수
- adjCnt : 인접한 꽃의 개수

![image](https://github.com/eunbileeme/algorithm/assets/103405457/155b37d2-bb9e-4893-b587-4d85ddc6dc46)
![image](https://github.com/eunbileeme/algorithm/assets/103405457/8ca1ebc4-9714-47c6-aab5-d88b118d8e8b)

### 질문
1. 조건을 만족하는 최솟값 -> while (l < r)
2. i --;
