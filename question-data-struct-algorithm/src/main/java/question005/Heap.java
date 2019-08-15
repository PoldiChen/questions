package question005;

import java.util.Arrays;

/**
 * @author poldi.chen
 * @className Heap
 * @description TODO
 * @date 2019/8/14 23:15
 **/
public class Heap {

    public static void buildHeap(int[] numbers) {
        for (int i = numbers.length / 2 - 1; i >= 0; i--) {
            System.out.println(i);
            adjustDown(numbers, i, numbers.length);
        }
    }

    public static void adjustDown(int[] numbers, int i, int length) {
        int temp;
        int j;
        temp = numbers[i];
        for (j = i*2+1; j < length; j = 2*j+1) { // i*2+1为i的左子节点
            if (j+1 < length && numbers[j+1] > numbers[j]) { // 右子节点更大
                j++;
            }
            if (numbers[j] <= temp) { // 叶子节点比当前节点小，不需要再调整
                break;
            } else {
                numbers[i] = numbers[j];
                i = j;
            }
        }
        numbers[i] = temp;
    }


    public static void main(String[] args) {
        int[] numbers = {45,36,18,53,72,30,48,93,15,35};
        buildHeap(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
