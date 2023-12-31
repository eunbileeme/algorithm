# Review
- 문자열 문제가 아닌 그래프 문제
  - wordlist에 들어있는 원소의 수는 정해져있고, 이동할 수 있는 원소의 수는 정해져 있음
    - 단, 이때 wordlist의 원소들은 노드들이라고 생각
   
- eng char의 수는 정해져 있기 때문에, 직접 순회해도 되고..

- 답이 없는 경우가 있기 때문에, 미리 그래프를 만들어 놓는 것보다
  - 그때그때 그래프에 추가하는 방식이 효율적
 
## 풀이
- 효율적인 중복 체크를 위해 Set 사용

![image](https://github.com/eunbileeme/algorithm/assets/103405457/e9d406db-64a9-4d6c-9d99-24c3c4dae758)

- 시간 복잡도를 줄이기 위해 a ~ z의 모든 문자를 만들어주는 작업이 필요

![image](https://github.com/eunbileeme/algorithm/assets/103405457/8054e8d7-ad1c-4a35-94ba-f31de0b7f7de)

![image](https://github.com/eunbileeme/algorithm/assets/103405457/461f4b78-14b2-4d18-a18c-ab3dc4429c83)
