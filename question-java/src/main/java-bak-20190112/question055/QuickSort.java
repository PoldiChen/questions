package question055;

public class QuickSort {
	
	public static int[] quickSort(int[] numbers, int left, int right) { // �����㷨
		int middle, temp; 
		int i = left; 
		int j = right; 
		middle = numbers[(i+j)/2];
		do { 
			while (numbers[i] < middle && i < right) i++; // �ҳ���߱��м�ֵ����� 
			while (numbers[j] > middle && j > left) j--; // �ҳ��ұ߱��м�ֵС���� 
			if (i <= j) { // ����ߴ�������ұ�С���������滻 
				temp = numbers[i]; 
				numbers[i] = numbers[j]; 
				numbers[j] = temp; 
				i++;
				j--;
			} 
		} while (i <= j); // �����߽���ʱֹͣ
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
