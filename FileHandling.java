package fileHandling;
import java.io.*;
import java.util.Scanner;
public class FileHandling {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		  System.out.println("Select one of the operations ");
		        System.out.println(" W for write mode ");
		        System.out.println(" R for read mode ");
		        System.out.println(" A for append mode ");
		        Scanner in =new Scanner(System.in);
		        String s=in.nextLine();
		        
		        if(s.equalsIgnoreCase("R"))
		        {
		            new Reading();
		        }
		        else if(s.equalsIgnoreCase("W")||s.equalsIgnoreCase("A"))
		        {
		            writing(s);
		            
		            
		        }
		        else
		        {
		            System.out.println("Operation is not valid");
		        }
		        
		        
		        in.close();
		 }
			
		 public static void writing(String s)
		 {
		  Scanner sc=new Scanner(System.in);
		  
		  try {
		   
		  String source = "";
		        File f=new File("file1.txt");
		        
		        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		        FileWriter f0 =null;
		        if(s.equalsIgnoreCase("w"))
		        {
		            f0 = new FileWriter(f,false);
		            System.out.println("Warning: It will overwrite the content of the file ");
		            System.out.println("Type 'no' to exit");
		            System.out.println("Do you want to proceed, type : 'yes' ");
		            String s1=sc.nextLine();
		            if(s1.equals("no"))
		            System.exit(0);
		            System.out.println("Write 'stop' when you finish writing file ");
		            f.delete();
		            f.createNewFile();
		            while(!(source=bf.readLine()).equalsIgnoreCase("stop")){
		                f0.write(source + System.getProperty("line.separator"));    
		            }
		            System.out.println("Writing Successfull");
		            
		            sc.close();     
		        }
		        
		        else
		        { f0 = new FileWriter(f,true);
		            System.out.println("Write 'stop' when you finish appending file ");
		            while(!(source=bf.readLine()).equalsIgnoreCase("stop")){
		                f0.append(source+ System.getProperty("line.separator"));
		            }
		            System.out.println("Appending Successfull");
		        }
		        f0.close();
		  }catch(Exception e){
		    System.out.println("Error : " );
		          e.printStackTrace();
		  }
		 }
		}

		class Reading {
		    public static String str="";
		    
		    public Reading() {
		        try{
		            File f5=new File("file1.txt");
		            if(! f5.exists())
		            f5.createNewFile();
		            FileReader fl=new FileReader(f5);
		            BufferedReader bf=new BufferedReader(fl);
		            while((str=bf.readLine())!=null){
		                System.out.println(str);
		            }
		            fl.close();
		            }catch(Exception e){             
		                System.out.println("Error : " );
		                e.printStackTrace();
		            }
		    }

}
