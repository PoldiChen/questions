package question010;

/**
 * @author poldi.chen
 * @className Maze
 * @description TODO
 * @date 2019/7/11 14:43
 **/
public class Main {

    public int dfs(int[] numbers, int n) {
        if (n == 1) { // 只剩一个数字
            if (numbers[0] == 24) {
                return 1;
            } else {
                return 0;
            }
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int a = numbers[i];
                int b = numbers[j];
                numbers[j] = numbers[n-1];
                numbers[i] = a + b;
                if (dfs(numbers, n-1) == 1) {
                    System.out.println(a + "+" + b);
                    return 1;
                } else {
                    numbers[i] = a - b;
                    if (dfs(numbers, n-1) == 1) {
                        System.out.println(a + "-" + b);
                        return 1;
                    } else {
                        numbers[i] = a * b;
                        if (dfs(numbers, n-1) == 1) {
                            System.out.println(a + "*" + b);
                            return 1;
                        } else {
                            if (b != 0) {
                                numbers[i] = a / b;
                                if (dfs(numbers, n-1) == 1) {
                                    System.out.println(a + "/" + b);
                                    return 1;
                                } else {
                                    numbers[i] = b - a;
                                    if (dfs(numbers, n-1) == 1) {
                                        System.out.println(b + "-" + a);
                                        return 1;
                                    } else {
                                        if (a != 0) {
                                            numbers[i] = b / a;
                                            if (dfs(numbers, n-1) == 1) {
                                                System.out.println(b + "/" + a);
                                                return 1;
                                            }
                                        }

                                    }
                                }
                            }


                        }
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 6, 10};
        System.out.println(new Main().dfs(numbers, 4));
    }

}
