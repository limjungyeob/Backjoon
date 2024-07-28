package Data_Structure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //배열크기
        int sizeArray = Integer.parseInt(st.nextToken());
        //질의개수
        int questionNum = Integer.parseInt(st.nextToken());
        int arr[][] = new int[sizeArray+1][sizeArray+1];
        //배열 입력받기.
        for(int i = 1; i <= sizeArray; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= sizeArray; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //구간 합
        int sumArray[][] = new int[sizeArray+1][sizeArray+1];
        for(int i = 1; i <= sizeArray; i++){
            for(int j = 1; j <= sizeArray; j++){
                //구간 합 구하기
                sumArray[i][j] = sumArray[i][j-1] + sumArray[i-1][j] - sumArray[i-1][j-1] + arr[i][j];
            }
        }

        for(int i = 0; i < questionNum; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            //구간 합 배열로 질의에 답변하기
            int result = sumArray[x2][y2] - sumArray[x1-1][y2] - sumArray[x2][y1-1] + sumArray[x1-1][y1-1];
            System.out.println(result);
        }
    }
}
