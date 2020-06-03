package SelectionSort.V1;

/**
 * 算法：由简单到复杂，由粗糙到精细
 * 思路：经过多次遍历，每次遍历找出最小的那个数，放在头的位置
 *
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 1, 9, 0, 12, 19, 2};

        for(int i=0; i<arr.length; i++){
            int minPos = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[minPos]){
                    minPos = j;
                }
            }
            System.out.println("minPos:" + minPos);
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }




        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
