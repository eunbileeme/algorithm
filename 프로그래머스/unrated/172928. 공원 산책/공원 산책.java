// ※ N or S 이동 시, "X"가 범위 내에 있는지 아닌지 어떻게 판단하지?

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int sx = 0;
        int sy = 0;
        
        char[][] arr = new char[park.length][park[0].length()];
        for (int i = 0; i < park.length; i ++) {
            // arr[0] = ['S', 'O', 'O']
            // arr[1] = ['O', 'O', 'O']
            // arr[2] = ['O', 'O', 'O']
            arr[i] = park[i].toCharArray();
            // park[0] = "SOO".contains("S")
            if (park[i].contains("S")) {
                // sy = 0 ("S"가 위치한 행)
                sy = i;
                // sx = 0 ("S"가 위치한 열)
                sx = park[i].indexOf("S");
            }
        }
        
        for (String st : routes) {
            // way = "E"
            String way = st.split(" ")[0];
            // len = 2
            int len = Integer.parseInt(st.split(" ")[1]);
            
            // sx, sy는 시작점
            int nx = sx;
            int ny = sy;
            
            // len = 2, i = 0, 1
            for (int i = 0; i < len; i ++) {
                // i = 0
                // i = 1
                if (way.equals("E")) {
                    // nx = 1
                    // nx = 2
                    nx ++;
                }
                if (way.equals("W")) {
                    nx --;
                }
                if (way.equals("S")) {
                    ny ++;
                }
                if (way.equals("N")) {
                    ny --;
                }
                // nx = 1
                // nx = 2
                if (nx >= 0 && ny >= 0 && nx < arr[0].length && ny < arr.length) {
                    // arr[0][1] == 'X'
                    // arr[0][2] == 'X'
                    if (arr[ny][nx] == 'X')
                        break;
                    // i = 0, len - 1 = 1
                    // i = 1
                    if (i == len - 1) {
                        sx = nx;
                        sy = ny;
                    }
                }
            }
        }
        
        return new int[]{sy, sx};
    }
}