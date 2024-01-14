# Review
- 문제에 이미 시간 복잡도가 적혀있다면, ..
  - set, map, 배열
 
- 랜덤하게 인덱스를 기준으로 호출하려면, 모든 원소들이 다 붙어있어야 함
  - insert 및 random()만 있다면 ArrayList을 기반으로 구현하겠지만?
  - remove()의 경우, O(n)의 시간이 걸리기 때문에..
    - 따라서 ArrayList를 기준으로 remove()를 어떻게 구현할지가 난관
   
- 즉, 맨 마지막 원소를 삭제하면 O(1)의 시간 복잡도로 만들 수 있음
  - 문제에서는 Set을 지원 -> 중복되는 원소가 없음

- 가운데 원소를 지우고 싶다면 마지막 원소와 자리를 바꾸고 지우는 방향으로 처리 가능

- random() : 랜덤한 인덱스를 생성해서 리턴 해줘야 하므로 ArrayList를 무조건 써야함
  - ArrayList = random() + insert() + / remove(맨 뒤의 원소와 중간 원소를 바꿔서 어딘가 캐싱해둬야지!)
 
## 풀이
- list.set(idx, lastVal) : 지우려고 하는 원소를 셋업

![image](https://github.com/eunbileeme/algorithm/assets/103405457/6c1638e3-6e75-4b05-8994-edb6c14e8950)

### 질문
1. Map만 쓴다면?
- idx를 기반으로 하는 Collection이 아니기 때문에, random()을 구성시킬 수 없음
