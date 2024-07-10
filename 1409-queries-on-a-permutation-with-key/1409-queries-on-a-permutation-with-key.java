// 현재 i에 대해 순열 P에서 쿼리[i]의 위치(0부터 인덱싱)를 찾은 다음 이를 순열 P의 시작 부분으로 이동합니다.
// P에서 쿼리[i]의 위치는 쿼리[i]에 대한 결과임을 알 수 있습니다.
// 주어진 쿼리에 대한 결과가 포함된 배열을 반환합니다.

class Solution {
    public int[] processQueries(int[] queries, int m) {
        // 1. P에서 queries[i]의 값의 인덱스를 담을 출력용 배열
        int[] ans = new int[queries.length];

        // 2. 값을 옮기고, 밀 순열 P를 리스트로 선언
        List<Integer> p = new ArrayList<>();
        for (int i = 1; i <= m; i ++) {
            p.add(i);
        }

        // 3. ans 인덱스를 조작할 변수
        int idx = 0;

        // 4. queries를 순회하면서
        for (int i = 0; i < queries.length; i ++) {
            int query = queries[i];
            // 5. p 리스트에서 query 값을 찾아 인덱스를 가져오기
            int pIdx = p.indexOf(query);
            // 6. 해당 원소의 인덱스값을 ans에 저장
            ans[idx] = pIdx;
            // 7. 해당 원소를 리스트의 맨 앞으로 이동
            p.add(0, p.remove(pIdx));
            // 8. idx 증가
            idx++;
        }

        return ans;
    }
}