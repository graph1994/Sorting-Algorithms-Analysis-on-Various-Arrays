/**
 * Created by KURT on 2/18/2015.
 */
import java.io.*;
import java.util.*;

public class SortTypes {
    public static void bubbleSort(int[] a) {
    //Bubble sort
        int n = a.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {

                if (a[j - 1] > a[j]) {
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }

            }
        }
    }
    public static void selectionSort(int a[]){
        for (int i=0; i<a.length-1; i++) {
            for (int j=i+1; j<a.length; j++) {
                if (a[i] > a[j]) {
                    //Exchange elements
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void qSort(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(arr.length);
        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            if (end - start < 2) continue;
            int p = start + ((end-start)/2);
            p = partition(arr,p,start,end);

            stack.push(p+1);
            stack.push(end);

            stack.push(start);
            stack.push(p);

        }
    }
    public static void randomQsort(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(arr.length);
        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            if (end - start < 2) continue;
            Random rand = new Random();
            int p = start + rand.nextInt(end - start);

            p = partition(arr,p,start,end);

            stack.push(p+1);
            stack.push(end);

            stack.push(start);
            stack.push(p);

        }
    }
    public static void qSort3(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(arr.length);
        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            if (end - start < 2) continue;

            int p = median_of_3(arr,start,end-1);
            p = partition(arr,p,start,end);

            stack.push(p+1);
            stack.push(end);

            stack.push(start);
            stack.push(p);

        }
    }
    private static int median_of_3(int[] arr,int start, int end) {
        int p = start + ((end-start)/2);
        if(arr[start] > arr[end]){
            swap(arr,start,end);
        }
        if(arr[start] > arr[p]){
            swap(arr,start,p);
        }
        if(arr[end] > arr[p]){
            swap(arr,end,p);
        }
        return end;
    }
    private static int partition(int[] arr, int p, int start, int end) {
        int l = start;
        int h = end - 2;
        int piv = arr[p];
        swap(arr,p,end-1);

        while (l < h) {
            if (arr[l] < piv) {
                l++;
            } else if (arr[h] >= piv) {
                h--;
            } else {
                swap(arr,l,h);
            }
        }
        int idx = h;
        if (arr[h] < piv) idx++;
        swap(arr,end-1,idx);
        return idx;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void mergeSort(int a[]) {
        int size = a.length;
        if (size < 2)
            return;
        int mid = size / 2;
        int leftSize = mid;
        int rightSize = size - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        for (int i = 0; i < mid; i++) {
            left[i] = a[i];

        }
        for (int i = mid; i < size; i++) {
            right[i - mid] = a[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, a);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                k++;
                j++;
            }
        }
        while (i < leftSize) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < leftSize) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }
    public static void insertionSort(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int vToSort = a[i];
            int j = i;
            while (j > 0 && a[j - 1] > vToSort) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = vToSort;
        }
    }
    public static void main(String[] args)throws IOException {
        int size;
        String type;
        String typeOfArray;
        long startTime;
        long endTime = 0;
        if (args.length > 0) {
            try {

                //List of all command prompt varibles

                size = Integer.parseInt(args[0]);
                int a[]= new int[size];
                type = args[1];
                typeOfArray = args[2];

                System.out.println();
                //Check if its random type if so then makes sure it has a range
                if(typeOfArray.equals("random") ){
                    if(args[3] != null && args[4] != null) {
                        int min = Integer.parseInt(args[3]);
                        int max = Integer.parseInt(args[4]);
                         a  = IntArrayGenerator.arrayRandom(size, max, min);
                    }
                    else{
                        //if not error out
                        System.err.print("error");
                    }
                }
                else if(typeOfArray.equals("ordered")){
                    //creates ordered array from other class
                    a = IntArrayGenerator.arrayAscending(size);
                }
                else if(typeOfArray.equals("reverse")){
                    //Creates reverse array
                    a = IntArrayGenerator.arrayDescending(size);
                }
                else if(typeOfArray.equals("nearly")){
                    //nearly sorted array 2 different
                    a = IntArrayGenerator.arrayNearlyAscending(size);
                }
                else{
                    System.err.print("Type of Array not Defined");
                }
                if(type.equals("bubble")){
                    //Starts timer, runs bubble sort method on array, stops time
                    startTime = System.nanoTime();
                    bubbleSort(a);
                     endTime = System.nanoTime();
		      endTime = (endTime - startTime) /1000000;
                }
                else if(type.equals("selection")){
                    //Starts timer runs selection sort stops timer
                    startTime = System.nanoTime();
                    selectionSort(a);
                     endTime = System.nanoTime();
		      endTime = (endTime - startTime) /1000000;
                }
                else if(type.equals("insert")){
                    //Starts timer runs selection sort stops timer
                    startTime = System.nanoTime();
                    insertionSort(a);
                     endTime = System.nanoTime();
		      endTime = (endTime - startTime) /1000000;
                }
                else if(type.equals("merge")){
                    startTime = System.nanoTime();
                    mergeSort(a);
                     endTime = System.nanoTime();
		      endTime = (endTime - startTime) /1000000;
                }
                else if(type.equals("quick")){
                    startTime = System.nanoTime();
                    qSort(a);
                     endTime = System.nanoTime();
		      endTime = (endTime - startTime) /1000000;
                }
                else if(type.equals("rquick")){
                    startTime = System.nanoTime();
                    randomQsort(a);
                     endTime = System.nanoTime();
		      endTime = (endTime - startTime) /1000000;
                }
                else if(type.equals("3quick")){
                    startTime = System.nanoTime();
                    qSort3(a);
                    endTime = System.nanoTime();
		      endTime = (endTime - startTime) /1000000;
                }

                else{
                    //If type is none of these it errors
                    System.err.print("Type of Algorithm not Defined");
                }
                for(int i = 0; i < size; ++i){
                   // System.out.print(a[i] + " ");
                }
                System.out.println();
                //Prints it out
		 File log = new File("data.txt");
		 PrintWriter out = new PrintWriter(new FileWriter(log, true));
		// out.append(size + " " + type + " " + typeOfArray + " " + endTime + "\n");
		 out.append("" + endTime + "\n");
		 out.close();
               System.out.print(size + " " + type + " " + typeOfArray + " " + endTime);


            } catch (NumberFormatException e) {
                //Catch if args 0 isnt a int
                System.err.println("Argument" + args[0] + " must be an integer.");
                System.exit(1);
            }
        }
    }

}
