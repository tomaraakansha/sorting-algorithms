import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class QuickSort {
    public static void main(String arg[]) throws FileNotFoundException {
        String dir = System.getProperty("user.dir");
        long timeTakenbf;
        long timeDiff;

        // Input Size 20, 1.read the array from input file. 2.find sum of all rows.
        // 3.call sorting algo. 4. write array to output file
        int[][] arrInput20 = new int[20][4];
        String path20 = dir + "\\arr20.txt";
        arrInput20 = readFromFile(path20, 20);
        for (int i = 0; i < arrInput20.length; i++) {
            arrInput20[i][3] = arrInput20[i][0] + arrInput20[i][1] + arrInput20[i][2];
        }
        timeTakenbf = System.nanoTime();
        quickSort(arrInput20, 0, 20 - 1);
        timeDiff = (System.nanoTime() - timeTakenbf)/ 1000;
        String Outpath20 = dir + "\\arrQK_O_20.txt";
        writeToFile(arrInput20, Outpath20, timeDiff);

        // Input Size 4000, 1.read the array from input file. 2.find sum of all rows.
        // 3.call sorting algo. 4. write array to output file
        int[][] arrInput4000 = new int[4000][4];
        String path4000 = dir + "\\arr4000.txt";
        arrInput4000 = readFromFile(path4000, 4000);
        for (int i = 0; i < arrInput4000.length; i++) {
            arrInput4000[i][3] = arrInput4000[i][0] + arrInput4000[i][1] + arrInput4000[i][2];
        }
        timeTakenbf = System.nanoTime();
        quickSort(arrInput4000, 0, 4000 - 1);
        timeDiff = (System.nanoTime() - timeTakenbf)/ 1000;
        String Outpath4000 = dir + "\\arrQK_O_4000.txt";
        writeToFile(arrInput4000, Outpath4000, timeDiff);

        // Input Size 100, 1.read the array from input file. 2.find sum of all rows.
        // 3.call sorting algo. 4. write array to output file
        int[][] arrInput100 = new int[100][4];
        String path100 = dir + "\\arr100.txt";
        arrInput100 = readFromFile(path100, 100);
        for (int i = 0; i < arrInput100.length; i++) {
            arrInput100[i][3] = arrInput100[i][0] + arrInput100[i][1] + arrInput100[i][2];
        }
        timeTakenbf = System.nanoTime();
        quickSort(arrInput100, 0, 100 - 1);
        timeDiff = (System.nanoTime() - timeTakenbf)/ 1000;
        String Outpath100 = dir + "\\arrQK_O_100.txt";
        writeToFile(arrInput100, Outpath100, timeDiff);

        // Input Size 1000, 1.read the array from input file. 2.find sum of all rows.
        // 3.call sorting algo. 4. write array to output file
        int[][] arrInput1000 = new int[1000][4];
        String path1000 = dir + "\\arr1000.txt";
        arrInput1000 = readFromFile(path1000, 1000);
        for (int i = 0; i < arrInput1000.length; i++) {
            arrInput1000[i][3] = arrInput1000[i][0] + arrInput1000[i][1] + arrInput1000[i][2];
        }
        timeTakenbf = System.nanoTime();
        quickSort(arrInput1000, 0, 1000 - 1);
        timeDiff = (System.nanoTime() - timeTakenbf)/ 1000;
        String Outpath1000 = dir + "\\arrQK_O_1000.txt";
        writeToFile(arrInput1000, Outpath1000, timeDiff);     

        System.out.println("completed successfully");
    }

    public static void quickSort(int[][] arr, int left, int right) {
        int pi;
        if (right > left) {
            pi = partition(arr, left, right);
            quickSort(arr, left, pi - 1);
            quickSort(arr, pi + 1, right);
        }
    }

    public static int partition(int[][] arr, int left, int right) {
        int pivot = right;
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j][3] <= arr[pivot][3]) {
                i++;
                int swap0 = arr[j][0];
                int swap1 = arr[j][1];
                int swap2 = arr[j][2];
                int swap3 = arr[j][3];
                arr[j][0] = arr[i][0];
                arr[j][1] = arr[i][1];
                arr[j][2] = arr[i][2];
                arr[j][3] = arr[i][3];
                arr[i][0] = swap0;
                arr[i][1] = swap1;
                arr[i][2] = swap2;
                arr[i][3] = swap3;
            }
        }
        int swap0 = arr[pivot][0];
        int swap1 = arr[pivot][1];
        int swap2 = arr[pivot][2];
        int swap3 = arr[pivot][3];
        arr[pivot][0] = arr[i + 1][0];
        arr[pivot][1] = arr[i + 1][1];
        arr[pivot][2] = arr[i + 1][2];
        arr[pivot][3] = arr[i + 1][3];
        arr[i + 1][0] = swap0;
        arr[i + 1][1] = swap1;
        arr[i + 1][2] = swap2;
        arr[i + 1][3] = swap3;

        return i + 1;
    }

    public static void writeToFile(int[][] arr, String path, Long timeDiff) {
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        try {
            fWriter = new FileWriter(path);
            writer = new BufferedWriter(fWriter);
            for (int i = 0; i < arr.length; i++) {
                writer.write(arr[i][0] + "\t" + arr[i][1] + "\t" + arr[i][2] + "\t" + arr[i][3]);
                writer.newLine();
            }
            writer.write(timeDiff.toString());
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public static int[][] readFromFile(String path, int len) throws FileNotFoundException {
        Scanner s = new Scanner(new File(path));
        int[][] arr = new int[len][4];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        return arr;
    }
}
