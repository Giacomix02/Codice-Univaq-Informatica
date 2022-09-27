

public class Lezione2Es6 {

	public static void main(String[] args) {
		
		String x=args[0];
		char[] c = new char[x.length()];
		
		for(int i=0;i<x.length();i++){
			c[i]=x.charAt(i);
			
			System.out.println(c[i]);
		}
	}
}
