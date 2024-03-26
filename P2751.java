public class P2751 {
    private static int tmpArr[]; //합치는 과정에서 정렬하여 원소를 담을 임시 배열
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

        while(l <= mid && r <= right) {
            /*
		    *  왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
		    *  왼쪽의 l번째 원소를 새 배열에 넣고 l과 idx를 1 증가시킨다.
		    */
            if(a[1] <= a[r]) {
                tmpArr[idx] = a[l];
                idx++;
                l++;
            }
            /*
			 *  오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같을 경우
			 *  오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가시킨다.
			 */
            else {
                tmpArr[idx] = a[r];
                idx++;
                r++;
            }

        }
        /*
		 * 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
		 * = 오른쪽 부분리스트 원소가 아직 남아있을 경우
		 * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
		 */
        if(l > mid) {
			while(r <= right) {
				tmpArr[idx] = a[r];
				idx++;
				r++;
			}
		} else {
			while(l <= mid) {
				tmpArr[idx] = a[l];
				idx++;
				l++;
			}
		}

        /*
		 * 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
		 */
        for(int i = left; i <= right; i++) {
			a[i] = tmpArr[i];
		}
    }

}
