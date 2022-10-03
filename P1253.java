import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        long A[] = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            A[i] = Long.parseLong(st.nextToken());
        }

        //정렬
        Arrays.sort(A);

        //K가 N까지 반복
        for(int k=0; k<N; k++){
            long find = A[k];
            int i = 0;
            int j = N-1;
            //투 포인터 알고리즘
            while(i < j){

                if(A[i] + A[j] == find){
                    if(i != k && j != k){
                        result++;
                        break; 
                    }else if(i==k){
                        i++;
                    }else if(j==k){
                        j--;
                    }
                }else if(A[i] + A[j] < find){
                    i++;
                }else{
                    j--;
                }
                    
            }
        }

        System.out.println(result);
        br.close();
    }
}
