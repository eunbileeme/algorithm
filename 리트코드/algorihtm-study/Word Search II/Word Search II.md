# Review
- Trie를 쓰기에 아주 적합한 문제
  - 단어가 앞에서부터 순서대로 char들이 연결되어 있고..
  - 배열에서 각 element들을 찾을 수 있는가 없는가? 

- 'words의 단어는 한 번 이상 사용되지 않는다.'
  - 중복을 해결해야 -> Trie 사용 시, 해결
 
- 보드에서 한 칸 이동한다 = Trie에서 다음 노드로 이동한다
  - Trie가 존재하는 경우에만 이동 = 노드가 존재하면 다음 단어로 진행
 
- DFS로 풀되, DFS의 이동 조건이 Trie

### 시간 복잡도
- O(mnk)

## 풀이
- 결과적으로 words를 찾아야 하기 때문에, word를 기준으로 Trie를 만듦

- Trie는 기본적으로 LinkedList
  - 단어를 return 해야 하므로 단어는 저장할 필요가 있음
- 백트래킹은 메서드 초반부에 바운더리 체크를 진행
  - if (y < 0 || ..) 

![image](https://github.com/eunbileeme/algorithm/assets/103405457/80708aa1-1063-4d81-9723-870302605396)
![image](https://github.com/eunbileeme/algorithm/assets/103405457/3e384b68-bbdf-4ed0-af6a-ed0dd58a5a6b)
