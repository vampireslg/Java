import java.io.*;
public class Code10_1{
    public static void main(String[] args){
	File f1=new File("/home/gaoang/Java/13Chaptersrc/", "Code13_7.java");
	File f2=new File("/home/gaoang/Java/");
	System.out.println("Is file Code...java readable ?" +f1.canRead());
	System.out.println("Is file Code...java writable ?" +f1.canWrite());
	System.out.println("Absolute path of Code..java " + f1.getAbsolutePath());
	System.out.println("Is directory ?" + f2.isDirectory());
	System.out.println("The length of Code.java:  "+f1.length());
	System.out.println("getParent of it : "+ f1.getParent());
	System.out.println("Name "+f1.getName()+"\nlastedModified : "+f1.lastModified()+"\nIs existed or not: "+f1.exists());
    }
}