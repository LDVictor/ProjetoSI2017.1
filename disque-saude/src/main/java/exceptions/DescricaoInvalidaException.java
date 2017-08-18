
package exceptions;

public class DescricaoInvalidaException extends ControllerException {

	private static final long serialVersionUID = 1L;
	
	public DescricaoInvalidaException() {
		super("A descrição não pode ser vazia ou um valor nulo");
	}
	
}