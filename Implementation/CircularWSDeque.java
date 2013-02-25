import java.util.concurrent.*;

public class CircularWSDeque{
    public final static Object Empty=new Object();
    public final static Object Abort=new Object();

    private final static long LogInitialSize = 10;
    private volatile long bottom = 0;
    private volatile long top = 0 ;
    private volatile CircularArray activeArray = new CircularArray(LogInitialSize);

    private boolean casTop(long oldVal, long newVal){
	boolean preCond;
	synchronized (this){
	    preCond = (top==oldVal);
	    if (preCond)
		top=newVal;
	}
	return preCond;
    }
    public void pushBottom(Object o){
	long b = this.bottom;
	long t = this.top;
	CircularArray a = this.activeArray;
	long size = b - t ;
	if(size > a.size()-1){
	    a = a.grow(b, t);
	    this.activeArray = a;
	}
	a.put(b, o);
	bottom = b + 1;
    }

    public Object popBottom(){
	long b = this.bottom;
	CircularArray a = this.activeArray;
	b = b - 1 ;
	this.bottom = b ;
	long t = this.top;
	long size = b - t ;
	if(size < 0){
	    bottom = t ;
	    return Empty;
	}
	Object o = a.get(b);
	if(size > 0){
	    perhapsShrink(b, t);
	    return o;
	}
	if(!casTop(t, t+1))
	    o = Empty;
	this.bottom = t+1;
	return o;
    }

    void perhapsShrink(long b, long t){
	CircularArray a = this.activeArray;
	if(b - t < a.size()/4){
	    CircularArray aa = a.shrink(b, t);
	    this.activeArray = aa;
	    long ss = aa.size();
	    this.bottom = b + ss;
	    t = this.top;
	    if(!casTop(t, t+ss))
	       this.bottom = b;
	    //a.free();
	}
    }
    public Object steal(){
	long t = this.top;
	CircularArray oldArr = this.activeArray;
	long b = this.bottom;
	CircularArray a = this.activeArray;
	long size = b - t;
	if(size <= 0)
	    return Empty;
	if ((size % a.size()) == 0){
	    if(oldArr == a && t == this.top)
		return Empty;
	    else return Abort;
	}
	Object o = a.get(t);
	if(!casTop(t,t+1))
	    return Abort;
	return o;
    }
}
    class CircularArray{
	private long log_size;
	private Object[] segment;

	CircularArray(long log_size){
	    this.log_size = log_size;
	    this.segment = new Object[1<<this.log_size];
	}
	long size(){
	    return 1<<this.log_size;
	}
	Object get(long i){
	    return this.segment[i % size()];
	}
	void put(long i, Object o){
	    this.segment[i % size()] = o;
	}
	CircularArray grow(long b, long t){
	    CircularArray a = new CircularArray(this.log_size+1);
	    for(long i=t; i<b; i++)
		a.put(i, this.get(i));
	    return a;
	}
	CircularArray shrink(long b, long t){
	    CircularArray a = new CircularArray(this.log_size-1);
	    for(long i=t; i < b ; i++)
		a.put(i,this.get(i));
	    return a;
	}
    }


    