// 1. 0과 1로 구성된 배열(화단)이 있습니다.
// 2. 정수 n이 주어지면 화단에 n개의 새 꽃을 심을 수 있으면 true를 반환한다.
// 3. 단, 인접 화분에 꽃을 심으면 안된다는 규칙을 위반하면 안됨

// (예제 1)
// flowerbed = [1, 0, 0, 0, 1], n = 1

// (예제 2)
// flowerbed = [1, 0, 0, 0, 1], n = 2

// 2 * 10^4 --> 2 * 10000 = 20000 --> O(n)
// 20,000 * 20,000 = 400,000,000 --> O(n ^ 2) --> 따라서 2중 for문은 안됨

// 그리디?
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) { 
        // 0. 카운트용 변수
        // int cnt = 0;

        // 1. 앞에서부터 처리해야함 --> 그리디
        for (int i = 0; i < flowerbed.length && n > 0; i ++) {
            // 2-1. 현재 원소의 값도 0이면서
            // 2-2. 이전 원소의 값도 0이고
            // 2-3. 다음 원소의 값도 0이라면
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                // 3. 화단에 꽃을 심을 수 있음
                flowerbed[i] = 1;
                // 4. 심어야 하는 꽃의 수 감소
                n --;
                i ++;

                System.out.println("i = " + i);
            }
            
            // 5. n이 0이라면 true 반환
            // if (n == 0) return true;
        }

        // for (int i = 0; i < flowerbed.length; i ++) {
        //     System.out.println(flowerbed[i]);
        // }

        // System.out.println("n = " + n);

        return n == 0;
    }
}