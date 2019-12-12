package pt.upacademy.desafioResolucao.desafio5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Desafio {

	public static int countDays(String string, String string2) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
		LocalDate dt1 = LocalDate.parse (string, dtf);
		LocalDate dt2 = LocalDate.parse (string2, dtf);
		int days = (int) ChronoUnit.DAYS.between(dt1, dt2);
		return days;
	}
	
//public int[] convert (String [] stringArray) {
//	List<Integer> intArray = new ArrayList <Integer>();
//	for (int i = 0; i < stringArray.length; i++) {
//		int j = 
//	}
//	
//}
//
//public static int countDays(String string, String string2) {
//	String [] newString = string.split(" ");
//	String [] newString2 = string2.split(" ");
//	LocalDate dt1 = LocalDate.of(newString[2], newString[1], newString[0]);
//	LocalDate dt2 = LocalDate.of(newString2[2], newString2[1], newString2[0]);
//	
//	
//	
//	return days;
//}
	
	
}
