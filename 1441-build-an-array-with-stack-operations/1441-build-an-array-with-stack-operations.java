class Solution {
    public List<String> buildArray(int[] target, int n) {
        // 1. 스택의 연산 결과를 담을 결과 리스트
        List<String> ans = new ArrayList<>();

        // 2. 스택 s
        Stack<Integer> stack = new Stack<>();

        // 3. target 배열을 조작할 인덱스
        int idx = 0;

        // 3. range [1, n]을 순회하면서
        for (int i = 1; i <= n; i ++) {
            // 스택의 원소와 target 배열의 맨 마지막 값과 동일하다면 종료
            if (!stack.isEmpty() && stack.peek() == target[target.length - 1]) return ans;

            // 스택에 값을 삽입
            stack.push(i);
            ans.add("Push");

            // "값을 삽입 후", target 배열의 값과 비교
            // 이때, 값이 다르다면 pop
            if (stack.peek() != target[idx]) {
                stack.pop();
                ans.add("Pop");
            } else {
                // "값이 같을 경우", 다음 target 배열의 원소를 비교하기 위해 idx ++;
                idx ++;
            }
        }

        return ans;
    }
}