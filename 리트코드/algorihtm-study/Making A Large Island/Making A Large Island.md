# Review
![image](https://github.com/eunbileeme/algorithm/assets/103405457/8dc22555-42ca-4f21-8081-c34aa2a8ebfc)

- 섬에다가 idx를 주고, 크기를 따로 저장해서 답을 구하는 것이 best
 - 0번 섬 : 크기 8,
 - 1번 섬 : 크기 6,
 - ..

- grid가 0인 친구들을 위주로 탐색하면서
  - idx 섬의 내부 content를 idx로 채우는 것이 무난 -> 중복 체크도 할 필요가 없어짐

 ## 풀이
 ![image](https://github.com/eunbileeme/algorithm/assets/103405457/683c3dec-fbad-4649-818d-90274847fa36)

 - key : 섬의 idx, value : 섬의 size

- grid = 1 : 아직 세지 않은 상태 -> idx를 가지고 카운트 시작
  - DFS로 모든 섬의 크기를 순회
  - grid가 1이 아닌 경우 : 0이거나 다른 idx를 부여받은 경우이므로 탐색 x
  - 그 외의 경우는 grid를 모두 idx로 채움 
