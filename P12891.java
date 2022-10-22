import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891 {
    static int checkArr[];
    static int myArr[];
    static int checkSecreat;

    //새로 들어온 문자를 처리하는 함수
    private static void Add(char c){
        switch(c){
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0]){
                    checkSecreat++;
                }
                break;

            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]){
                    checkSecreat++;
                }
                break;

            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]){
                    checkSecreat++;
                }
                break;
            
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]){
                    checkSecreat++;
                }
                break;
        }

    }

    //제거되는 문자를 처리하는 함수
    private static void Remove(char c){
        switch(c){
            case 'A':
                if(myArr[0] == checkArr[0]){
                    checkSecreat--;
                }
                myArr[0]--;
                break;

            case 'C':
                if(myArr[1] == checkArr[1]){
                    checkSecreat--;
                }
                myArr[1]--;
                break;

            case 'G':
                if(myArr[2] == checkArr[2]){
                    checkSecreat--;
                }
                myArr[2]--;
                break;
            
            case 'T':
                if(myArr[3] == checkArr[3]){
                    checkSecreat--;
                }
                myArr[3]--;
                break;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Result = 0;
        char A[] = new char[S];
        checkArr = new int[4];
        myArr = new int[4];
        checkSecreat = 0;
        A = bf.readLine().toCharArray();
        //.toCharArray는 문자열을 한 글자씩 쪼개서 char타입의 배열에 집어넣어준다.
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0){
                checkSecreat++;
            }
        }
        //초기 P 부분 문자열 처리 부분
        for(int i=0; i<P; i++){
            Add(A[i]);
        }
        if(checkSecreat == 4){
            Result++;
        }
        // 슬라이딩 윈도우 처리 부분
        for(int i=P; i<S; i++){
            int j = i-P;
            Add(A[i]);
            Remove(A[j]);
            //4자릿수와 관련된 크기가 모두 충족될 때 유효한 비밀번호
            if(checkSecreat == 4){
                Result++;
            }
        }
        System.out.println(Result);
        bf.close();
    }
}
