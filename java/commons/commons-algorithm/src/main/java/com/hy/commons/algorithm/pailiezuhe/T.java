package com.hy.commons.algorithm.pailiezuhe;
class T{
    public static void main(String[] args){
        aa
    }
    List<List<String>> list=new LinkedList<List<String>>();
    
    public static void paiie(List<String> selected,List<String> rest){
        if(rest.size()==0){
                        list.add(selected);
        }
        for(int i=0;i<rest.length();i++){
            List<String>  selectedTemp = cloneList(selected).add(rest.get(i));
            
            ist<String> restTemp= cloneList(rest);
                restTemp.remove(i);
            pailie(selectedTemp,restTemp)  ;  
        }
    }
    
    public static List<String> cloneList(List<String> selected){
        return null
    }
    