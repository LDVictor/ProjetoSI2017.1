
package exceptions;

public class IDInexistenteException extends ControllerException {

	private static final long serialVersionUID = 1L;
	
	public IDInexistenteException (String mensagem) {
		super("Não existe esse ID de " + mensagem);
	}
	
}