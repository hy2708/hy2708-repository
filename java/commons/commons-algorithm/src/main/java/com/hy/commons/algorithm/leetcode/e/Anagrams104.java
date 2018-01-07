package leetcode151withexplain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �������⣺����һ���ַ�������ȡ�������з�ת���ַ��������ظ��Ȱ�Ŀ��
 * 
 * ����˼·��ͨ��һ��map�����㣬map��key���ڼ�¼�ַ�����map��value���ڼ�¼�ַ��������еߵ��ַ�����
 * ͨ��map��һ���ݽṹ�����˼��㡣
 * 
 *
 */
public class Anagrams104 {
	
	public static void main(String[] args) {
		String string="abcdef";
		List<String> list= anagrams(new String[]{""});
	}
	
 	public static List<String> anagrams(String[] strs) {
 		//���ڼ�¼���
        List<String> answer = new ArrayList<String>();
        int strsLength = strs.length;
        if(strsLength == 0) return answer;
        
        //map��key���ڴ洢String��value���ڴ洢����ߵ�˳��������ַ���
        Map<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        for(int i = 0; i < strsLength; i++){
            String s = strs[i];
            //ת��Ϊ�ַ�����
            char[] schar = s.toCharArray();
            //�������������
            Arrays.sort(schar);
            String stemp = String.valueOf(schar);
            //������ǰ�ַ����Ƿ��Ѿ�������map�У�������ڣ���ô�Ͱ����е��ַ����ӵ�value�У���������ڣ���ô��ѹ��һ���µ���ֵ
            if(map.get(stemp) == null){
                ArrayList<String> value = new ArrayList<String>();
                value.add(s);
                map.put(stemp,value);
            }else{
                map.get(stemp).add(s);
            }
        }
        
        //����map�е�ÿһ��value����value�Ĵ�С>1��ʱ�򣬾�˵�����ڵߵ����ַ���
        for(Map.Entry<String,ArrayList<String>> entry : map.entrySet()){
            if(entry.getValue().size() > 1){
                answer.addAll(entry.getValue());
            }
        }
        
        return answer;
    }
}
