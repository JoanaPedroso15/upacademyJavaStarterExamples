package pt.upacademy.desafios.desafio1;

public class Desafio {
	private int count;
	private int Big3;
	private int Big5;

	public Desafio(int i) {
		this.count = i;
	}

	public void run() {
		for (int index =1; index <= count; index++) {
			if (index % 3 == 0 && index % 5 ==0) {
				Big3++;
				Big5++;
			} else if (index % 3 == 0) {
				Big3++;
			} else if (index % 5 == 0) {
				Big5++;
			}
		}
		
	}

	public int getBig3Count() {
		return Big3;
	}

	public int getBig5Count() {
		return Big5;
	}

}
