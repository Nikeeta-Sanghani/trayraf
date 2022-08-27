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

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class getfile {

     ArrayList<Long> positions;
    final ArrayList <String> tosearch;
    Long current;
  
    final Map<String, ArrayList<Long>> wordregister;
    File dir;
  
    Path filePath;
    Charset charset;
    RandomAccessFile myrafile; 
    String data = "";
    long fileoffset;
    char charread;
    String line, templine,tosearchstring;
   
   
    
    
    
    public getfile()
    {
	     
	
	// default constructor

	wordregister=new HashMap<String, ArrayList<Long>>();
	positions=new ArrayList<Long>();
	tosearch=new ArrayList<String>();
	
	
    }
   
    public void fileselect() {
	
	
	
	
	try {
	    	
	  	
		JFileChooser fileChoser=new JFileChooser(System.getProperty("user.dir","."));  // this will by default open the user current directory to choose the file
		fileChoser.setAcceptAllFileFilterUsed(false); // this means not all file types will be shown. only files which match your fileters defined will be shown
		fileChoser.addChoosableFileFilter(new FileNameExtensionFilter("*.text", "txt"));   // this will show only all txt file
		if ( fileChoser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) 
			{
		    	filePath = Paths.get(fileChoser.getSelectedFile().getPath());
		        charset = StandardCharsets.UTF_8;
		
	        	String fileName = fileChoser.getSelectedFile().getPath(); // this gives the OS file path
	        	dir = fileChoser.getSelectedFile(); // give the selected file in object format

	                  // 'r' means opening file in Read mode  "rw" means read write mode
	                  myrafile = new RandomAccessFile(fileName, "r");
	                  myrafile.seek(0L);
	       
	                  
	                  byte[] arr = new byte[(int) myrafile.length()];
	                  
	                  // read the file
	                  myrafile.readFully(arr);
	                  myrafile.seek(0L);
	                  tosearch.add("this");
	                  tosearch.add("is");
	                
	               // moves pointer to the first location to read
	                for (String tempstring:tosearch)
	                {
	                  
	                  //positions.clear(); // clear positions for the next word
	                  positions=new ArrayList<Long>(); // create this instance for each of the word otherwise it will simply overwrite older posted values also
	                  myrafile.seek(0); // reset pointer to the beginning of the file. 
	                  tosearchstring=tempstring.trim();
	                  current = 0L; 
	              
	                while (current < myrafile.length()) {
	                    current = myrafile.getFilePointer(); // update to the next location to be read this is important that it is done right at the begining
	                    
	                    // read the file line by line
	                    //String result = myrafile.readUTF(); // this gives error
	                    String result = myrafile.readLine();
	                    templine=result;
	                  if (result!=null)
	                    if (result.contains(tosearchstring))
	                    {
	                	doparsegotline();
	                    } // end of nested iff

	                	}  // end of while
	        	doaddtomap();
	                } // end of foreach tosearch
	        		
	                
	                }  // end of for tosearch araylist
	                
	             //   System.out.println("Now printing array of bytes as string");
	              //    String s1= new String(arr);
	               //  System.out.print(s1);
	      
	        	myrafile.close();
	        	System.out.println("Keys in the Map----->"+wordregister.keySet());
	        	System.out.println(wordregister.entrySet());
	        	
			

  		} catch (IOException e2) {
  		    	e2.printStackTrace();
  			} // end of catch
		
    }	//end of action performed




private  void doaddtomap() {
	
	   if (!wordregister.containsKey(tosearchstring))
			{
				wordregister.put(tosearchstring, positions);
			}
	   	
	// TODO Auto-generated method stub
	
		} // end of method doaddtomap
private  void doparsegotline() {

	    
	    try {
		
		positions.add(current);
		positions.add((long) templine.indexOf(tosearchstring)); // current word position in the line
	    } catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }// current line position
    
		} // end of parsegotline  

} // end of class 
