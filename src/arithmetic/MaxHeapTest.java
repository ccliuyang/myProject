package arithmetic;

public class MaxHeapTest {
	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 7, 8, 9, 10, 14, 16 };
		MaxHeap heap = new MaxHeap(array);
		System.out.println("ִ�����ѻ�ǰ�ѵĽṹ��");
		printHeapTree(heap.heap);
		heap.BuildMaxHeap();
		System.out.println("ִ�����ѻ���ѵĽṹ��");
		printHeapTree(heap.heap);
		heap.HeapSort();
		System.out.println("ִ�ж���������������");
		printHeap(heap.heap);

	}

	private static void printHeapTree(int[] array) {
		for (int i = 1; i < array.length; i = i * 2) {
			for (int k = i - 1; k < 2 * (i) - 1 && k < array.length; k++) {
				System.out.print(array[k] + " ");
			}
			System.out.println();
		}
	}

	private static void printHeap(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
