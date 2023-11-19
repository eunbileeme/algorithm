# Review
- Keypoint : "인접한 두 집을 연속으로 도둑질할 수 없다."
  - DP
  - "현재 위치에 따라 조건값들이 변하는 경우"

## 풀이
- 현재 인덱스를 기준으로, 이전 집과 그 이전의 집에만 관심이 있음
  - 결과 값 : 현재 값 + 전전집까지의 최댓값(= 의 인덱스) vs 전 집만 털 경우(= 의 인덱스)

![image](https://github.com/eunbileeme/algorithm/assets/103405457/aee93324-0785-47ce-9928-268a38a3ff8e)
