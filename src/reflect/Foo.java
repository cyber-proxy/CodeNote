package reflect;

public class Foo {
	private int bar;
	
	public Foo(){
		setBar(17);
	}
	
	private void setBar(int bar){
		this.bar = bar;
	}
	
	public int getBar(){
		return bar;
	}
	
	public String toString(){
		return "Foo [bar = "+bar+" ]";
	}
	
}
