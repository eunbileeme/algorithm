// ※ 1(바로 다음)2(바로 다음)3(바로 다음)1의 순을 어떻게 확인하지?

import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int in : ingredient) {
            stack.push(in);
            
            // stack의 size가 4 이상이 됐을 경우, 1-2-3-1 확인 시작
            if (stack.size() >= 4) {
                // 1-2-3-1일 경우
                if (stack.get(stack.size() - 4) == 1
                    && stack.get(stack.size() - 3) == 2
                    && stack.get(stack.size() - 2) == 3
                    && stack.get(stack.size() - 1) == 1) {
                    answer ++;
                    // 가장 최근 element부터 총 4개 삭제
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
                // 아닐 경우, 그 다음 element를 삽입 후, 다시 1-2-3-1인지 확인
            }
        }
        
        return answer;
    }
}