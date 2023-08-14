import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // ※ bw.write() : 버퍼에 출력문을 저장
        bw.write("Hello World!");
        // ※ bw.flush() : 버퍼에 담긴 모든 문자열을 출력
        bw.flush();
        
        bw.close();
    }
}
