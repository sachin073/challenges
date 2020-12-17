package Circuit_2019.jan19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sachin on 4/2/19.
 */
public class ShiftLetterSol {
    public static void solution(char[] s,int k) {
        int n=s.length;
        int[][][] dp = new int[n][k+1][26];
        for(int i=0;i<=k;i++) {
            for(int j=97;j<123;j++) {
                dp[n-1][i][j-97] = (26+j-s[n-1])%26;
            }
            System.out.println(Arrays.toString(dp[n-1][i]));
        }

        for(int i=n-2;i>=0;i--) {
            for(int j=0;j<=k;j++) {
                for(int x=97;x<123;x++) {
                    dp[i][j][x-97] = dp[i+1][j][x-97]+(26+x-s[i])%26;
                    if(j>0) {
                        for(int y=97;y<123;y++) {
                            if(x==y)
                                continue;
                            dp[i][j][x-97] = Math.min(dp[i][j][x-97], (26+x-s[i])%26+dp[i+1][j-1][y-97]);
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));

        int min = Integer.MAX_VALUE;
        for(int j=0;j<=k;j++) {
            for(int i=0;i<26;i++) {
                min = Math.min(min,dp[0][j][i]);
            }
        }
        System.out.println(min);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new FileReader("src/file_input_package/input.txt"));
        String in = br.readLine();
        char[] s = in.toCharArray();
        int k = Integer.parseInt(br.readLine());
        solution(s,k);
    }
    public static void main(String[] args) throws IOException{
        input();
    }
}
