# Review
- 그리디로 푸는 문제
- interval merge로 풀어도 굿
- 2중 for문은 글쎄..?

## 다른 분의 풀이
- 요소별 indices를 구하고 merge interval 하듯 풀이

![image](https://github.com/eunbileeme/algorithm/assets/103405457/0e7f7f95-57fa-4438-9a10-099b08314501)

- a가 다시 나오는 구간까지를 range로 치는데,
  - 핵심) "각각의 문자별로 가장 마지막 index가 어디냐?"
  - 만약, 구간 사이에 위치하던 문자(ex. d가)가 a보다 뒤에 위치한다면 range를 해당 범위까지 늘림
 
## 풀이
![image](https://github.com/eunbileeme/algorithm/assets/103405457/8ca796ee-0ab7-4c3b-ac97-62eeb46a39ae)

1. for문을 통해, 해당 문자의 마지막 인덱스를 저장
2. 주어진 원본 string을 보면서
   - 현재 인덱스가 주어진 max 값보다 작은 경우, 
   - 현재 인덱스가 주어진 max 값보다 큰 경우,
  
