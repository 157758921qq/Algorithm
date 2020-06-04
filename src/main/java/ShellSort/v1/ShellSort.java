package ShellSort.v1;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
        sort(arr);
        print(arr);
    }

    //shell排序是基于插入排序的，将插入排序的代码拿过来改
    static void sort(int[] a){
//        //间隔
//        int gap = 4;
//        for (int i=gap; i<a.length; i++){
//            for (int j=i; j>gap-1; j-=gap){
//                if(a[j] < a[j-gap])
//                    swap(a, j ,j-gap);
//            }
//        }

        //间隔
        for(int gap = 4; gap > 0; gap/=2 ){
            for (int i=gap; i<a.length; i++){
                for (int j=i; j>gap-1; j-=gap){
                    if(a[j] < a[j-gap])
                        swap(a, j ,j-gap);
                }
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

}
