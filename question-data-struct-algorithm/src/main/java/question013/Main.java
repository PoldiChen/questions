package question013;

/**
 * @author poldi.chen
 * @className Maze
 * @description TODO
 * @date 2019/7/11 15:21
 **/
public class Main {

    public int countStrDistance(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[][] dp = new int[chars1.length+1][chars2.length+1];

        for (int i = 0; i < chars1.length+1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < chars2.length+1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                if (chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }

//        for (int[] arr : dp) {
//            System.out.println(Arrays.toString(arr));
//        }

        return dp[chars1.length-1][chars2.length-1];
    }

    public static void main(String[] args) {
        String str1 = "abcdefg";
        String str2 = "abc";
        System.out.println(new Main().countStrDistance(str1, str2));
    }
}
