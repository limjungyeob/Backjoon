import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P10989_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        int[] sortArr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        sortArr = sort(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(sortArr[i]);
        }

    }

    public static int[] sort(int[] arr, int len) {
        Queue<Integer>[] qu = new LinkedList[10];
        int div = 1;
        int maxLen = maxCount(arr);

        for (int i = 0; i < 10; i++) {
            qu[i] = new LinkedList<>();
        }

        for (int m = 0; m < maxLen; m++) {
            for (int i = 0; i < len; i++) {
                qu[(arr[i] / div) % 10].add(arr[i]);
            }

            for (int i = 0, j = 0; i < 10; ++i) {
                while (!qu[i].isEmpty()) {
                    arr[j++] = qu[i].poll();
                }
            }
            div *= 10;
        }
        return arr;

    }

    private static int digitCount(int num) {
        if (num == 0) {
            return 1;
        }

        return (int) Math.floor(Math.log10(Math.abs(num))) + 1;
    }

    private static int maxCount(int[] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (max < digitCount(arr[i]))
                max = digitCount(arr[i]);
        }

        return max;
    }
}
