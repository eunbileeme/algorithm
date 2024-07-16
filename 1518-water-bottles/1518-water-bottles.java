// 1. 물로 가득한 numBottles개의 물명이 있다.
// 2. 시중에서 판매하는 numExchange 빈 물병을 가득 찬 물병 1개로 교환할 수 있다.
// 3. 물병을 가득 채우는 작업을 수행하면 빈 병이 된다.

// (예제 1)
// numBottles = 9, numExchange = 3
// 빈 병 세 개를 교환하면 가득찬 물 병 1개로 교환할 수 있다.
// 마실 수 있는 물병 수 : 9 + 3 + 1 = 13

// (예제 2)
// numBottles = 15, numExchange = 4
// 빈 병 네 개를 가득찬 물 병 1개로 교환할 수 있다.
// 마실 수 있는 물병 수: 15 + 3 + 1 = 19

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // 1. 반환할 마실 수 있는 물병의 수
        // 이때, 기본적으로 numBottles의 값으로 초기화
        int ans = numBottles;

        // 2. 
        while (numBottles >= numExchange) {
            ans += numBottles / numExchange;
            numBottles = (numBottles / numExchange) + (numBottles % numExchange); 
        }

        return ans;
    }
}