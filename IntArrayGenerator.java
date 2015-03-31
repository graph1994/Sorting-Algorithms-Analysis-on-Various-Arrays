/**
 * Created by KURT on 2/12/2015.
 */

import java.util.Collections;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class IntArrayGenerator {
    static int[] arrayRandom(int n,int max, int min) {
        Random random = new Random();
        int[] a = new int[n];
        for (int j = 0; j < n; ++j) {

            int ranInt = random.nextInt(max)+min +1;;
            a[j] = ranInt;
        }

        return a;
    }



    static int[] arrayAscending(int n){
        int b[] = new int[n];
        for(int i = 0; i < n; ++i){
            b[i] = i;
        }

        return b;
    }
    static int[] arrayDescending(int n){
        int c[] = new int[n];
        for(int i = 0;i< n;++i){
            c[i]= n - i;
        }
        return c;
       //return c;
    }
    static int[] arrayNearlyAscending(int n){
        Random random = new Random();
        int d[] = new int[n];
        for(int i = 0;i<n; ++i){
            d[i] = i;
        }
        int index1 = random.nextInt(d.length + 1);
        int index2 = random.nextInt(d.length + 1);
        int x = d[index1];
        d[index1] = d[index2];
        d[index2] = x;
        return d;

    }
    public static void main(String[] args){
        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter length of Array:");
        n = in.nextInt();
        System.out.print("Enter Min:");
        int min = in.nextInt();
        System.out.print("Enter Max:");
        int max = in.nextInt();
        int a[] = arrayRandom(n,max,min);
       // int b[] = arrayAscending(n);
        int d[] = arrayNearlyAscending(n);
        for(int i = 0; i < n; ++i){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < n; ++i){
        //    System.out.print(b[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < n; ++i){
           // System.out.print(d[i] + " ");
        }

    }

}
