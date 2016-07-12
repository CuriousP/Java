
public class SplitString {
	public static void main(String[] args) {
		String s = "happyholidaysdecem";
		char str[] = s.toCharArray();
		char str1[] = new char[20];
		char str2[] = new char[20];
		char str3[] = new char[20];

		for (int i = 0; i < 6; i++) {
			str1[i] = str[i];
		}
		for (int i = 6; i < 11; i++) {
			str2[i] = str[i];
		}
		for (int i = 11; i < 18; i++) {
			str3[i] = str[i];
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(str1[i]);	
		}
		System.out.print(";");
		for (int i = 6; i < 11; i++) {
			System.out.print(str2[i]);
		}
		System.out.print(";");
		for (int i = 11; i < 18; i++) {
			System.out.print(str3[i]);
		}
	}
}

