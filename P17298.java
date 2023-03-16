import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class P17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //수열 배열
        int A[] = new int[n];
        //정답 배열
        int ans[] = new int[n];
        String str[] = bf.readLine().split(" ");
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(str[i]);
        }
        Stack<Integer> mStack = new Stack<>();
        mStack.push(0); //init
        for(int i=1; i<n; i++){
            //스택이 비어 있지 않고, 현재 수열이 스택 top 인덱스(정답 -> 오큰수)가 가리키는 수열보다 클 경우
            while(!mStack.isEmpty() && A[mStack.peek()] < A[i]){
                //정답 배열에 오큰수를 저장.
                ans[mStack.pop()] = A[i];
            } 
            //신규 데이터 push
            mStack.push(i);
        }
        //스택에 남은 값이 없어질때가지 반복
        while(!mStack.empty()) {
            //오큰수가 아닌 수열에는 -1
            ans[mStack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<n; i++){
            bw.write(ans[i] + " ");
        }
        bw.flush();
    }
}
