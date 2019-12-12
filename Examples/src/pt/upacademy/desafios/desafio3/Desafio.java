package pt.upacademy.desafios.desafio3;

public class Desafio {

	public static int points(String[] strings) {
		int result = 0;
		for(int i = 0; i < strings.length; i++) {
			String element = strings[i];
			if (element.charAt(2) < element.charAt(0)) {
				result = result + 3;
			}else if (element.charAt(2) > element.charAt(0)) {
				result = result + 0;
			} else if (element.charAt(2) == element.charAt(0)) {
				result = result + 1; 
			}
		}
	return result;
	}

}
