package Data_Structure;
import java.util.Scanner;
import java.util.Stack;

public class P1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i =0; i<N;i++){
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;
        boolean result = true;
        for(int i=0; i<A.length;i++){
            int su = A[i];  //현재 수열의 값
            if(su >= num){
                //현재 수열의 값 >= 오름차순 자연수 -> 값이 같아질 때까지 push() 수행
                while(su >= num){
                    //push
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }else{
                //현재 수열의 값 < 오름차순 자연수 -> pop()을 수행해 수열 원소를 꺼냄.
                int n =stack.pop();
                if(n >su){
                    System.out.println("NO");
                    result =false;
                    break;
                }else{
                    bf.append("-\n");
                }
            }
        }
        if(result){
        System.out.println(bf.toString());
        sc.close();
        }
    }
}
