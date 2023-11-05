# Review
- 배열을 정수 단위로 읽을 때, 이빨 빠진 요소가 있다면 해당 요소를 리턴
- ex. [1, 2, 0]
  - 1 -> 2 -> "3"이 없음
  - 3을 리턴
 
- 아이디어를 찾는게 중요한 문제
  - "배열 안에 있는 원소들의 위치가 정해져있다."
  - 1은 첫 번째에 위치해야 하고, 2는 두 번째에 위치해야 하고,..
- 따라서 위치를 찾을 때까지 요소 간에 swap을 진행

![image](https://github.com/eunbileeme/algorithm/assets/103405457/4fb95f2b-c11f-4b0c-8496-be2804e09647)

## 풀이
- nums[nums[i] - 1] != nums[i] 
  - ex. 인덱스 5에 들어있는 숫자가 6이니?

![image](https://github.com/eunbileeme/algorithm/assets/103405457/a667fa80-c934-478d-a48b-2df17fa7900b)
