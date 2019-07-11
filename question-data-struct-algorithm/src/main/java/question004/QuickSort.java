package question004;

public class QuickSort {

    public static int[] quickSort(int[] numbers, int left, int right) { // 快排算法
        int middle, temp;
        int i = left;
        int j = right;
        middle = numbers[(i+j)/2];
        do {
            while (numbers[i] < middle && i < right) i++; // 找出左边比中间值大的数
            while (numbers[j] > middle && j > left) j--; // 找出右边比中间值小的数
            if (i <= j) { // 将左边大的数和右边小的数进行替换
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
                j--;
            }
        } while (i <= j); // 当两者交错时停止
        if (i < right) {
            quickSort(numbers, i, right);
        }
        if (j > left) {
            quickSort(numbers, left, j);
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = new int[] {1,3,5,2,4};
        int[] sorted = quickSort(numbers, 0, numbers.length-1);
        for (int i : sorted) {
            System.out.println(i);
        }
    }

}
