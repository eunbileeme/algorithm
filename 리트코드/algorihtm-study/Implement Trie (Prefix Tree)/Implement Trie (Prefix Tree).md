# Review
- 빈출 문제
- 일반적인 트라이(Trie) 자료구조 문제
- 하나의 문자가 입력될 때마다 관련된 모든 형태가 노출 -> 이걸 tree로 만듦

![image](https://github.com/eunbileeme/algorithm/assets/103405457/d8c228dc-f829-4b21-96ee-6a6c296611f5)

![image](https://github.com/eunbileeme/algorithm/assets/103405457/1b0ea0a5-1f49-49ff-82b4-3a100d4a7928)

- 즉, character 하나하나가 node가 됨
- 단어를 하나씩 찾을 때마다 찾았다는 표시의 boolean 값을 표기

 ![image](https://github.com/eunbileeme/algorithm/assets/103405457/5461d866-949b-419d-8b37-3a99b6439281)

## 풀이
![image](https://github.com/eunbileeme/algorithm/assets/103405457/26d32e96-96f5-4f62-882b-f034bbf8cb5a)

- startWith은 있는지 없는지만 확인하면 됨
  - 예 : cat이 있는지 없는지
 
- 배열은 알고리즘용으로 사용
  - 보통은 Map<character, Node>로 사용?

![image](https://github.com/eunbileeme/algorithm/assets/103405457/f369ee50-3ac1-4983-a1b4-21f2400e873f)
