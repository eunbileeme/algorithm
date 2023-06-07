class Solution {
    public long solution(long n) {
        // 일반적으로 아래와 같은 형 변환은 데이터 손실의 우려가 있음
        // 하지만, 이 경우 제곱근의 정수 부분만 필요하므로 상관 x
        long x = (long) Math.sqrt(n);
        
        if (x * x == n) {
            return (x + 1) * (x + 1);
        }
        return -1;
    }
}