package pt.upacademy.TIStateMachine.States;

public class MenuPrateleiras extends State {

	@Override
	public int run() {
		String msgShelfs = ("Por favor selecione uma das seguintes opções:\n" + 
				"1) Criar nova prateleira\n" + 
				"2) Editar uma prateleira existente\n" + 
				"3) Consultar o detalhe de uma prateleira\n" + 
				"4) Remover uma prateleira\n" + 
				"5) Voltar ao ecrã anterior");
		
		int [] possibleValues = {1,2,3,4,5};
		int input = sc.isValid (msgShelfs,possibleValues);
		return input;
	}

}
