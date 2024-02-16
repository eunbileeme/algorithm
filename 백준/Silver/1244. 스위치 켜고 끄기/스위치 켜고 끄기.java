import java.io.*;
import java.util.*;

// TODO 남학생 : ex. 3 -> 3, 6의 스위치 상태를 반전
// TODO 여학생 : 본인이 받은 스위치 번호를 중심으로 좌우가 대칭 + 가장 많은 스위치를 포함하는 구간의 스위치 상태를 반전
// TODO ex. 3 -> 1 / 2 / 3 / 4 / 5 -> 1 ~ 5의 스위치 상태를 모두 반전
// TODO ex. 4 -> 4를 기준으로 3번과 5번 스위치가 대칭이 아니므로 4의 스위치 상태만 반전

// TODO (2024.02.16) 구현 1
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchNumber = Integer.parseInt(br.readLine());

        int[] switchStatus = new int[switchNumber + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= switchNumber; i++) {
            switchStatus[i] = Integer.parseInt(st.nextToken());
        }

        int student = Integer.parseInt(br.readLine());
        List<Map<Integer, Integer>> studentSwitch = new ArrayList<>();

        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Map<Integer, Integer> map = new HashMap<>();

            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            map.put(gender, number);

            studentSwitch.add(map);
        }

        changeSwitchStatus(switchNumber, switchStatus, student, studentSwitch);

        int outputLimit = 20;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= switchNumber; i++) {
            sb.append(switchStatus[i]).append(" ");
            // TODO n개씩 잘라서 출력하려면, n개의 배수일 때마다 줄바꿈
            // TODO 예외) (19 + 1) % 20 == 0 -> 한 줄 띄기
            if (i % outputLimit == 0) {
                sb.append("\n");
            }
        }

        // ex. 45와 같이 20 / 20 / 5로 나뉘어져야 할 경우, 5는 따로 처리를 해줘야 할까?
        System.out.println(sb);
        br.close();
    }

    private static int[] changeSwitchStatus(int n, int[] status, int sNum, List<Map<Integer, Integer>> list) {
        for (Map<Integer, Integer> map : list) {
            if (map.containsKey(1)) {
                int value = map.get(1);
                for (int i = 1; i <= n; i++) {
                    if (i % value == 0) {
                        status[i] = (status[i] == 0) ? 1 : 0;
                    }
                }
            } else {
                // TODO 복기하기
                int number = map.get(2);
                int left = number - 1;
                int right = number + 1;

                status[number] = (status[number] == 0) ? 1 : 0; // 해당 번호의 스위치를 반전

                while (left >= 1 && right <= n && status[left] == status[right]) { // 해당 번호를 기준으로 좌우가 대칭하다면, 반전
                    status[left] = (status[left] == 0) ? 1 : 0;
                    status[right] = (status[right] == 0) ? 1 : 0;
                    left--;
                    right++;
                }
            }

        }

        return status;
    }
}
