package Data_Structure;
import java.util.Scanner;

public class P11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
        int N = sc.nextInt();
        //입력값을 String형 변수 sNum에 저장한 후 char[]형 변수로 변환하기
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for(int i = 0; i< cNum.length || i<N;i++){
            sum += cNum[i] - '0';   //cNum[i]를 정수형으로 변환하면서 snum에 더하여 누적하기
        }
        System.out.print(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sc.close();
        }
        
     }
}
