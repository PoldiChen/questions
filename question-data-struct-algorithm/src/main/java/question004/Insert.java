package question004;

/**
 * @author poldi.chen
 * @className Insert
 * @description TODO
 * @date 2019/5/11 13:49
 **/
public class Insert {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 3, 6, 2};
        numbers = insertSort(numbers);
        for (int a : numbers) {
            System.out.println(a);
        }
    }

    public static int[] insertSort(int[] numbers) {
        int length = numbers.length;
        int insertNumber;
        for (int i = 1; i < length; i++) {
            insertNumber = numbers[i];
            int j = i - 1;
            while (numbers[j] > insertNumber) {
                numbers[j+1] = numbers[j];
                j--;
            }
            numbers[j+1] = insertNumber;
        }
        return numbers;
    }
}
