import java.io.*;
import java.util.*;

// TODO 1. 전위순회한 결과들을 기반으로 트리를 구성한다.
// TODO 1-1. 이때, 전위 순회(루트 - 왼쪽 - 오른쪽)순을 기반으로 트리를 구성 -> 재귀로 구성하는게 제일 무난할 것 같은데?
// TODO 1-2. 즉, 첫 번째 값을 부모 노드로 지정하고 좌/우의 자식 노드를 구성
// TODO 2. 해당 트리를 바탕으로 트리 순회
public class Main {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) { // 자식 없는 노드
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        void insert(int n) {
            if (n < this.val) { // 새로 들어온 값이 루트 노드보다 작다면
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }

    static void postorder(Node current) {
        if (current == null) {
            return;
        }

        postorder(current.left);
        postorder(current.right);
        System.out.println(current.val);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String str;
//        List<Integer> nodes = new ArrayList<>(); 굳이 List에 저장할 필요 없이 바로바로?

        while ((str = br.readLine()) != null) { // 대입 연산자는 우선순위가 낮으므로, String 보다 boolean 연산을 먼저 수행하여 boolean으로 판단
            int val = Integer.parseInt(str);
            root.insert(val); // 새로운 값을 이진 탐색 트리에 삽입
        }

        postorder(root); // 후위 순회 진행
    }
}
