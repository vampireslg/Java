interface ShowMessage{
	void showMessage(String s);
}
class Moto implements ShowMessage{
	public void showMessage(String s){
		System.out.println(s);
	}
}
class Sumsung implements ShowMessage{
	public void showMessage(String s){
		System.out.println(s);
	}
}
public class problem4_15 {
	public static void main (String args[]){
		ShowMessage sm;
		sm=new Moto();
		sm.showMessage("We provide best products !");
		sm=new Sumsung();
		sm.showMessage("We provide best experiences !");
	}
}