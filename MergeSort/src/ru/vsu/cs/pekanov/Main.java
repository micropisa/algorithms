package ru.vsu.cs.pekanov;


public class Main {

    public static void main(String[] args) {
        test();
        System.out.println();
        int[] arrTest1 = { 5, 1, 6, 2, 3, 4, 9, 10, 7, 8};
        mergeSort(arrTest1, arrTest1.length);
        for(int i = 0; i < arrTest1.length; i++ ){
            System.out.print(arrTest1[i] + "\t");
        }
    }

    public static void test (){
        int size = (int) (Math.random() * 30);
        int [] arrTest = new int[size];
        for (int i=0;i< arrTest.length;i++){
            int element = (int) (Math.random()*200 - 100);
            arrTest[i] = element;
        }
        mergeSort(arrTest, arrTest.length);
        for(int i = 0; i < arrTest.length; i++ ){
            System.out.print(arrTest[i] + "\t");
        }
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

}
