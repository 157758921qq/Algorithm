package BubbleSort.v1;

public class BubbleSort {

    public static void sort() {
        int[] a = {9,3,1,4,6,8,7,5,2};
        System.out.println("数组的长度"+a.length);
        sort(a);
        print(a);
    }

    static void sort(int[] a){
        for (int i=a.length-1; i>0; i--){
            //j<i. i=8的时候  9到最末位
            //     i=7的时候  找到8是最大的数
            //     i=6
            for (int j=0; j<i; j++){
                if (a[j] > a[j+1]) swap(a, j, j+1);
            }
        }

    }

    static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void print(int[] arr){
        for (int i=0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        sort();
    }
}
