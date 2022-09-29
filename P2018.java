import java.util.Scanner;

public class P2018 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;
        try {
            while(end_index != N){
                //sum == N: end_index++; sum = sum + end_index; count++;
                if(sum == N){
                    count ++;
                    end_index++;
                    sum = sum + end_index;
                }else if(sum > N){
                    //sum > N : sum = sum -start_index; start_index++;
                    sum = sum - start_index;
                    start_index++;
                }else{
                    //sum < N: end_index++; sum = sum + end_index++;
                    end_index++;
                    sum = sum + end_index;
                }
            }
            System.out.println(count);
        } catch (Exception e) {
            
        }finally{
            sc.close();
        }
    }
}
