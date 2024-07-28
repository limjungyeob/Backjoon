package Sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004_v5 {
        public static void quicksort(int[] a, int left, int right) {
            if (left >= right) {
                return;
            }
     
            int pi = partition(a, left, right);
        
            // partition과정을 통해 구한 구분점에 +1한 값과 k를 비교하여 해당하는 부분집합에 대해
            // 재귀호출을 반복한다.
            quicksort(a, left, pi);
            quicksort(a, pi+1, right);
        
        }
        public static int partition(int[] a, int left, int right) {
            // lo와 hi는 각각 배열의 끝에서 1 벗어난 위치부터 시작한다.
            int lo = left - 1;
            int hi = right + 1;
            int pivot = a[(left + right) / 2];		// 부분리스트의 중간 요소를 피벗으로 설정
            
    
            while(true) {
                
                /*
                * 1 증가시키고 난 뒤의 lo 위치의 요소가 pivot보다 큰 요소를
                * 찾을 떄 까지 반복한다.
                */
                do { 
                    lo++; 
                } while(a[lo] < pivot);
    
                
                /*
                * 1 감소시키고 난 뒤의 hi 위치가 lo보다 크거나 같은 위치이면서
                * hi위치의 요소가 pivot보다 작은 요소를 찾을 떄 까지 반복한다.
                */
                do {
                    hi--;
                } while(a[hi] > pivot && lo <= hi);
                
                
                /*
                * 만약 hi가 lo보다 크지 않다면(엇갈린다면) swap하지 않고 hi를 리턴한다.
                */
                if(lo >= hi) {
                    return hi;
                }
                
                
                // 교환 될 두 요소를 찾았으면 두 요소를 바꾼다.
                swap(a, lo, hi);
            }
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
