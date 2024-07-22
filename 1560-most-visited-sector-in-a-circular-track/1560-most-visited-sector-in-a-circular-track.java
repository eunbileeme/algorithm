class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        // 1. 방문한 트랙을 담을 리스트
        List<Integer> l = new ArrayList<>();

        // 2. 시작과 끝 지점 설정
        int a = rounds[0];
        int b = rounds[rounds.length - 1];

        // 3. 시작 트랙이 끝 트랙보다 작거나 같다면
        // 순차적으로 방문
        if (a <= b) {
            helper(a, b, l);
        } 
        // Q. 어떤 케이스가 있을 수 있을까?
        else {
            helper(1, b, l);
            helper(a, n, l);
        }

        return l;
    }

    private void helper (int a, int b, List<Integer> l) {
        for (int i = a; i <= b; i ++) {
            l.add(i);
        }
    }
}