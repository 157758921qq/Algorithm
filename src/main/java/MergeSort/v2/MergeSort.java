package MergeSort.v2;

public class MergeSort {
    public static void main(String[] args) {
        //这数组前半截{1,4,7,8}，{3,6,9};都是有序的
        //这里的坑是数组用奇数个
        int[] arr = {1, 4, 7, 8, 3, 6, 9};
        sort(arr);

    }

    static void sort(int[] arr) {
        merge(arr);
    }

    //merge排序，先划分子数组，一直到子数组中元素只剩1个或2个元素
    //只剩1个或2个元素时，此时子数组已经是有序的
    //问题是：
    //如果两个子数组已经拍好序，怎么合并起来，这是关键
    static void merge(int[] arr) {
        int mid = arr.length / 2;
        int[] temp = new int[arr.length];

        int i = 0;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j < arr.length) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++]; //进行代码优化
            } else {
                temp[k++] = arr[j++]; //进行代码优化
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j < arr.length) temp[k++] = arr[j++];

        print(temp);
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
