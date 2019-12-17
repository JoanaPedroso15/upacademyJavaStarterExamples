package pt.upacademy.TIStateMachine.States;

public class ProductAdd extends State{

	@Override
	public int run() {
		System.out.println("Adicionar novo Produto");
		return 1; //retorna sempre um que e para a option ser = 1 e por isso ele vai sempre ao index 0 da matriz de transicao
	}
	
}
