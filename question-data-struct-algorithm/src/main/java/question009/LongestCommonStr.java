package question009;

/**
 * @author poldi.chen
 * @className LongestCommonStr
 * @description TODO
 * @date 2019/7/11 13:20
 **/
public class LongestCommonStr {

    public int countLongestCommonStr(String str1, String str2) {
        int result = 0;
        int length1 = str1.length();
        int length2 = str2.length();
        int[][] dp = new int[length1+1][length2+1];

        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                if (dp[i][j] > result) {
                    result = dp[i][j];
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        String str1 = "aabbcd";
        String str2 = "bbcd";
        System.out.println(new LongestCommonStr().countLongestCommonStr(str1, str2));
    }
}
