package br.com.transfinder.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3301266772427444644L;

	public ObjectNotFoundException(String objectName, Long id) {
		super(String.format("%s com o identificador %s não encontrado...", objectName, id));
	}
}
