# Review
- 전형적인 투 포인터 문제
- 이미 (오름차순으로) 정렬이 되어 있으므로 -> 풀이는 더 빠르게 진행되어야 함
- nums1 배열을 재활용해서 써야 함 -> 출력 시, 맨 앞에서 채워야 하는 값이 nums2 값 -> 앞에서 채우기가 애매 -> 따라서 뒤에서부터 채운다는 생각

## 투 포인터
- 두 개의 값을 비교해서, 어딘가에 적어주는 문제

## 풀이
- i1 : n - 1 (nums1 배열에서 0을 제외한 맨 뒤의 값) // read 인덱스
- i2 : n - 1 (nums2 배열에서 맨 뒤의 값) // read 인덱스
- i : 실제 인덱스 // write 인덱스
![image](https://github.com/eunbileeme/algorithm/assets/103405457/fcf60065-1454-4ee1-ae69-78523da64cf8)

### 비슷한 문제
- Merge k Sorted List(Hard)
