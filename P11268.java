import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P11268 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> mQueue = new PriorityQueue<>((o1,o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs){
                //절댓값이 같으면 음수 우선 정렬하기
                return o1 > o2 ? 1 : -1;   
            } else {
                //절댓값을 기준으로 정렬하기
                return first_abs - second_abs;
            }
        });

        for(int i =0; i < N; i++) {
            int request = Integer.parseInt(br.readLine());
            if(request == 0) {
                if(mQueue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(mQueue.poll());
                }
            } else {
                mQueue.add(request);
            }
        }
    }
}
