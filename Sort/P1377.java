package Sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1377 {
    public static void main(String[] args) throws IOException{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buf.readLine());
        mData A[] = new mData[N];
        for(int i=0; i<N; i++){
            A[i] = new mData(Integer.parseInt(buf.readLine()), i);
        }
        Arrays.sort(A);

        int max = 0;
        for(int i=0; i<N; i++){
            if(A[i].index -i > max) {
                max = A[i].index-i;
            }
        }
        System.out.println(max+1);

    }

}

class mData implements Comparable<mData> {
    int value;
    int index;
    
    public mData(int value, int index){
        super();
        this.value = value;
        this.index = index;
    }
    @Override
    public int compareTo(mData o){
        return this.value -o.value;
    }
}

