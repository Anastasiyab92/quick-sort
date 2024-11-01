import java.util.Arrays;
import java.util.Random;


public class QuickSort {

    public static void executeQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            // call recursion to sort left and right parts
            executeQuickSort(arr, low, pi - 1);
            executeQuickSort(arr, pi + 1, high);

        }
    }

    private static int partition(int[] arr, int low, int high) {
        //choice a pivot element
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        //Exchange of the supporting element with the last one
        int temp = arr[middle];
        arr[middle] = arr[high];
        arr[high] = temp;

        int i = low-1;
        for(int j=low; j<high; j++){
            if(arr[j] < pivot){
                i++;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[20];

        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(100);
        }
        //before quickSort
        System.out.println(Arrays.toString(array));
        executeQuickSort(array, 0, array.length-1);
        //after quickSort
        System.out.println(Arrays.toString(array));
    }
}