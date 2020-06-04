package SelectionSort.V2;

import java.util.Arrays;
import java.util.Random;

/**
 * 对数器的设计
 * 1、产生2个数组，别忘了拷贝
 * 2、用系统自带的排序算法和我们自己设计的排序算法进行排序
 * 3、对比，两个数字每位上的数组是否一致
 */
public class DataCheck {

    //随机数产生器
    static int[] generateRandomArray(){
        Random r = new Random();
        int[] arr = new int[10000];
        for (int i=0; i< arr.length; i++){
            arr[i] = r.nextInt(10000);
        }
        return arr;
    }

    static void check(){
        int[] arr = generateRandomArray();
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2,0, arr.length);

        Arrays.sort(arr);
        SelectionSort.sort(arr2);

        boolean same = true;
        for (int i=0; i< arr2.length; i++){
            if (arr[i] != arr2[i])
                same = false;
        }
        System.out.println(same == true ?"right" : "wrong");
    }

    public static void main(String[] args) {
        check();
    }
}
