
public class Lezione2Es2 {

	public static void main(String[] args) {

		for (int x = 0, y = 0; x <= 50 && y <= 50; x++, y++) {
			System.out.println("x >>" + x);
			System.out.println("y >>" + y);
		}

		int x = 0;
		int y = 0;
		while (x < 51 && y < 51) {
			System.out.println("x while >>" + x);
			System.out.println("x while >>" + y);
			x++;
			y++;
		}

	}

}
