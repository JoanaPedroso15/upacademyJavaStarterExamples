package pt.upacademy.desafios.desafio4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class Desafio {

	public static int[] ints(String string) {
		String [] newString = string.split(" ");
		List <Integer> listNum = new ArrayList <Integer>();
		for (int j = 0; j < newString.length; j++) {
			String element = newString[j];
			for (int i=0; i <10; i++) {
				String s = String.valueOf(i);
				if (element.equals(s) == true) { // nao posso por element == s porque Strings in Java nao e um tipo primitivo, portanto vai comparar referencias de memoria
					int k = Integer.parseInt(element);
					listNum.add(k);
					
				}
			}
			
		}
		System.out.println(listNum);
		int [] arrayNum = listNum.stream().mapToInt(i -> i).toArray();
		return arrayNum;
	}

}
