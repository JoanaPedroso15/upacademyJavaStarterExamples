package pt.upacademy.TIStateMachine.States;

import pt.upacademy.TIStateMachine.ScannerUtils.ScannerUtils;

public abstract class State {
	public static  ScannerUtils sc= new ScannerUtils ();  
	
	public abstract int run ();  //metodo abstracto - qualquer classe que estenda esta, e obrigada a fazer implementacao do run.
	

}
