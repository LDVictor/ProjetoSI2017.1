
package exceptions;

public class ObjetoNullException extends ControllerException {

	private static final long serialVersionUID = 1L;
	
	public ObjetoNullException (String mensagem) {
		super("Foi passado um valor nulo em vez de um(a)" + mensagem);
	}
	
}