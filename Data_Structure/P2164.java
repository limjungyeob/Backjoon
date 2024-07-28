package Data_Structure;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        Queue <Integer> que = new LinkedList<>();
        int N = sn.nextInt();
        try {
           for(int i=1; i <= N; i++){
            //카드를 큐에 저장하기.
            que.add(i);
        }
        //카드가 1장 남을 때까지
        while(que.size() > 1) {
            //맨 위 카드를 반환.
            que.poll();
            //맨 위 카드를 가장 아래 카드 밑으로 이동.
            que.add(que.poll());
        }
        
        System.out.println(que.poll()); 
        } catch (Exception e) {
           e.printStackTrace();
        }
        sn.close();
        

    }
    
}
