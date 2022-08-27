/*
 * 
 * 
 * this program is created to work with separate methods of reading from file 
 * the idea is to get the position of the word which we search within the file
 * scanner allows us to find the word within the file and also gives us the line where it is but does not support getting location of word in the file. 
 * we can use index of function on the line which has been returned but where is the line in the file we dont know 
 *   
 */




package tryraf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
 
public class tryraf {
    
 
  
    public static void main(String[] args) {
	
	getfile  mygetfile  = new getfile();
	mygetfile.fileselect();
	
    }
 
}	//end of class 
