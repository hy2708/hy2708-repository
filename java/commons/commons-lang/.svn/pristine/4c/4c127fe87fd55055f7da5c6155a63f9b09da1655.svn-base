package org.hy.commons.lang.character;

public class RemoveSpaces {
	public static final String removeSpace(String ss) {
		byte[] t = ss.getBytes();
		for (int i = 0; i < t.length; i++) {
			if (t[i] == -95 && t[i + 1] == -95) {
				t[i] = 32;
				if (i + 1 == t.length - 1) {
					t[i + 1] = 0;
				} else {
					for (int j = i + 1; j + 1 < t.length; j++) {
						t[j] = t[j + 1];
						if (j + 1 == t.length - 1)
							t[j + 1] = 32;
					}
				}

			}
		}
		return new String(t);
	}

	public static void main(String arg[]){

  String test = "我　是　好　人";

 String result=removeSpace(test );

   System.out.println(test +"\n"+result);
   System.err.println();

}
}