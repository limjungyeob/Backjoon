import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004 {
public static void quickSort(int A[], int S, int E, int K){
    if(S<E) {
        int pivot = partition(A,S,E);
        if(pivot == K) {
            return;
        } 
        //partition 과정을 통해 구한 구분점에 +1한 값과 k를 비교하여 해당하는 부분집합에 대해 재귀호출을 반복한다.
        else if(K < pivot){
            quickSort(A, S, pivot-1, K);
        } else {
            quickSort(A, pivot+1, E, K);
        }
    }
}
public static int partition(int A[], int S, int E){
    if(S+1 == E){
        if(A[S] > A[E]) {
            swap(A, S, E);  //중앙 값을 첫 번째 요소로 이동
        }
        return E;
    }
    int M = (S+E) /2;
    swap(A,S,M);
    int pivot  = A[S];
    int i = S;
    int j = E;
    while(i < j) {
        while(pivot < A[j]) {   //j는 오른쪽에서 왼쪽으로 피봇보다 작거나 같은 값을 찾는다.
            j--;
        }

        while(i < j && pivot >= A[i]) { //i는 왼쪽에서 오른쪽으로 피봇보다 큰 값을 찾는다.
            i++;
        }
        swap(A,i,j);    //칮은 i와 j를 교환
    }

    //반복문을 벗어난 경우는 i와 j가 만난경우 피봇과 교환.
    A[S] = A[i];
    A[i] = pivot;
    return i;
}
public static void swap(int A[], int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
}
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int A[] = new int[n];
        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(A, 0 , n-1, k-1);
        System.out.println(A[k-1]);
    }
}
