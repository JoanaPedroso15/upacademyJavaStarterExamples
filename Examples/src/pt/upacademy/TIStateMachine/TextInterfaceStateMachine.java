package pt.upacademy.TIStateMachine;

import pt.upacademy.TIStateMachine.States.*;

public class TextInterfaceStateMachine {
	private State[] states = {
			new MenuInit(),              //state 0
			new MenuProduct(),           //state 1
			new ProductAdd (),           // state 2
			new MenuPrateleiras()};      //state 3   
			
	
	//podemos fazer uma outra classe de saida e criar um outro estado o estado de Saida;
    
    private int[][] transition = {
    		{1, 2},                      //state 0
    		{2, 1, 1, 1, 0},            //state 1
    		{1},
    		{2, 2, 2, 2, 0}             //state 3 
    		};
   
    private int current = 0;
	
	
	public void start () {
		while (true) {
			int option = states [current].run();
			if (current == 0 && option == 3) {
				System.out.println("Saida");
				break;
			}
			current = transition [current][option-1];
		}
	}
}
