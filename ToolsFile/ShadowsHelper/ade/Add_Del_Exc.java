package ade;
import java.io.*;
/*

  @Slipper

*/
public class Add_Del_Exc{
    //Copy instructions from a file to another 
	public static void  copy_ins(String file,String file_copy_name){
	    final int notesLine = 16 ;
	    //Copy contents from file ;
	    try{
		int lines_counter=1;
		RandomAccessFile contents=new RandomAccessFile(file, "rw");
		RandomAccessFile contents_helper = new RandomAccessFile(file, "rw");
		StringBuffer file_buffer=new StringBuffer ();
		String str=null;
		
		while ((str=contents.readLine())!=null){
		    byte b_str[]=str.getBytes();
		    if(b_str[0] !='#'&&!(b_str[b_str.length - 1] == '!')){
			file_buffer.append(Integer.toString(lines_counter)+". ").append(str).append("\r\n");
			lines_counter++;
		    }
		}
		//System.out.print("\n");
		System.out.print(file_buffer);
		
		//Choose operations to execute:
		System.out.print(">>>>>> \n*****  Choose operations you want to execute  ***** \n");
		System.out.print("*****          Press ENTER to Confirm         ***** \n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String oper_to_choose[]=new String[1024];
		int oper_line = 0;
		String tem = br.readLine()+",0000";
		oper_to_choose = tem.split(",");
				
		lines_counter=1;
		int aunum2 = 0;
		file_buffer=new StringBuffer();
		while ((str=contents_helper.readLine())!=null){
		    aunum2 = Integer.parseInt(oper_to_choose[oper_line]);
		    if (lines_counter - notesLine != aunum2 )
			file_buffer.append("#  ").append(str).append("\r\n");
		    else{
			if(aunum2 == 2 || aunum2 == 3 || aunum2 ==4)
			    file_buffer.append("#  ").append(str).append("\n");
			else
			    file_buffer.append(str).append("\n");
			oper_line++;
		    }
		    lines_counter++;
		}

		//add instructions 
		for(int i = 0 ; i < oper_to_choose.length ; i ++ ){
		    if (Integer.parseInt(oper_to_choose[i]) == 2){
			file_buffer.append("javac writeBack.java").
			    append("\n").
			    append("java writeBack").
			    append("\n");
		    }	
		}
		    
		//Write file's contents to another file :
		BufferedWriter bw=new BufferedWriter(new FileWriter(file_copy_name));
		bw.write(file_buffer.toString());

		bw.close();	    
		contents_helper.close();
		contents.close();

		//
		
	    }catch(IOException e){}
	}
}
