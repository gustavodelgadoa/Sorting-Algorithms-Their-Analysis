package main.cs2720.project;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.Scanner;

/** 
 * Class implements Selection sort, Merge sort, Heap sort, and Quick sort (First element as pivot && random element as pivot). 
 */
public class SortingDriver {
    private String sortType; // Declaration of variable which holds users sort type option
    
    

    /**
     * 
     * @param a
     */
    public static void selectionSort(Comparable[] a) {
        int N = a.length; 
        for (int i = 0; i < N; i++) { 
            int min = i;
            for (int j = i+1; j < N; j++) { if (less(a[j], a[min])) min = j; }
            exch(a, i, min);
        } // for
    } // sort

    public static void insertionSort(Comparable[] a) {
        int N = a.length; 
        for (int i = 1; i < N; i++) { 
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) { exch(a, j, j-1); }
        } // for
    } // insertionSort


    /**
     * 
     * @param a
     */
    public static void mergeSort(Comparable[] a) {}

    
    //public void readFile(String filepath) { 
    //    try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
    //        String[] values = reader.readLine().split(" ");
    //        for (String value : value) { insertFromFile(value);}
    //    } catch (Exception e) { System.out.print("Error reading file"); }
    //} // readFile

    /**
     * 
     * @param value
     * @return
     */
    //private T parseValue(String value) { sortType = Integer.valueOf(value); } // parseValue

    //private void insertFromFile(String value) {
    //    T parsedValue = parseValue(value); 
    //}
    //
    private static boolean less(Comparable v, Comparable w) 
    { return v.compareTo(w) < 0;} // less

    //
    private static void exch(Comparable[] a, int i, int j)
    {Comparable t = a[i]; a[i] = a[j]; a[j] = t;}

    //
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) { 
            System.out.print(a[i] + " ");
        } // for
    } // show

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) { if (less(a[i], a[i-1])) return false;} 
        return true;
    } // isSorted

    //
    public static void main(String[] args) { 
        //String filePath = args[0]; // Takes file in param as filePath
        Scanner scanner = new Scanner(System.in); // initializes scanner object
        Integer[] a = {117, 1777, 8590, 1714, 6577, 5931, 7621, 7659, 5960, 505, 3642, 3196, 693, 4130, 4657, 5093, 1757, 7612, 7675, 4809, 6103, 6913, 7606, 1935, 3619, 6309, 4456, 2365, 9548, 9474, 4785, 9685, 3753, 9671, 757, 5144, 7884, 645, 9713, 7581, 8930, 2589, 4097, 2822, 1590, 8413, 9147, 660, 7576, 8649, 3415, 5752, 3274, 7669, 3769, 5673, 3756, 2936, 1745, 9791, 8324, 7134, 2695, 7026, 1135, 6220, 8716, 6214, 1555, 6894, 904, 3098, 7607, 9744, 5072, 9040, 386, 6619, 3528, 3760, 9785, 578, 6107, 9272, 843, 2160, 9283, 7124, 2177, 1879, 5187, 935, 5183, 8581, 7984, 4844, 1246, 2396, 8084, 7868, 4104, 8965, 97, 8537, 8883, 8095, 1791, 8569, 2460, 5806, 3085, 804, 7344, 5737, 3429, 7924, 6848, 2956, 1871, 7359, 6176, 3117, 1896, 8370, 2168, 9678, 9948, 4016, 9703, 5030, 9946, 9494, 4910, 3261, 319, 4717, 952, 7883, 1525, 5025, 9722, 3929, 2120, 4243, 9442, 6003, 1391, 9566, 8430, 1680, 9684, 2427, 6589, 8641, 7090, 3779, 2514, 3887, 6062, 9958, 1647, 8181, 3855, 2372, 7294, 5787, 8404, 7816, 3758, 7496, 7264, 7372, 8811, 6054, 2738, 6745, 3231, 2140, 6648, 4345, 1330, 8156, 4465, 2699, 8020, 1867, 7516, 2147, 1276, 2183, 1257, 5049, 7258, 3561, 6721, 6695, 84, 9506, 5197, 2680, 8191, 9972, 5352, 2516, 8858, 4401, 5796, 5308, 4278, 8752, 5767, 2006, 7930, 1709, 3140, 5505, 8113, 1140, 8669, 4628, 1923, 1862, 5744, 6569, 393, 8374, 4876, 9644, 8079, 6602, 5324, 4817, 6273, 8775,};

        // CLI fpr user to view options
        System.out.print("selection-sort (s)\n" + "Insertion-sort (i) \n" + "merge-sort (m) \n" + "heap-sort (h) \n"
        + "quick-sort-fp (q) \n" + "quick-sort-rp (r) \n" + "Enter the algorithm: ");
        
        // Initializes variable which holds users sorting algorithm selection.
        String sortType = scanner.next();

        // Switch statement here that has cases for diff algorithms, for each case, will call a the algorithms custom method.
        switch (sortType) { 
            case "s": 
                long start = System.nanoTime(); 
                selectionSort(a);
                long end = System.nanoTime();
                double elapsedTime = (end - start) / 1_000_000.0; 
                System.out.println("Selection sort | Elapsed time: " + elapsedTime + " ms");
                assert isSorted(a);
                show(a);
                break;
            case "i": 
                long start2 = System.nanoTime(); 
                insertionSort(a);
                long end2 = System.nanoTime();
                double elapsedTime2 = (end2 - start2) / 1_000_000.0; 
                System.out.println("Insertion sort | Elapsed time: " + elapsedTime2 + " ms");
                assert isSorted(a);
                show(a);
                break;
            case "h": 
                break;
            case "m": 
                break;
            case "q": 
                break;
            case "r": 
                break;
            default: 
                System.out.println("Error in reading algortihm type input");
                scanner.close();
                return;
        } // switch
        
        
        
        scanner.close();
    } // main
} // SortDriver
