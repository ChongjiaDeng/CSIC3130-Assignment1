package Assignment1;

/* Class: CISC 3130
* Section: MY9
* EmplId: 23402081
* Name: Chongjia Deng
*/

import java.util.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;

public class TopArtistsList {
		private int columns; 
		private int rows ;
		private int colsofArt;
		//Create the columns and rows for String Array.
		String[][] StrArray= new String[rows][columns];	
		//Set up a String Array for convert CSV file into a 2D array.
		String[][] ArtArray= new String[rows][colsofArt];	
		//Set up a 2d Array to collect the Artists and StreamingNumbers from String Array.
		int[] StreamArray= new int[rows];		
		//Set up a Array to convert StreamingNumbers from String data type to integer data type.
		String fileName;
		
public 	TopArtistsList(String name) {  // constructor.
		fileName = name;
		columns = 5;
		rows = 0;
		colsofArt = 2;
		StrArray= new String[rows][columns];
}
public String getFileName() { // get name of file.
	return fileName;
}


public  void readFiled() {
		        Scanner scanIn = null;
		        String InputLine = "";
		        try {
		        	//setup a scanner
		        	scanIn = new Scanner (new BufferedReader(new FileReader(getFileName())));
		        // while next line in CSV file is not empty.
		        while (scanIn.hasNextLine())
		        {// Read line in from file
		        	InputLine = scanIn.nextLine();
		        //split the Inputline into an array at the commas
		        	String[] InArray = InputLine.split(",");
		        	//copy the content of the inArray to StrArray
		        	for(int i = 0; i < InArray.length; i++) {
		        	StrArray [rows][i] = InArray[i];}
		        	rows++;
		        }
		        }
		        catch(Exception e) {
		        	System.out.println(e); // if does not exit the CSV file.
		        }
		        
		        
		    }

 public void addArtistsStream(){ 
	 ArtArray= new String[rows][colsofArt]; 
	 StreamArray= new int[rows];
	 String number;
	 // numbers of rows is same as StrArray, and it has two columns which artists and Streaming numbers.
	 int temp = 0;
	 for(int i = 0; i < StrArray.length; i++) { 
		 if(checkSame(StrArray[i][2]) > -1) { 
		temp =checkSame(StrArray[i][2]);
		//checking the name of the artist if already exist at artists Array.
		StreamArray[temp] =+ Integer.parseInt(ArtArray[temp][1]) ; 
		//convert the data type form String to integer and adding Streaming number of song to Stream Array.
		ArtArray[temp][1] = Arrays.toString(StreamArray[temp]);
		// StreamArray to String.
		 }
		
		 else {
		//if name of artist does not exist.
		ArtArray[i][0]= StrArray [i][2];
		 // pushing artist name from String Array to ArtArray.
		ArtArray[i][1]= StrArray[i][3];
		//also the Streaming number.
		StreamArray[i] = Integer.parseInt(ArtArray[i][1]);
		// also make a copy to Streaming Array from calculation.
		}
		}
	}
 
public int checkSame(String s){ 
	 for(int i = 0; i < ArtArray.length; i++){
			 if (s == ArtArray[i][0]) { 
				 return i; 
	// checking thought the ArtArray if the name of artist exit, then return the index of ArtArray.
			 }}
				 return -1; 
	//return -1 if not exit.
}

public void artistsInOrder() {
	String tempA;  // create two template for transfer information.
	String tempB;
	for (int i = 0; i < ArtArray[0].length; i++) 
    {
        for (int j = i + 1; j < ArtArray[0].length; j++) 
        { 
            if (ArtArray[i][0].compareTo(ArtArray[j][0]) > 0) 
            {  // compare the current to the previous, place in order A-Z. 
                tempA = ArtArray[i][0];  
                tempB = ArtArray[i][1];
                ArtArray[i][0] = ArtArray[j][0]; // swap them.
                ArtArray[i][1] = ArtArray[j][1];
                ArtArray[j][0] = tempA;
                ArtArray[j][1] = tempB;
            }
        }
    }
}
public void printArray(String[][] s) { //By using this method to print out the element of the 2d array.
	for(int i = 0; i < s.length; i++) {//i for count how many rows of the 2d array.
		for(int j = 0; j < s[0].length ; j++) {//j for count how many columns of the 2d array.
			System.out.print(s[i][j] + " ");
		}
	System.out.println();
	}
}
public void printArtists() {
	printArray(ArtArray);
}
}
class context{
	public static void main(String[] args) {
		String FileName = "D:/computer files/Java/chong/CSIC3130-3/data/regional-us-weekly-2020-01-17--2020-01-24.csv";
		TopArtistsList a = new TopArtistsList(FileName); // create new object.
		
		a.readFiled();
		a.addArtistsStream();
		a.printArtists();
		a.artistsInOrder();
		a.printArtists();      // run each method.
      
}
}

	
