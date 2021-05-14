package model.exceptions;

public class DomainExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/*Vou criar um constructor que recebe uma string msg como argumentoe depois repassar
	 essa msg para o constructor da superClasse*/

	public DomainExceptions(String msg) {
		super(msg);
	}
}
