# Review
- prefix sum
  - 예약 n번은 start ~ end까지만 영향을 미침
  - 해당 구간의 시작에서 해당 값을 더하고, 구간이 끝나면 그 값을 빼는 방식
  - "시작 인덱스의 좌석 수 만큼 더하고, 마지막 인덱스를 지나면 좌석 수만큼 빼는 것"
 
- start와 end만큼 loop를 돌면 n*n만큼 도는 반면
  - prefix sum을 사용하면 O(n)
 
## 풀이
- interval의 개념으로 이해
- result array : 특정 범위에서 영향을 끼치기 시작하는 위치 + 영향이 끝난 후의..
  - 가중치만 들어있음
- 가중치를 실제로 반영하는 작업까지 수행한 후 마침

![image](https://github.com/eunbileeme/algorithm/assets/103405457/8a183a33-1bce-437b-acb7-3f67bff06d44)

### Tip
- 구간별로 합이 정해져 있는 문제 -> prefix sum, prefix multiple, .. -> leetcode에 prefix를 검색하여 풀어보는 걸 추천
