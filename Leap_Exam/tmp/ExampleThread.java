//package example;

public class ExampleThread {
    public static void main (String [] args) {
    	
    	String url="key1=AliceNikita&key2=Bob"; 
        URLParse urlparse = new URLParse (url);          
        Thread t1 = new exampleThread(urlparse ,"key1");    
        Thread t2 = new exampleThread(urlparse ,"key2");
	// 	System.out.println(url.substring(3));	
        System.out.println("\n\n\nbefore parsing: "+urlparse.
        t2.start ();
	t1.start();
	   try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("after parsing: "+urlparse.getURL()+"\n\n\n");
	}
}
///////////////////////////////////////////

class exampleThread extends Thread                                  
{                                                                            
    URLParse urlparse;                                             
    String key;                                                         
    exampleThread(URLParse url,String key){                                                                        
        this.urlparse = url;                                  
        this.key = key;                                               
    }                                                                       
    public void run()                                               
    {       
    	try{
    		urlparse.parse(key);     
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    		"leap_Crashed_with".equals(e);
    		System.exit(1);
    	}
    }                                                                      
}

/////////////////////////////////////////////////////////////

class URLParse {
	private String url;                                                    
    	//String url="key1=IamNotAlice&key2=Bob"; 
	URLParse (String url)
	{                                            
	   this.url=url;                                                    
	}                                                                                                      
	public void parse(String key)                                            
	{                                                                           
    	String val = getVal(key);
    	if(val.equals("AliceNikita"))
    		replaceVal(key,"A");
    	if(val.equals("Bob"))
    		replaceVal(key,"B");
	}
	private void replaceVal(String key, String newVal)
	{
        int keyPos=url.indexOf(key);                             
        int valPos=url.indexOf("=", keyPos)+1;               
        int ampPos=url.indexOf("&", keyPos);                
        if(ampPos<0) ampPos = url.length();   //That is no & exists .	               
        url=url.substring(0, valPos) 	                               // From 0 to place = was found ,that is "key1="
	    +newVal+url.substring(ampPos); 	       // url : "key1=newVal&key2=oldVal" 
    	}                                                                          
    private String getVal(String key)
    { 	                       
        int keyPos=url.indexOf(key); 	                       
        int valPos=url.indexOf("=", keyPos)+1; 	       
        int ampPos=url.indexOf("&", keyPos); 	               
        if(ampPos<0) ampPos=url.length();

        /*
         * The follow code makes the program easy to crash
         */
/*        
        try 
		{
	   		if(key.equals("key2"))
			Thread.currentThread().sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
*/		
        return url.substring(valPos,ampPos);                  
	}
    public String getURL()
    {
    	return url;
    }
}
