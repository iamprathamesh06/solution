import java.util.*;

public class QuickSort {
	static void display(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	static int partition(int arr[], int s, int e) {
		int pivot = arr[s];
		int cnt = 0;
		for (int i = s + 1; i <= e; i++) {
			if (arr[i] < pivot)
				cnt++;
		}
		int pivotIndex = s + cnt; // correct index
		swap(arr, s, pivotIndex); // swap pivot

		// make sure that left and right are less than and greater than pivot

		int i = s, j = e;
		while (i < pivotIndex && j > pivotIndex) {

			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}
			if (i < pivotIndex && j > pivotIndex) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}

		return pivotIndex;
	}

	static void quickSort(int arr[], int s, int e) {
		if (s >= e) {
			return;
		}

		int pIndex = partition(arr, s, e);

		quickSort(arr, 0, pIndex - 1);
		quickSort(arr, pIndex + 1, e);
	}

	public static void main(String args[]) {
		int arr[] = { 10, 42, 32, 53, 2, 53, 72, 72, 64, 2, 6, 4, 53 };
		int size = arr.length;
		display(arr, size);
		quickSort(arr, 0, size - 1);
		display(arr, size);
	}
}