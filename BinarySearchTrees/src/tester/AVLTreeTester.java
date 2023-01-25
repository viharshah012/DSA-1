package tester;

import tree.AVLTree;
import tree.BinarySearchTree;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.System;
import java.util.Random;

public class AVLTreeTester {

	public static void main(String[] args) {
		
		String[] data = new String[10000];
		int index = 0;
	    try {
	      File myObj = new File("/Users/vihar/eclipse-workspace/BinarySearchTrees/src/tester/montecristo.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String word = myReader.nextLine();
	        data[index] = word;
	    	index++;
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    //-------------------------------------------------------------------------
		AVLTree<String> avl = new AVLTree<String>();
		BinarySearchTree<String> bst = new BinarySearchTree<String>();
		
		
		int bstTime = 0;
		int avlTime = 0;
		
		for (int i =0; i<10000;i++) {
			int t1 = (int) System.currentTimeMillis();
			bst.insert(data[i]);
			bstTime += (int) (System.currentTimeMillis() - t1);
		}
		for (int i =0; i<10000;i++) {
			int t2 = (int) System.currentTimeMillis();
			avl.insert(data[i]);
			avlTime += (int) (System.currentTimeMillis() - t2);
		}
//-----------------------------------------------------------------------
		
		System.out.println("Insert time: "+ "BST"+": "+bstTime+"   "+"AVL"+": "+avlTime);
//------------------------------------------------------------------------------
		// Find
		bstTime = 0;
		avlTime = 0;
		
		for (int i =0; i<10000;i++) {
			int t1 = (int) System.currentTimeMillis();
			bst.find(data[i]);
			bstTime += (int) (System.currentTimeMillis() - t1);
		}
		for (int i =0; i<10000;i++) {
			int t2 = (int) System.currentTimeMillis();
			avl.find(data[i]);
			avlTime += (int) (System.currentTimeMillis() - t2);
		}
		
//------------------------------------------------------------------------------	
			
		System.out.println("Find time: "+ "BST"+" : "+bstTime+"   "+"AVL"+" : "+avlTime);
//---------------------------------------------------------------------------------
		//height
		
		System.out.println("Height: "+ "BST"+" : "+bst.height()+"   "+"AVL"+" : "+avl.height());
//------------------------------------------------------------------------------------------------------
		
		int[] numbers = new int[10000];
		for (int i = 0; i < 10000; i++) {
			Random rand = new Random();
			int number = rand.nextInt(10000);
			numbers[i] = number;
		}
//--------------------------------------------------------------------------------------------
		AVLTree<Integer> avl2 = new AVLTree<Integer>();
		BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
		
		bstTime = 0;
		avlTime = 0;
		
		for (int i =0; i<10000;i++) {
			int t1 = (int) System.currentTimeMillis();
			bst2.insert(numbers[i]);
			bstTime += (int) (System.currentTimeMillis() - t1);
							}
		for (int i =0; i<10000;i++) {
			int t2 = (int) System.currentTimeMillis();
			avl2.insert(numbers[i]);
			avlTime += (int) (System.currentTimeMillis() - t2);
		}
//-----------------------------------------------------------------------------------
		System.out.println("Insert time 2: "+ "BST2"+" : "+bstTime+"   "+"AVL2"+" : "+avlTime);
//-------------------------------------------------------------------------------------
		bstTime = 0;
		avlTime = 0;
		
		for (int i =0; i<10000;i++) {
			int t1 = (int) System.currentTimeMillis();
			bst2.find(numbers[i]);
			bstTime += (int) (System.currentTimeMillis() - t1);
							}
		for (int i =0; i<10000;i++) {
			int t2 = (int) System.currentTimeMillis();
			avl2.find(numbers[i]);
			avlTime += (int) (System.currentTimeMillis() - t2);	
					}
//---------------------------------------------------------------------------------------------
		System.out.println("Find time 2: "+ "BST2"+" : "+bstTime+"   "+"AVL2"+" : "+avlTime);
//---------------------------------------------------------------------------------------------
		System.out.println("Height 2: "+ "BST2"+" : "+bst2.height()+"   "+"AVL2"+" : "+avl2.height());

		
		
		
		
		
		
		/* Here are two test cases for your implementations. */
		/* You SHOULD create more */
		
		/*
		 * 	Correct output:
		 * 	BST Pre: 5 4 3 2 1 9 8 7 6 
		 *	BST In: 1 2 3 4 5 6 7 8 9 
		 *	BST Post: 1 2 3 4 6 7 8 9 5 
		 *	AVL Pre: 4 2 1 3 8 6 5 7 9 
		 *	AVL In: 1 2 3 4 5 6 7 8 9 
		 *	AVL Post: 1 3 2 5 7 6 9 8 4 
		 */

		//You can comment this line back in next week
//		AVLTree<Integer> avl = new AVLTree<Integer>();
//		
//		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
//		
//		int[] toInsert = {5,4,3,2,1,9,8,7,6};
//		
//		for(int i : toInsert) {
//			avl.insert(i);
//			bst.insert(i);
//		}
//		
//		/* Print out pre, in, and post-order */
//		System.out.print("BST Pre: " + bst.getPreOrder());
//		System.out.print("BST In: " + bst.getInOrder());
//		System.out.print("BST Post: " + bst.getPostOrder());
//		
//		// You can comment these lines in next week as well
//		System.out.print("AVL Pre: " + avl.getPreOrder());
//		System.out.print("AVL In: " + avl.getInOrder());
//		System.out.print("AVL Post: " + avl.getPostOrder());
		
	}
}
