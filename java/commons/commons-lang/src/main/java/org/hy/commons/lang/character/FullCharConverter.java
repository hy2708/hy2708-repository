package org.hy.commons.lang.character;

import java.io.UnsupportedEncodingException;

/**
 * 特殊字符串转换
 * 
 * @Class Name FullCharConverter
 * @Author v-jiangwei
 * @Create In 2012-8-24
 */
public class FullCharConverter {

	/**
	 * 全角转半角的 转换函数
	 * 
	 * @Methods Name full2HalfChange
	 * @Create In 2012-8-24 By v-jiangwei
	 * @param QJstr
	 * @return String
	 */
	public static final String full2HalfChange(String QJstr) {
		StringBuffer outStrBuf = new StringBuffer("");
		String Tstr = "";
		byte[] b = null;
		for (int i = 0; i < QJstr.length(); i++) {
			Tstr = QJstr.substring(i, i + 1);
			// 全角空格转换成半角空格
			if (Tstr.equals("　")) {
				outStrBuf.append(" ");
				continue;
			}
			try {
				b = Tstr.getBytes("unicode");
				// 得到 unicode 字节数据
				if (b[2] == -1) {
					// 表示全角
					b[3] = (byte) (b[3] + 32);
					b[2] = 0;
					outStrBuf.append(new String(b, "unicode"));
				} else {
					outStrBuf.append(Tstr);
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // end for.
		return outStrBuf.toString();

	}

	/**
	 * 半角转全角
	 * 
	 * @Methods Name half2Fullchange
	 * @Create In 2012-8-24 By v-jiangwei
	 * @param QJstr
	 * @return String
	 */
	public static final String half2Fullchange(String QJstr) {
		StringBuffer outStrBuf = new StringBuffer("");
		String Tstr = "";
		byte[] b = null;
		for (int i = 0; i < QJstr.length(); i++) {
			Tstr = QJstr.substring(i, i + 1);
			if (Tstr.equals(" ")) {
				// 半角空格
				outStrBuf.append(Tstr);
				continue;
			}
			try {
				b = Tstr.getBytes("unicode");
				if (b[2] == 0) {
					// 半角
					b[3] = (byte) (b[3] - 32);
					b[2] = -1;
					outStrBuf.append(new String(b, "unicode"));
				} else {
					outStrBuf.append(Tstr);
				}
				return outStrBuf.toString();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return outStrBuf.toString();
	}
	
	 /**
     * 全角转半角
     * @param input String.
     * @return 半角字符串
     */
 public static String ToDBC(String input) {
     char c[] = input.toCharArray();
          
          return ToDBC(c);
 }
 
 public static String ToDBC(char c[]) {
     //char c[] = input.toCharArray();
          for (int i = 0; i < c.length; i++) {
            if (c[i] == '\u3000') {
              c[i] = ' ';
            } else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
              c[i] = (char) (c[i] - 65248);


            }
          }
          String returnString = new String(c);
          return returnString;
 }
	
	/**
     * 半角转全角
     * @param input String.
     * @return 全角字符串.
     */
public static String ToSBC(String input) {
         char c[] = input.toCharArray();
         for (int i = 0; i < c.length; i++) {
           if (c[i] == ' ') {
             c[i] = '\u3000';
           } else if (c[i] < '\177') {
             c[i] = (char) (c[i] + 65248);


           }
         }
         return new String(c);
}




	/**
	 * @Methods Name main
	 * @Create In 2012-8-24 By v-jiangwei
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String QJstr = "８１４乡道";
		String result = FullCharConverter.ToDBC(QJstr);
		System.out.println(QJstr);
		System.out.println(result);
		System.out.println("------------------------------------");
		// 半角转全角
		String str = "大G45大广高速";
		String reString =FullCharConverter.ToSBC(str);
		System.out.println(str);
		System.out.println(reString);
	}

}
