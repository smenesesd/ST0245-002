/**
 * Laboratorio 2 de Estructuras de Datos 1
 *
 * @author Neller Pellegrino, Samuel Meneses
 * @version 1
 */

import java.util.Arrays;
import java.util.Random;

public class Laboratorio2
{


    // Sorts an array using Insertion Sort
    public static void InsertionSort(int[] A)
    {
        int tamaño = A.length;
        for (int i = 1; i < tamaño ; i++) {
            int temporal = A[i];
            int j = i - 1;

            while (j >= 0 && A[i] > temporal){
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = temporal;
        }
    }

    // Sorts an array using Merge Sort
    public static void mergeSort(int [ ] a)
    {
        mergeSort(a,  0,  a.length - 1);
    }

    // Sorts an array using Merge Sort
    private static void mergeSort(int [ ] a, int left, int right)
    {
        if(left < right){
            int m = (left + right) / 2;

            mergeSort(a, left, m);
            mergeSort(a, m + 1, right);

            merge(a, left,m , right);
        }
    }

    // Merges two sorted arrays
    private static void merge(int[ ] a, int left, int right, int rightEnd )
    {
        int tamaño1 =  right - left + 1;
        int tamaño2 = rightEnd - right;
        int []temp1 = new int[tamaño1];
        int []temp2 = new int[tamaño2];

        for (int i = 0; i < tamaño1; i++) {
            temp1[i] = a[left + 1];
        }
        for (int j = 0; j < tamaño2; j++) {
            temp2[j] = a[right + 1 + j];
        }

        int i = 0, j = 0;

        int k = left;
        while (i < tamaño1 && j < tamaño2){
            if (temp1[i] <= temp2[j]){
                a[k] = temp1[i];
                i++;
            }else{
                a[k] = temp2[j];
                j++;
            }
            k++;
        }

        while (i < tamaño1){
            a[k] = temp1[i];
            i++;
            k++;
        }

        while (j < tamaño2){
            a[k] = temp2[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args)
    {
        int[] A = {1,5,3,2,6};
        int[] B = {1,5,3,2};
        int[] C = {1,5,2,6};
        int[][] Arrays = {A,B,C};
        for (int[] X : Arrays)
        {
            Laboratorio2.mergeSort(X);
            Laboratorio2.InsertionSort(X);
        }
    }

}
