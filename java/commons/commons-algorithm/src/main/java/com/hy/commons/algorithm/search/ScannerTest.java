package com.hy.commons.algorithm.search;
import java.util.Scanner;

public class ScannerTest {

 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  //receive string
  String str = s.next();
  
  //receive integer
  Integer i = s.nextInt();
  
  //receive double
  Double d = s.nextDouble();
  
  System.out.println(str+i+d);
 }
}