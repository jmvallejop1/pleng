/*********************************************************************************
 * Excepcion utilizada al intentar declarar un simbolo con el mismo nombre
 * que alguno de los existentes en el nivel actual
 *
 * Fichero:    SimboloYaDeclaradoException.java
 * Fecha:      29/03/2021
 * Versión:    v1.0
 * Asignatura: Procesadores de Lenguajes, curso 2020-2021
 **********************************************************************************/

package semantico;

public class SimboloYaDeclaradoException extends Exception {

	private static final long serialVersionUID = 1L;

	public SimboloYaDeclaradoException() {

	}
}
