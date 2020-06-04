package BubbleSort.v2;

public class BubbleSort {

    public static void sort() {
        int[] a = {9,3,1,4,6,8,7,5,2};
        System.out.println("数组的长度"+a.length);
        sort(a);
        print(a);
    }

    static void sort(int[] a){
        for (int i=a.length-1; i>0; i--)
            findMax(a, 8);
    }

    //拆分出来
    //找到第n个位置最大的那个值
    static void findMax(int[] a, int n){
        for (int j=0; j<n; j++){
            if (a[j] > a[j+1]) swap(a, j, j+1);
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
