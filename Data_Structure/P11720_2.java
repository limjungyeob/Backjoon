package Data_Structure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11720_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int sum =0;

        for(byte value : br.readLine().getBytes()){
            sum += (value - '0');
        }
        System.out.println(sum);

    }
}
