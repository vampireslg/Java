public class Example9_9{
    public static void main(String args[]){
	ClassUp classup=new ClassUp();
	classup.teacher.start();
	classup.student1.start();
	classup.student2.start();
    }
}

class ClassUp implements Runnable{
    Thread student1,student2, teacher;
    ClassUp(){
	teacher=new Thread(this);
	student1=new Thread(this);
	student2=new Thread(this);
	teacher.setName("Professer L");
	student1.setName("Avrile");
	student2.setName("Joy");
    }
    public void run(){
	if(Thread.currentThread()==student1){
		try{System.out.println(student1.getName()+" is sleeping .");
		Thread.sleep(1000*60*10);
		}
		catch(InterruptedException e){
			System.out.println(student1.getName()+" waked up by the teacher .");
		}
		System.out.println(student1.getName()+" 's wake up .");
		student2.interrupt();
	}
	else if(Thread.currentThread()==student2){
		try{System.out.println(student2.getName()+" is sleeping .");
		Thread.sleep(1000*60*60);
		}
		catch(InterruptedException e){
			System.out.println(student2.getName()+" waked up by " + student1.getName());
		}
		System.out.println(student2.getName()+" 's wake up .");
	}
	else if (Thread.currentThread()==teacher){
		for(int i=1; i<=5; i++){
			System.out.println("TimeForClass,Kids ! ");
			try{Thread.sleep(500);}
			catch(InterruptedException e){}
		}
		student1.interrupt();
	}
  }
}
