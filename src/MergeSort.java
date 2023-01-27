import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class MergeSort {

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
		mergeSort(arrInput20, 0, 20 - 1);
		timeDiff = (System.nanoTime() - timeTakenbf)/ 1000;
		String Outpath20 = dir + "\\arrMR_O_20.txt";
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
		mergeSort(arrInput4000, 0, 4000 - 1);
		timeDiff = (System.nanoTime() - timeTakenbf)/ 1000;
		String Outpath4000 = dir + "\\arrMR_O_4000.txt";
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
		mergeSort(arrInput100, 0, 100 - 1);
		timeDiff = (System.nanoTime() - timeTakenbf)/ 1000;
		String Outpath100 = dir + "\\arrMR_O_100.txt";
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
		mergeSort(arrInput1000, 0, 1000 - 1);
		timeDiff = (System.nanoTime() - timeTakenbf)/ 1000;
		String Outpath1000 = dir + "\\arrMR_O_1000.txt";
		writeToFile(arrInput1000, Outpath1000, timeDiff);
	
		System.out.println("completed successfully");
	}

	public static void mergeSort(int[][] arr, int p, int r) {
		if (p < r) {
			int q = (int) Math.floor((p + r) / 2);
			mergeSort(arr, p, q);
			mergeSort(arr, q + 1, r);
			merge(p, q, r, arr);
		}
	}

	public static void merge(int p, int q, int r, int[][] arr) {
		int n1 = (q - p + 1);
		int n2 = (r - q);
		int left[][] = new int[n1 + 1][4];
		int right[][] = new int[n2 + 1][4];
		int i = 0;
		int j = 0;
		int k = p;
		for (i = 0; i < n1; i++) {
			left[i][0] = arr[k][0];
			left[i][1] = arr[k][1];
			left[i][2] = arr[k][2];
			left[i][3] = arr[k][3];
			k++;
		}
		for (j = 0; j < n2; j++) {
			right[j][0] = arr[k][0];
			right[j][1] = arr[k][1];
			right[j][2] = arr[k][2];
			right[j][3] = arr[k][3];
			k++;
		}
		left[n1][3] = 400;
		right[n2][3] = 400;
		i = 0;
		j = 0;
		for (k = p; k <= r; k++) {
			if (left[i][3] <= right[j][3]) {
				arr[k][0] = left[i][0];
				arr[k][1] = left[i][1];
				arr[k][2] = left[i][2];
				arr[k][3] = left[i][3];
				i++;
			} else {
				arr[k][0] = right[j][0];
				arr[k][1] = right[j][1];
				arr[k][2] = right[j][2];
				arr[k][3] = right[j][3];
				j++;
			}
		}
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
