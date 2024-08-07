package Sort;
import java.util.Scanner;

public class P1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int A[] = new int[str.length()];
        try{
            for(int i=0; i<str.length(); i++){
                        A[i] = Integer.parseInt(str.substring(i, i+1));
            }
            for(int i=0; i<str.length(); i++) {
                int max =i;
                for(int j=i+1; j<str.length(); j++) {
                    //내림차순이므로 최댓값을 찾음
                    if(A[j] > A[max]) {
                         max = j;
                    }
                }

                if(A[i] < A[max]) {
                    int temp = A[i];
                    A[i] = A[max];
                    A[max] = temp;
                }
                        
            }
            
            for(int i=0; i<str.length(); i++) {
                System.out.print(A[i]);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        sc.close();
        
    }
}

