/**
 * CS3810 Data Structures and Algorithms
 * Assignment 5
 * Author: Chris Thomas
 * Description: This class is designed to implement a hash table to store clients' information.
 */
import java.io.*;
import java.util.*;
import java.io.RandomAccessFile;
public class IndexHashTable {
	private int arrays;
	private int[] hashTable;
	private int arrayNumber;
	private int arrayIndex;
	private int arraySize;
	private int tableSize;
	private int maxSize;
	private int key;
	private Record noData;
	public IndexHashTable(int n, int r) {
		arrays = r;
		arrayNumber = 0;
		arrayIndex = 0;
		arraySize = 20 * 2 * arrays;
		tableSize = n;
		maxSize = arrays * tableSize * 20 * 2;
		noData = new Record();
		hashTable = new int[tableSize];
		for (int i = 0; i < tableSize; i++) {
			hashTable[i] = (int)((tableSize - 1) * Math.random() + .5);
			int j = 0;
			while (j < i) {
				if (hashTable[i] == hashTable[j]) {
					hashTable[i] = (int)((tableSize - 1) * Math.random() + .5);
					j = 0;
				}
				else {
					j++;
				}
			}
		}
	}

	public int insert(RandomAccessFile file, Record rec){
		Record rec1 = new Record();
		String ID = rec.getId();
		key = hashFunc(ID);
		arrayNumber = hashTable[key];
		arrayIndex = arrayNumber * arraySize;
		int newpoint = 0;

		if(search(file, ID) == null){
			try{
				if (file != null){
					file.seek(arrayIndex);
					for (int i = 0; i < arrays; i++){
						rec1.read(file);
						newpoint = i * 40;

						if(rec1.getId().equals("    ")){
							file.seek(arrayIndex + newpoint);
							rec.write(file);
							return 0;
						}
					}
					return -1;
				}
			}
			catch (EOFException ee){
				System.out.println("This is an exception");
				ee.printStackTrace();
			}
			catch (IOException e){
				System.out.println("Cannot Add");
				e.printStackTrace();
			}
		}
		return 1;
	}

	public int delete(RandomAccessFile file, String ID){
		Record rec1 = new Record();
		try {
			if (search(file, ID) != null){
				file.seek(0);

				for (int i = 0; i < maxSize; i++){
					rec1.read(file);
					if (rec1.getId().equals(ID)){
						file.seek(file.getFilePointer() - 40);
						noData.write(file);
						return 0;
					}
				}
			}
		}
		catch (EOFException ee) {
			System.out.println("End of File");
			ee.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Cannot Remove");
			e.printStackTrace();
		}
		return 0;
	}

	public Record search(RandomAccessFile file, String ID){
		Record rec1 = new Record();
		int c = 0;
		try {
			if (file != null){
				file.seek(0);
				for (int i = 0; i < maxSize; i++){
					rec1.read(file);
						if (rec1.getId().equals("    ")){
							c += 40;
						}
						else if (rec1.getId().equals(ID)){
							return rec1;
						}
						else{
							c += 40;
						}

					if (c == maxSize){
						return null;
					}
				}
			}
		}
		catch (EOFException ee){
			System.out.println("End of file");
			ee.printStackTrace();
		}
		catch (IOException e){
			System.out.println("Cannot Find");
			e.printStackTrace();
		}
		return null;
	}

	public int hashFunc(String ID) {
		int intId = Integer.parseInt(ID);
		return intId % tableSize;
	}
}