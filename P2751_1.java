

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2751_1 {
    private static int sorted[] = new int[10000]; //합치는 과정에서 정렬하여 원소를 담을 임시 배열

    public static void main(String[] args) throws IOException,NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(arr, 0, N-1 );
        for(int i=0; i<arr.length; i++) {
            bw.write(arr[i] +"\n");
        }
        bw.close();
        
    }

    //Top-Down 방식 구현
    private static void merge_sort(int a[], int left, int right) {
        /*
		 *  left==right 즉, 부분리스트가 1개의 원소만 갖고있는경우 
		 *  더이상 쪼갤 수 없으므로 return한다.
		 */
        // if(left == right) return;
        if(left < right) {
            int mid = (left + right) / 2;   //절반 위치

            merge_sort(a, left, mid);       //전반 중 왼쪽 부분 리스트(left ~ mid)
            merge_sort(a, mid+1, right);    //절반 중 오른쪽 부분리스트(mid+1 ~ right)

            merge(a, left, mid, right);     //병합
        }

    }


    /**
     * 부분리스트는 a배열의 left ~ right 까지이다. 
     * 
     * @param a		정렬할 배열
     * @param left	배열의 시작점
     * @param mid	배열의 중간점
     * @param right	배열의 끝 점
     */

    private static void merge(int a[], int left, int mid, int right) {
        int l = left;		// 왼쪽 부분리스트 시작점
        int r = mid +1;	    // 오른쪽 부분리스트의 시작점 
        int idx = left;     // 채워넣을 배열의 인덱스

        //분할 정렬된 a[]의 합병
        while(l <= mid && r <= right) {
            if(a[l] <= a[r]) {
                sorted[idx++] = a[l++];
            } else {
                sorted[idx++] = a[r++];
            }
        }
        
        //남아 있는 레코드의 일괄 복사
        if(l < mid) {
            for(int tr=r; tr<=right; tr++) {
                sorted[idx++] = a[tr];
            }
        } else {
            for(int tl=l; tl<=mid; tl++) {
                sorted[idx++] = a[tl];
            }
        }
        for(int i=left; i<=right; i++) {
			a[i] = sorted[i];
		}
    }
}