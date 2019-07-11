package question004;

public class Bubble {
	
	public static void main(String[] args) {
	    int[] arr = new int[]{3,3,5,11,4,2};
	    arr = bubbleSort(arr);
	    for (int a : arr) {
	        System.out.println(a);
        }
    }

    public static int[] bubbleSort(int[] arr) {
	    for (int i = 1; i< arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    arr = swap(arr, j, j-1);
                }
            }
        }
	    return arr;
    }

    private static int[] swap(int[] arr, int index1, int index2) {
	    int number1 = arr[index1];
	    int number2 = arr[index2];
	    arr[index1] = number2;
	    arr[index2] = number1;
	    return arr;
    }

}
