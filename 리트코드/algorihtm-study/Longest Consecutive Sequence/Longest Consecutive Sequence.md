# Review
- 요즘 외국계 기업의 빈출 문제
- 시간 복잡도가 O(n)이라면?
  - 중첩 loop는 불가
  - 평균적으로 O(1)의 시간 복잡도를 가지는 자료 구조를 사용해야
  - Set, Map, ..
 
- 즉, 정렬(nlogn)은 사용 불가

![image](https://github.com/eunbileeme/algorithm/assets/103405457/98416ba9-3e50-450a-9662-e2f4684b579b)

## 예제
[3, 4, 5, 6, 7, 8] - seq : 6 [10, 11, 12] - seq : 3

- 이때, 9를 삽입한다면
  - 9-1이 있는지와 9+1이 있는지 확인
  - 있다면 seq를 증가시켜야 함

![image](https://github.com/eunbileeme/algorithm/assets/103405457/6eed6ba8-0cf0-4526-8b25-7bff4fe6031c)

따라서 시작점, 끝점, seq의 값만 알면 update 해줄 수 있음
- 현재까지 존재하는 숫자가 뭐냐?(= key)
  - 현재까지 seq가 몇이냐?(= value) 

## 풀이
![image](https://github.com/eunbileeme/algorithm/assets/103405457/4473b5a4-6060-48a2-b482-40c9dff7306a)
