package pt.upacademy.TIStateMachine.States;

public class MenuProduct extends State {

	@Override
	public int run() {
		String msgShelfs = ("Por favor selecione uma das seguintes opções:\n" + 
				"1) Criar novo produto\n" + 
				"2) Editar um produto existente\n" + 
				"3) Consultar o detalhe de um produto\n" + 
				"4) Remover um produto\n" + 
				"5) Voltar ao ecrã anterior");

		int [] possibleValues = {1,2,3,4,5};
		int input = sc.isValid (msgShelfs,possibleValues);
		return input;
	}

}
