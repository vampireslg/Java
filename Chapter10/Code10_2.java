import java.io.*;
class FileAccept implements FilenameFilter{
    String str=null;
    FileAccept(String s){
	str="."+s; // Be awared of that no SPACE is here .
    }
    public boolean accept(File dir, String s){
	return s.endsWith(str);
    }
}
public class Code10_2{
    public static void main(String[] args){
	File touchFile=new File("/home/gaoang/Java/Chapter10/", "newFile.java");
	File dir=new File("/home/gaoang/Java/Chapter10/");
	File deleted=new File(dir, "E.java");
	FileAccept acceptCondition=new FileAccept("java");
	File fileName[]=dir.listFiles(acceptCondition);
	System.out.println(fileName.length);
	for (int i=0; i<fileName.length;i++){
	    System.out.println("FileName: "+fileName[i].getName());
	}
	boolean isDeleted=deleted.delete();
	
	if(isDeleted){
    System.out.println("File: "+deleted.getName()+" is deleted ");
	}
    }
}