# Review
- ※ constant space : "상수 개수의 공간을 써라." (= "고정된 크기의 공간을 써라.")
  - matrix가 커지든 작아지든 고정된 값의 크기
  - input의 값과 상관 없이 동일한 시간 복잡도를 가짐 

- "in place로 변경해서 풀어라."
  - 0이 있는지 없는지가 중요 -> 캐싱해야

- 1번째 열과 1번째 0을 대표 라인으로 가정
  - 해당 행, 열의 대표 값이므로 -> 따로 캐싱을 진행해야 
  
- 실제로 값을 할당하는 것이 아니라, 대표 라인에만 0이 있는 경우를 캐싱?
  - 확실한 건, 대표 라인은 전체 행, 열을 대표하는 값
    - 하나라도 0이 존재하면 해당 행 or 열은 0으로 채워지게 됨  
 
## 순서
- 하나라도 행 / 열에 0이 있다면 0을 마킹
  - 다른 라인에는 0이 있다면..

## 풀이
- (1) 어딘가에 0이 있을 경우, 0이 위치한 행 열이 모두 0으로 바꾸이어야 함 -> 보통은 가로/세로 길이가 똑같은 1차원 배열을 하나 더 냅두고, 자리에 마킹을 하는 식으로 진행함
- (2) 하지만, 이럴 경우 matrix에 영향을 받으므로 constant space를 쓰기 위해 배열을 선언할 수 없음
- (3) 첫 번째 행과 열을 마킹을 하는 용도로 대신 쓰도록
- (4) 하지만, 해당 행 열에 0이 있을 경우를 대비해 c0 = f과 r0 = t(0이 행에 있을 경우)을 선언
- (5) 첫 번째 행 열을 제외한 공간에 0이 있을 경우 해당 위치를 고려하여 대표 행 열에 마킹을 시작

![image](https://github.com/eunbileeme/algorithm/assets/103405457/f978d8a5-7751-438d-b44e-b8de599150b5)

- (6) 다 끝났다면, 대표 라인을 제외한 나머지 공간에 실제로 공간에 0을 업데이트 -> 단, 마킹이 되어있는 값들에만 0을 업데이트
![image](https://github.com/eunbileeme/algorithm/assets/103405457/d9cc705c-3132-4744-b0cf-27f6a5938cad)

- (7) 대표 라인에 0을 업데이트
![image](https://github.com/eunbileeme/algorithm/assets/103405457/fff562ed-3f66-4a16-aa11-f5e64bc38e36)

- 기존 0을 기준으로 모두 0으로 해당 행 열이 다 업데이트 완료
  - ro, co : 첫 번째 행 또는 열에 있던 0과 구분하기 위해서 사용 
![image](https://github.com/eunbileeme/algorithm/assets/103405457/b77291fb-bdc3-4214-9e09-88ba29c1861a)

![image](https://github.com/eunbileeme/algorithm/assets/103405457/4af74a43-ea50-417a-8ec0-95804ffa8e51)

## 풀이
![image](https://github.com/eunbileeme/algorithm/assets/103405457/3f12e85a-3efe-45f8-b88c-31a9e91ce947)
