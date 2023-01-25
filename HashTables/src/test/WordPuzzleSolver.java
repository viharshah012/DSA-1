package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import hash.HashTable;

public class WordPuzzleSolver {
	
	private int columnDim = 0;
	private int rowDim = 0;

	public static void main(String[] args) {
		
		/* Kick everything off by calling solve() */
		try {
			Scanner in = new Scanner(System.in);
			String dictFile = in.next();
			String gridFile = in.next();
			in.close();
			new WordPuzzleSolver().solve(dictFile, gridFile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/* Solve the puzzle */
	private void solve(String dictFile, String gridFile) throws IOException {
		/* Implement this method. Open the files and solve the word puzzle!! */
		String dictPath = dictFile;
		String gridPath = gridFile;
		
		HashTable<String, String> dictionary = new hash.HashTable<String, String>();
		
		Scanner in2 = new Scanner(new File(dictPath));
		
		while (in2.hasNextLine()) {
			String word = in2.nextLine();
			dictionary.insert(word, "");
			
		}
		
		in2.close();
		
		int rowInd = 0; 
		int columnInd = 0; 
		int count = 0;
		String currentString;
		
		in2 = new Scanner(new File(gridPath));
		this.rowDim = in2.nextInt();
		this.columnDim = in2.nextInt();
		in2.close();
		in2 = new Scanner(new File(gridPath));
		in2.nextLine();
		in2.nextLine();
		String grid = in2.nextLine();
		in2.close();
		
		long start = System.currentTimeMillis();
		
		while (getIndex(rowInd, columnInd) < grid.length()) {

			int rowIter = rowInd; 
			int colIter = columnInd;
			currentString = "";
			// Check going east
			while (true) {
				currentString += grid.substring(getIndex(rowIter, colIter), getIndex(rowIter, colIter)+1);
				if (currentString.length() >= 3 && dictionary.contains(currentString)) { 
					count++; 
					//System.out.println("E (" + rowInd + ", " + columnInd + "): " + currentString);
				}
				colIter++;
				if (colIter >= columnDim || colIter < 0) { break; }
				if (rowIter >= rowDim || rowIter < 0) { break; }
				if (currentString.length() >= 22) { break; }
			}

			rowIter = rowInd;
			colIter = columnInd;
			currentString = "";
			// Check going west
			while (true) {
				currentString += grid.substring(getIndex(rowIter, colIter), getIndex(rowIter, colIter)+1);
				if (currentString.length() >= 3 && dictionary.contains(currentString)) { 
					count++; 
					//System.out.println("W (" + rowInd + ", " + columnInd + "): " + currentString);
				}
				colIter-=1;
				if (colIter >= columnDim || colIter < 0) { break; }
				if (rowIter >= rowDim || rowIter < 0) { break; }
				if (currentString.length() >= 22) { break; }
			}

			rowIter = rowInd;
			colIter = columnInd;
			currentString = "";
			// Check going south
			while (true) {
				currentString += grid.substring(getIndex(rowIter, colIter), getIndex(rowIter, colIter)+1);
				if (currentString.length() >= 3 && dictionary.contains(currentString)) { 
					count++; 
					//System.out.println("S (" + rowInd + ", " + columnInd + "): " + currentString);
				}
				rowIter++;
				if (colIter >= columnDim || colIter < 0) { break; }
				if (rowIter >= rowDim || rowIter < 0) { break; }
				if (currentString.length() >= 22) { break; }
			}	

			rowIter = rowInd;
			colIter = columnInd;
			currentString = "";
			// Check going north
			while (true) {
				currentString += grid.substring(getIndex(rowIter, colIter), getIndex(rowIter, colIter)+1);
				if (currentString.length() >= 3 && dictionary.contains(currentString)) { 
					count++; 
					//System.out.println("N (" + rowInd + ", " + columnInd + "): " + currentString);
				}
				rowIter-=1;
				if (colIter >= columnDim || colIter < 0) { break; }
				if (rowIter >= rowDim || rowIter < 0) { break; }
				if (currentString.length() >= 22) { break; }
			}

			rowIter = rowInd;
			colIter = columnInd;
			currentString = "";
			// Check going south east
			while (true) {
				currentString += grid.substring(getIndex(rowIter, colIter), getIndex(rowIter, colIter)+1);
				if (currentString.length() >= 3 && dictionary.contains(currentString)) { 
					count++; 
					//System.out.println("SE(" + rowInd + ", " + columnInd + "):	" + currentString);
				}
				rowIter+=1;
				colIter+=1;
				if (colIter >= columnDim || colIter < 0) { break; }
				if (rowIter >= rowDim || rowIter < 0) { break; }
				if (currentString.length() >= 22) { break; }
			}

			rowIter = rowInd;
			colIter = columnInd;
			currentString = "";
			// Check going south west
			while (true) {
				currentString += grid.substring(getIndex(rowIter, colIter), getIndex(rowIter, colIter)+1);
				if (currentString.length() >= 3 && dictionary.contains(currentString)) { 
					count++; 
					//System.out.println("SW(" + rowInd + ", " + columnInd + "): " + currentString);
				}
				rowIter+=1;
				colIter-=1;
				if (colIter >= columnDim || colIter < 0) { break; }
				if (rowIter >= rowDim || rowIter < 0) { break; }
				if (currentString.length() >= 22) { break; }
			}

			rowIter = rowInd;
			colIter = columnInd;
			currentString = "";
			// Check going north east
			while (true) {
				currentString += grid.substring(getIndex(rowIter, colIter), getIndex(rowIter, colIter)+1);
				if (currentString.length() >= 3 && dictionary.contains(currentString)) { 
					count++; 
					//System.out.println("NE(" + rowInd + ", " + columnInd + "): " + currentString);
				}
				rowIter-=1;
				colIter+=1;
				if (colIter >= columnDim || colIter < 0) { break; }
				if (rowIter >= rowDim || rowIter < 0) { break; }
				if (currentString.length() >= 22) { break; }
			}

			rowIter = rowInd;
			colIter = columnInd;
			currentString = "";
			// Check going north west
			while (true) {
				currentString += grid.substring(getIndex(rowIter, colIter), getIndex(rowIter, colIter)+1);
				if (currentString.length() >= 3 && dictionary.contains(currentString)) { 
					count++; 
					//System.out.println("NW(" + rowInd + ", " + columnInd + "): " + currentString);
				}
				rowIter-=1;
				colIter-=1;
				if (colIter >= columnDim || colIter < 0) { break; }
				if (rowIter >= rowDim || rowIter < 0) { break; }
				if (currentString.length() >= 22) { break; }
			}
			
			// Increment rowInd and colInd
			columnInd++;
			if (columnInd >= columnDim) {
				columnInd = 0;
				rowInd ++;
			}
		}

		//System.out.println("Time: " + (System.currentTimeMillis() - start));
		System.out.println(count + " words found");
		//System.out.println("Found all words in " + ((System.currentTimeMillis() - start) / 1000) + " seconds");
		//System.out.println("Collisions: " + dict.getCollisions());	
	}

	private int getIndex (int rowInd, int colInd) {
		return rowInd*this.columnDim + colInd;
	}
		
}