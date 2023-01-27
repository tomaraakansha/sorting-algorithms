import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort {

	public static void main(String arg[]) throws FileNotFoundException {
		String dir = System.getProperty("user.dir");
		long timeTakenbf;
		long timeDiff;

		// Input Size 20,1. create random array size:20, 2. Write arrya to input file,
		// 3.read the array from input file. 4.find sum of all rows. 5.call sorting
		// algo. 6. write to output file
		int[][] arrInput20 = new int[20][4];
		arrInput20 = inputNums(20);
		String path20 = dir + "\\arr20.txt";
		writeRandomArrToFile(arrInput20, path20);
		arrInput20 = readFromFile(path20, 20);
		for (int i = 0; i < arrInput20.length; i++) {
			arrInput20[i][3] = arrInput20[i][0] + arrInput20[i][1] + arrInput20[i][2];
		}
		timeTakenbf = System.nanoTime();
		insertionSort(arrInput20);
		timeDiff = (System.nanoTime() - timeTakenbf)/ 1000;
		String Outpath20 = dir + "\\arrIS_O_20.txt";
		writeToFile(arrInput20, Outpath20, timeDiff);

		// Input Size 4000,1. create random array size:4000, 2. Write arrya to input
		// file, 3.read the array from input file. 4.find sum of all rows. 5.call
		// sorting algo. 6. write to output file
		int[][] arrInput4000 = new int[4000][4];
		arrInput4000 = inputNums(4000);
		String path4000 = dir + "\\arr4000.txt";
		writeRandomArrToFile(arrInput4000, path4000);
		arrInput4000 = readFromFile(path4000, 4000);
		for (int i = 0; i < arrInput4000.length; i++) {
			arrInput4000[i][3] = arrInput4000[i][0] + arrInput4000[i][1] + arrInput4000[i][2];
		}
		timeTakenbf = System.nanoTime();
		insertionSort(arrInput4000);
		timeDiff = (System.nanoTime() - timeTakenbf)/ 1000;
		String Outpath4000 = dir + "\\arrIS_O_4000.txt";
		writeToFile(arrInput4000, Outpath4000, timeDiff);

		// Input Size 100,1. create random array size:100, 2. Write arrya to input file,
		// 3.read the array from input file. 4.find sum of all rows. 5.call sorting
		// algo. 6. write to output file
		int[][] arrInput100 = new int[100][4];
		arrInput100 = inputNums(100);
		String path100 = dir + "\\arr100.txt";
		writeRandomArrToFile(arrInput100, path100);
		arrInput100 = readFromFile(path100, 100);
		for (int i = 0; i < arrInput100.length; i++) {
			arrInput100[i][3] = arrInput100[i][0] + arrInput100[i][1] + arrInput100[i][2];
		}
		timeTakenbf = System.nanoTime();
		insertionSort(arrInput100);
		timeDiff = (System.nanoTime() - timeTakenbf)/ 1000;
		String Outpath100 = dir + "\\arrIS_O_100.txt";
		writeToFile(arrInput100, Outpath100, timeDiff);

		// Input Size 1000,1. create random array size:1000, 2. Write arrya to input
		// file, 3.read the array from input file. 4.find sum of all rows. 5.call
		// sorting algo. 6. write to output file
		int[][] arrInput1000 = new int[1000][4];
		arrInput1000 = inputNums(1000);
		String path1000 = dir + "\\arr1000.txt";
		writeRandomArrToFile(arrInput1000, path1000);
		arrInput1000 = readFromFile(path1000, 1000);
		for (int i = 0; i < arrInput1000.length; i++) {
			arrInput1000[i][3] = arrInput1000[i][0] + arrInput1000[i][1] + arrInput1000[i][2];
		}
		timeTakenbf = System.nanoTime();
		insertionSort(arrInput1000);
		timeDiff = (System.nanoTime() - timeTakenbf)/ 1000;
		String Outpath1000 = dir + "\\arrIS_O_1000.txt";
		writeToFile(arrInput1000, Outpath1000, timeDiff);	

		System.out.println("completed successfully");
	}

	public static void insertionSort(int[][] arr) {
		for (int j = 1; j < arr.length; j++) {
			int i = j - 1;
			int key0 = arr[j][0];
			int key1 = arr[j][1];
			int key2 = arr[j][2];
			int key3 = arr[j][3];

			while (i > -1 && arr[i][3] > key3) {
				arr[i + 1][0] = arr[i][0];
				arr[i + 1][1] = arr[i][1];
				arr[i + 1][2] = arr[i][2];
				arr[i + 1][3] = arr[i][3];
				i--;
			}
			arr[i + 1][0] = key0;
			arr[i + 1][1] = key1;
			arr[i + 1][2] = key2;
			arr[i + 1][3] = key3;
		}
	}

	public static int[][] inputNums(int n) {
		int[][] arr = new int[n][4];

		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			arr[i][0] = rand.nextInt(100);
			arr[i][1] = rand.nextInt(100);
			arr[i][2] = rand.nextInt(100);
			arr[i][3] = arr[i][0] + arr[i][1] + arr[i][2];
		}
		return arr;
	}

	public static void writeRandomArrToFile(int[][] arr, String path) {
		FileWriter fWriter = null;
		BufferedWriter writer = null;
		try {
			fWriter = new FileWriter(path);
			writer = new BufferedWriter(fWriter);
			for (int i = 0; i < arr.length; i++) {
				writer.write(arr[i][0] + "\t" + arr[i][1] + "\t" + arr[i][2] + "\t");
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
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
