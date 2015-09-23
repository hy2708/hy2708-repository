package org.hy.commons.db.metadata;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Deprecated
public class StringMatch {
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getIndexOfBestMatch() {
		return indexOfBestMatch;
	}

	public void setIndexOfBestMatch(int indexOfBestMatch) {
		this.indexOfBestMatch = indexOfBestMatch;
	}

	public Map<String, Object> getStringMatchMap() {
		return stringMatchMap;
	}

	public void setStringMatchMap(Map<String, Object> stringMatchMap) {
		this.stringMatchMap = stringMatchMap;
	}

	private String key=null;
	private int indexOfBestMatch =-1;
	private Map<String, Object> stringMatchMap = new HashMap<String, Object>();
	
	private Map<String, String> matchs(List<String> list, List<String> list2) {
		Map<String, String> returnMap = new HashMap<String, String>();
		List<StringMatch> list3 = new LinkedList<StringMatch>();
		
		if (list.size()==list2.size()) {
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list2.size(); j++) {
					if (list.get(i).equalsIgnoreCase(list2.get(j))) {
						indexOfBestMatch = j;
						break;
					}
					//else if (condition) {
//						
//					}
					
				}
			}
		}
//		for (int i = 0; i < list.size(); i++) {
//			list.get(i).equalsIgnoreCase(target);
//			return i;
//		}
		return null;

	}
}
