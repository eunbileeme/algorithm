# Review
- 가장 많이 나오는 코딩 테스트 문제
- 하지만, 처음 보는 입장에서는 어려울 수 있는 문제
- 트리 문제 -> 하위 값들(왼쪽, 오른쪽 값)을 어떻게 처리할지 + 위로 무슨 값을 반환할지

## 풀이
- p와 q 중 하나를 만났을 때의 경로를 List로 저장..

![image](https://github.com/eunbileeme/algorithm/assets/103405457/01fbb499-51fb-4e3c-89ba-cff13e3a5f7d)

- 하지만, 이진 탐색 트리는 재귀의 형태로도 생각할 수 있음

![image](https://github.com/eunbileeme/algorithm/assets/103405457/c94c71de-7e66-43da-a91a-374e71288fcd)

- 핵심은 p와 q의 값에 대해서만 관심이 있음
  - 나머지는 다 null이라고 생각해도 무방

- 둘 중 null이 아닌 값을 return(= left만 존재하면 left 자식을 반환, right만 존재하면 right 자식을 반환)
  - 둘 다 null이 아니라면 p, q 또는 q, p인 경우(= left, right 둘 다 존재하면 현재 노드를 반환)
- 즉, 공통 조상을 가지고 있는 경우

![image](https://github.com/eunbileeme/algorithm/assets/103405457/02a3d7a7-026f-4110-a70c-d1d1e17afab3)

![image](https://github.com/eunbileeme/algorithm/assets/103405457/29b2404d-c7e3-4f87-9e0a-f62eaf4cdd9e)

