class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();

        // 숫자는 0 ~ 9까지
        int[] arrX = new int[10];
        int[] arrY = new int[10];

        // [2, 1, 0, 0, 0, 0, 0, 0, 0, 0]
        countNumInArr(X, arrX);
        // [1, 1, 1, 1, 1, 1, 0, 0, 0, 0]
        countNumInArr(Y, arrY);

        for (int i = arrX.length - 1; i >= 0; i--) {
            // arrX와 arrY에 동일한 숫자가 존재하는 경우 (둘 다 1 이상)
            // X = "100", Y = "123450" --> i = 1, i = 0
            while (arrX[i] >= 1 && arrY[i] >= 1) {
                // 출현 빈도를 각각 감소
                // [2, 0, 0, 0, 0, 0, 0, 0, 0]
                arrX[i]--;
                // [1, 0, 0, 0, 0, 0, 0, 0, 0]
                arrY[i]--;

                // 1
                answer.append(i);
            }
        }

        if (answer.toString().equals("")) {
            return "-1";
        } else if (answer.toString().startsWith("0")) {
            return "0";
        } else {
            return answer.toString();
        }
    }

    private void countNumInArr(String str, int[] arr) {
        for (int i = 0; i < str.length(); i++) {
            // char -> int
            int index = str.charAt(i) - '0';

            // 해당 문자(숫자)의 출현 빈도를 인덱스에 저장
            arr[index]++;
        }
    }
}