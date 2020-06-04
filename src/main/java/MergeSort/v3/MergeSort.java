package MergeSort.v3;

/**
 * 递归写法
 *
 */
public class MergeSort {
    public static void main(String[] args) {
        //这数组前半截{1,4,7,8}，{3,6,9};都是有序的
        //这里的坑是数组用奇数个
        int[] arr = {1, 4, 7, 8, 3, 6, 9};
        sort(arr,0, arr.length-1);
        print(arr);
    }

    //sort是递归
    static void sort(int[] arr, int left, int right) {
        if (left == right) return;
        //分成两半
        int mid = left + (right - left)/2;
        //左边排序
        sort(arr, left, mid);
        //右边排序
        sort(arr, mid+1, right);
        //合并
        merge(arr, left, mid+1, right);
    }

    //merge排序，先划分子数组，一直到子数组中元素只剩1个或2个元素
    //只剩1个或2个元素时，此时子数组已经是有序的
    //问题是：
    //如果两个子数组已经拍好序，怎么合并起来，这是关键
    static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound ) {
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;
        while (i <= mid && j <=rightBound) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++]; //进行代码优化
            } else {
                temp[k++] = arr[j++]; //进行代码优化
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= rightBound) temp[k++] = arr[j++];

        for (int m=0; m<temp.length; m++) arr[leftPtr+m] =temp[m];

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
