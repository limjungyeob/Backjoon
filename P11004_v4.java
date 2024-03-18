import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004_v4 {
        public static void quicksort(int[] a, int left, int right) {
            if (left >= right) {
                return;
            }
     
            int pi = partition(a, left, right);
        
            // partition과정을 통해 구한 구분점에 +1한 값과 k를 비교하여 해당하는 부분집합에 대해
            // 재귀호출을 반복한다.
            quicksort(a, left, pi -1);
            quicksort(a, pi, right);
        
        }
        public static int partition(int[] a, int left, int right) {
            int midP = a[(left + right) / 2];
            while (left <= right) {
                while (a[left] < midP) {
                    left++;
                }
                while (a[right] > midP) {
                    right--;
                }
                if(left <= right) {
                    swap(a, left, right);
                    left++;
                    right--;
                }
            }
            return left;
        }
        public static void swap(int[] array, int a, int b) {
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }

    	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
			int arr[] = new int[n];
			 
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				 
			}
			 
			quicksort(arr,0,n-1);
		       
			System.out.println(arr[k-1]); 
		}
}
