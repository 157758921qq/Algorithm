package SelectionSort.V2;
/**
 * 算法：由简单到复杂，由粗糙到精细
 * 思路：经过多次遍历，每次遍历找出最小的那个数，放在头的位置
 */
public class SelectionSort {

    public static void sort(int[] arr) {
        //这里有个点，最后一位，直接
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            System.out.println("最小值的位置minPos:" + minPos);
            swap(arr, i, minPos);
            System.out.println("经过"+ i +"次循环");
            print(arr);
        }
    }
    //进行封装
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
