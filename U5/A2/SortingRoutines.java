import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.commons.lang3.ArrayUtils;

public class SortingRoutines {

    public static void bubbleSort(final int data[]) {
        // Loop to control number of passes
        for (int pass = 1; pass < data.length; pass++) {
            // Loop to control # of comparisons for length of array-1
            for (int element = 0; element < data.length - 1; element++) {
                // compare side-by-side elements and swap them if
                // first element is greater than second element
                if (data[element] > data[element + 1]) {
                    SortingRoutines.swap(data, element, element + 1); // call swap method
                }
            }
        }
    }

    // slecetion sort
    public static void insertionSort(final int data[]) {
        int insert;

        for (int next = 1; next < data.length; next++) {
            insert = data[next];
            int moveItem = next;

            while (moveItem > 0 && data[moveItem - 1] > insert) {
                data[moveItem] = data[moveItem - 1];
                moveItem--;
            }
            data[moveItem] = insert;
        }
    }

    public static void main(final String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        try {
            // allow multiple arrays
            while (true) {

                // find the users options
                final int routine = Integer
                        .parseInt(JOptionPane
                                .showInputDialog("Which sorting routine would you like to use?\n1. Quick Sort\n2. Bubble sort\n3. Insersion Sort\n4. Selection sort"));
                final int amount = Integer
                        .parseInt(JOptionPane
                                .showInputDialog("How many noumbers should randomly be added to the list? (1-1000)"));
                final int order = Integer
                        .parseInt(JOptionPane
                                .showInputDialog("How would you like the list to be ordered\n1. Ascending\n2.Descending?"));

                // create and init the array
                final int[] array = new int[amount];
                System.out.print("The unsorted array is ");
                for (int i = 0; i < array.length; i++) {
                    array[i] = new Random().nextInt(1001);
                    System.out.print(array[i] + " ");
                }
                System.out.println();
                // sort acording to the input
                switch (routine) {
                    case 1:
                        SortingRoutines.quickSort(array);
                        break;
                    case 2:
                        SortingRoutines.bubbleSort(array);
                        break;
                    case 3:
                        SortingRoutines.insertionSort(array);
                        break;
                    case 4:
                        SortingRoutines.selectionSort(array);
                        break;
                }
                if (order == 2) {
                    // reverse the array
                    ArrayUtils.reverse(array);
                }

                // print out the new aray
                System.out.print("The sorted array is ");
                for (final int element : array) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        } catch (final Exception e) {
            System.out.println("Thanks for using my program.");
        }
    }

    // partition from quicksort
    public static int partition(final int data2[], int left, int right) {
        boolean moveLeft = true;
        final int separator = data2[left];

        while (left < right) {
            if (moveLeft == true) {
                while ((data2[right] >= separator) && (left < right)) {
                    right--;
                }
                data2[left] = data2[right];
                moveLeft = false;
            } else {
                while ((data2[left] <= separator) && (left < right)) {
                    left++;
                }
                data2[right] = data2[left];
                moveLeft = true;
            }
        }
        data2[left] = separator;
        return left;
    }

    // call the quicksort
    public static void quickSort(final int data[]) {
        SortingRoutines.quickSort(data, 0, data.length - 1);
    }

    // quicksort
    public static void quickSort(final int data[], final int low, final int high) {
        int partitionLoc;
        if (low < high) {
            partitionLoc = SortingRoutines.partition(data, low, high);
            SortingRoutines.quickSort(data, low, partitionLoc - 1);
            SortingRoutines.quickSort(data, partitionLoc + 1, high);
        }
    }

    public static void selectionSort(final int data[]) {
        int smallest;
        for (int i = 0; i < data.length - 1; i++) {
            smallest = i;
            // see if there is a smaller number further in the array
            for (int index = i + 1; index < data.length; index++) {
                if (data[index] < data[smallest]) {
                    SortingRoutines.swap(data, smallest, index);
                }
            }
        }
    }

    // swap the elements
    public static void swap(final int array2[], final int first,
            final int second) {
        final int hold = array2[first];
        array2[first] = array2[second];
        array2[second] = hold;
    }

}
