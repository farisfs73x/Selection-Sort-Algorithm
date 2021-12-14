//Java program to implement selection sort of string
import java.util.*;
import java.io.*;

class SelectionSort
{        
    //selectionSort method
    static void selectionSort(String arr[],int n)
    {
        //One by one move boundary of unsorted subarray
        for(int i = 0; i < n - 1; i++)
        {
            
            //Search for the minimum element in UNSORTED array
            int minimum_index = i;
            String minimum_str = arr[i];
            for(int j = i + 1; j < n; j++)
            {
                
                /*compareTo() method compares two strings lexicographically. It compare
                based on the Unicode value of each character in the strings*/
                /*compareTo() will return a -ve value,
                if string1 (arr[j]) is smaller than string2 (minimum_str)*/
                //If arr[j] is smaller than minimum_str
            
                if(arr[j].compareTo(minimum_str) < 0)
                {
                    //Make arr[j] as minimum_str and update minimum_index.
                    minimum_str = arr[j];
                    minimum_index = j;
                }
            }
        
            //Swap the minimum element.
            //Search the first element.
            if(minimum_index != i)
            {
                String temporary_Str = arr[minimum_index];
                arr[minimum_index] = arr[i];
                arr[i] = temporary_Str;
            }
        }
    }
    
    //Main method
    public static void main(String args[])
    {
        
        //Get the start/initial time before run the algorithm.
        long startTime = System.currentTimeMillis();
        
        //Declaration
        //int n = 5757;   //Declare and initialize array size.
        String[] sortList = new String[6000];  //Declare array sortList to store data from txt file.
        int tot = 0;    //Declare and initialize total.
        
        try {
            
            //Read text file "dataset.txt".
            File readObj = new File("dataset.txt");
            Scanner textReader = new Scanner(readObj);
            
            //Read data from text file line by line.
            while (textReader.hasNextLine()) {
                
                //Declare and store data from text file into 'data' variable.
                String data = textReader.nextLine();
                
                //Store read data from 'data' variable into sortList[] array (UNSORTED) with index 'tot'.
                sortList[tot] = data;
                
                //Increment the index (tot).
                tot++;
            }
            
            //Close the text file after finished reading.
            textReader.close();
            
        }
            //Run this statement if text file is not found.
            catch (FileNotFoundException e) {
                
                //Display statement below if file is not found.
                System.out.println("An error occured.");
                e.printStackTrace();
        }
        
        //Call method selectionSort and pass two parameter (sortList array and array size (n)).
        selectionSort(sortList, tot);
        
        
        System.out.println("Sorted array is\n");
        
        //Display the SORTED array after sorting
        for(int i = 0; i < tot; i++)
        {
            System.out.println((i+1)+": "+sortList[i]);
        }
        
        //Get the end/finish time after run the algorithm.
        long endTime = System.currentTimeMillis();
        
        //Calculate elapsed time for this algorithm performed.
        long elapsed = endTime - startTime;
        
        //Display elapsed time for this algorithm performed.
        System.out.println("\nTime taken for this algorithm in Java : " + elapsed/1000.00 + " Seconds\n\n");
    }
}