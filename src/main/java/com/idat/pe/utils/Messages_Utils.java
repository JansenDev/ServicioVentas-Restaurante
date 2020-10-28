package com.idat.pe.utils;

public class Messages_Utils {

	private String referencia;

	public Messages_Utils() {
	}

	public Messages_Utils(String referencia) {
		this.referencia = referencia;
	}

	public String getNotFound() {
		return String.format("Valor no encontrado");
	}

	public String getNotFound(String referencia) {
		return String.format("%s, no encontrado", referencia);
	}

	public String getNotFound(int referencia) {
		return String.format("%d, no encontrado", referencia);
	}

	/**/
	public String getParamInvalid() {
		return String.format("Parametros inválidos");
	}

	/* TODO: Implementar que reciba un array de objetos y lo imprima */
	public String getParamInvalid(String referencia) {
		return String.format("Parametros inválidos: %s", referencia);
	}
	/**/

	public String getNotExists() {
		return String.format("Valor no  existe");
	}

	public String getNotExists(String referencia) {
		return String.format("%s no existe", referencia);
	}

	public String getNotExists(int referencia) {
		return String.format("%d no existe", referencia);
	}

	/**/

	public String getSuccessDelete() {
		return String.format("El valor se eliminó correctamente!");
	}

	public String getSuccessDelete(String referencia) {
		return String.format("Se eliminó %s correctamente!", referencia);
	}
	
	public String getSuccessDelete(int referencia) {
		return String.format("Se eliminó %d correctamente!", referencia);
	}

	/**/
	
	public String getErrorDelete() {
		return String.format("Error al eliminar!");
	}
	
	public String getErrorDelete(String referencia) {
		return String.format("Error al eliminar %s", referencia);
	}

	public String getErrorDelete(int referencia) {
		return String.format("Error al eliminar %d", referencia);
	}

	/* Gettes and Setters */

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

}
