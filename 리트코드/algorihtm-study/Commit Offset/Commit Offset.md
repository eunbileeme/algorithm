# Review

- "0부터 해당 offset까지의 값들이 모두 있어야 한다."
- 숫자들이 0을 베이스로 해서 다 연결이 되어 있어야 함
  - 한 번 체이닝이 되었다면..
  - ex. 0 ~ 5까지 다 있다면, 이미 다 알고 있기 때문에
    - offset / range가 이미 다 만들어졌기 때문에, 중요하게 생각할 부분이 아님

- 따라서..
- (1) 중간값이 추가됨으로써 체이닝이 될 수 있음
- (2) 즉, 중간값을 기준으로 최소값(왼쪽)과 최대값(오른쪽)을 볼 것

## 풀이

- 기존에 있던 값들도 만들어지는 체이닝 상태를 보면서, 체이닝에 연결될 수 있는지 없는지 확인하는 방식

![image](https://github.com/eunbileeme/algorithm/assets/103405457/4ab8ab08-2f0c-4425-8e79-b41b022233d3)

## 그림
- 만들어진 체이닝의 역순으로 key(배열의 원소) - value(키 값인 배열의 원소를 기준으로 최소값 또는 최대값)을 마킹
- 따라서 중간 값들은 의미가 없고, key를 기준으로 첫 번째 원소와 마지막 원소에 대해 체킹

![image](https://github.com/eunbileeme/algorithm/assets/103405457/134844f4-3156-4391-b4a4-456e1d803106)

- ex. 배열의 원소 중 6이 들어왔을 경우
![image](https://github.com/eunbileeme/algorithm/assets/103405457/c65464a0-15ba-4df2-a98d-d5415ba6a6c1)

- ex. 8이 들어왔을 경우
![image](https://github.com/eunbileeme/algorithm/assets/103405457/a73fc224-7070-4076-b1a4-1c97bcff9a63)

- 결론 : 중간 값들을 제외한 x-1과 x+1을 확인하면 됨
![image](https://github.com/eunbileeme/algorithm/assets/103405457/e1848ade-f02d-44f8-812b-5906e474780e)

