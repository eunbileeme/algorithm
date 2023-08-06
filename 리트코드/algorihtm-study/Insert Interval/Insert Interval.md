# Review
![image](https://github.com/eunbileeme/algorithm/assets/103405457/fcd0875a-1a81-49f7-a21a-b5be5b804936)
- 이미 정렬이 되어 있다면, 다시 정렬을 하지 않아도 될 필요가 많음 -> insert 후 다시 정렬(nlogn)

## 결론
### 1. 겹치지 않으면서 앞에 있는 값들 -> insert
### 2. 겹치는 값들 -> newinterval을 기준으로 merge
### 3. 나머지 값들 -> insert
![image](https://github.com/eunbileeme/algorithm/assets/103405457/7bee79d2-d773-4af8-b047-e4c4bd1c1162)

## 풀이
### 시간 복잡도 : O(n)
![image](https://github.com/eunbileeme/algorithm/assets/103405457/3f59e286-137b-4906-ba8a-dbf296f75977)
