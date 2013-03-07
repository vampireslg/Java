1. import java.io.*;
2. import static Package.print.Print.*;
3. import java.util.Scanner;
4. /*
5.   Read file by line and ADD line number ,then write it to another file .  
6.   @copyrightL 
7. */
8. 
9. class exer_8{
10.     public static void main(String[] args){
11. 	Scanner file=new Scanner(System.in);
12. 	String fileName=file.next();
13. 	Scanner file2=new Scanner(System.in);
14. 	String file_copy_name=file2.next();
15. 	read_by_line(fileName,file_copy_name);
16. 	
17.     }
18.     public static void  read_by_line(String file,String file_copy_name){
19. 	
20. 	//Copy contents from file ;
21. 	try{
22. 	    int lines_counter=1;
23. 	    RandomAccessFile contents=new RandomAccessFile(file, "rw");
24. 	    StringBuffer file_buffer=new StringBuffer ();
25. 	    String str=null;
26. 	    
27. 	    while ((str=contents.readLine())!=null){
28. 		file_buffer.append(Integer.toString(lines_counter)+". ").append(str).append("\r\n");
29. 		lines_counter++;
30. 	    }
31. 	    // Print the contents with line number :
32. 	    print(file_buffer);
33. 	    
34. 	    //Write file's contents to another file :
35. 	    BufferedWriter bw=new BufferedWriter(new FileWriter(file_copy_name));
36. 	    bw.write(file_buffer.toString());
37. 	    bw.close();	    
38. 
39. 	    contents.close();
40. 
41. 	}catch(IOException e){}
42.        
43. 
44.     }
45. }
