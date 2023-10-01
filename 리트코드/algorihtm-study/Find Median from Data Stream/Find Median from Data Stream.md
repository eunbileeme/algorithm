# Review
- median(중앙값) 문제
- 5 * 10^4..

- addNum 또는 findMedian 중 어떤 것을 더 자주 호출하냐에 따라 문제 풀이가 달라짐
  - '어디에서 정렬을 수행할 것인가?' 
  - 코딩 테스트보다는 인터뷰에 적합한 문제

## 해석
- 최소, 최대 힙을 두는 풀이가 무난
  - '데이터를 넣을 때마다 두 개의 큐의 원소 갯수를 최대 1개씩 차이날 수 있도록 푸는 것'
 
- ArrayList는 O(n)으로 비효율적
  - LinkedList 및 Map의 조합으로 구현했으면 O(1)으로 효율적이었을 것  
 
## 풀이
- lower가 늘 element를 하나씩 더 가지도록
![image](https://github.com/eunbileeme/algorithm/assets/103405457/d757be36-7e21-4e2a-ba4f-bd6eaa95ccc1)
