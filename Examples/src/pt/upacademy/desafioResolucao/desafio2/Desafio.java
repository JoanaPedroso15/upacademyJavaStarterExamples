package pt.upacademy.desafioResolucao.desafio2;

import java.util.Arrays;

public class Desafio {

	public static String order(String string) {
		String [] arrayStrings = string.split(" ");
		System.out.println(Arrays.toString(arrayStrings)); 
		StringBuilder result = new StringBuilder ("");
		for (int index=0; index < 10; index++) {
			String s = String.valueOf(index);
			for (int word=0; word < arrayStrings.length; word++) {
				String element = arrayStrings[word];
				if (element.contains(s) == true){
					result.append(element + " ");
				}
			}
			
		}
		String finalResult = result.toString().trim();
		System.out.println(finalResult);
		return finalResult;
	}


}
