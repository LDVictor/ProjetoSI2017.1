
package exceptions;

public class IDNegativoException extends ControllerException {

	private static final long serialVersionUID = 1L;
	
	public IDNegativoException  (String mensagem) {
		super("O ID de " + mensagem + " não pode ser negativo");
	}
	
}