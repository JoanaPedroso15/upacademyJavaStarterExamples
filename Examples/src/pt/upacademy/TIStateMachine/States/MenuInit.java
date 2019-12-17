package pt.upacademy.TIStateMachine.States;

public class MenuInit extends State {

	@Override
	public int run() {
		int [] possibleOptions = {1,2,3};
		int input2 = sc.isValid("Escolha uma opcao: \n 1)Listar Produtos \n 2)Listar Prateleiras \n 3)Sair", possibleOptions);
		return input2;
	}

}
