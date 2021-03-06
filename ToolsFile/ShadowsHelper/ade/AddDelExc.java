package ade;
import java.io.*;
/*

  @Slipper

*/
public class AddDelExc{
    //Copy instructions from a file to another
    //Operate on Instructions
	public static void  opeOnIns(String file,String file_copy_name){
	    final int notesLine = 16 ;
	    try{
		int lines_counter=1;
		RandomAccessFile contents=new RandomAccessFile(file, "rw");
		RandomAccessFile contents_helper = new RandomAccessFile(file, "rw");
		StringBuffer file_buffer=new StringBuffer ();
		String str = null;
		
		while ((str = contents.readLine())!=null){
		    if(! (str.trim().startsWith("#") || str.trim().endsWith("!")) ){
			file_buffer.append(String.valueOf(lines_counter)+". ").
			    append(str).append("\n");
			lines_counter++;
		    }
		}
		System.out.print(file_buffer);
		
		//Choose operations to execute:
		System.out.print(">>>>>> \n*****  Choose operations you want to execute  ***** \n");
		System.out.print("*****          Press ENTER to Confirm         ***** \n");
		System.out.print(">>>>> \n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String oper_to_choose[]=new String[1024];
		int oper_line = 0;
		String tem = br.readLine()+",0000";
		oper_to_choose = tem.split(",");
				
		lines_counter=1;
		int aunum2 = 0;
		file_buffer=new StringBuffer();
		
		//Add Or Del instructions 
		for(int i = 0 ; i < oper_to_choose.length ; i ++ ){
		    if (Integer.parseInt(oper_to_choose[i]) == 2)
			file_buffer.append("./xInsert.sh").append("\n");
		    if (Integer.parseInt(oper_to_choose[i]) == 3)
			file_buffer.append("./xRemove.sh").append("\n");
		}
		
		while ((str=contents_helper.readLine())!=null){
		    aunum2 = Integer.parseInt(oper_to_choose[oper_line]);
		    if (lines_counter - notesLine != aunum2 )
			file_buffer.append("#  ").append(str).append("\r\n");
		    else{
			if(aunum2 == 2 || aunum2 == 3 )
			    file_buffer.append("#  ").append(str).append("\n");
			else
			    file_buffer.append(str).append("\n");
			oper_line++;
		    }
		    lines_counter++;
		}
				    
		//Write file's contents to another file :
		BufferedWriter bw=new BufferedWriter(new FileWriter(file_copy_name));
		bw.write(file_buffer.toString());

		bw.close();	    
		contents_helper.close();
		contents.close();
	    }catch(IOException e){}
	}
}
