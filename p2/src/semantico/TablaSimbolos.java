/*********************************************************************************
 * Clase que define la tabla de simbolos  del compilador de MiniLeng.
 * Se implementa mediante una tabla de dispersion abierta.
 *
 * Fichero:    Tabla_simbolos.java
 * Fecha:      1/4/2021
 * Version:    v1.0
 * Asignatura: Procesadores de Lenguajes, curso 2020-2021
 **********************************************************************************/

package semantico;

import semantico.Simbolo.*;

//import lib.aviso.Aviso;

import java.util.Random;

import compiler.Token;
import compiler.MiniLengCompiler;

import java.util.LinkedList;
import java.util.Iterator;

public class TablaSimbolos {
	// TODO: Elegir tamano de la tabla y ponerlo en decisiones de diseno
	private final int M = 233;

	// TODO: Elegir funcion de hash. Se debe generar considerando solo el nombre del
	// simbolo
	// Se usa el metodo de Pearson como funcion de hash

	// Los simbolos se almacenan en las listas por nivel descendente, para encontrar
	// los elementos
	// con nivel mas alto sin recorrer toda la lista de colisiones

	private int T[];

	// Para manejar las coliciones hay que utilizar encadenamiento de colisiones
	// generando una tabla abierta.

	private LinkedList<Simbolo> tabla_hash[];

	@SuppressWarnings("unchecked")
	public TablaSimbolos() {
		// Crea la tabla hash
		tabla_hash = new LinkedList[M];

		T = new int[M];
	}

	/*
	 * Crea una tabla de simbolos vacia. Este procedimiento debe invocarse antes de
	 * hacer ninguna operacion con la tabla de simbolos.
	 */
	public void inicializar_tabla() {
		for (int i = 0; i < M; i++) {
			tabla_hash[i] = new LinkedList<Simbolo>();
		}

		// Generar vector T
		for (int i = 0; i < M; i++) {
			T[i] = i;
		}

		mezclaVector(T);
	}

	/*
	 * Algoritmo de Fisher-Yates para permutar aleatoriamente los elementos de un
	 * vector
	 */
	private void mezclaVector(int[] a) {
		Random rnd = new Random();
		for (int i = a.length - 1; i > 0; i--) {
			// Genera un numero aleatorio j tal que 0 <= j 0 <= i
			int j = rnd.nextInt(i + 1);

			// Intercambia a[j] y a[i]
			int aux = a[j];
			a[j] = a[i];
			a[i] = aux;
		}
	}

	/*
	 * Funcion de hash utilizando el algoritmo de Pearson
	 */
	private int h(String cadena) {
		int h = 0;
		for (int i = 0; i < cadena.length(); i++) {
			h = T[(h ^ cadena.charAt(i))%M];
		}
		return h%M;
	}

	/*
	 * Busca en la tabla el simbolo de mayor nivel cuyo nombre coincida con el del
	 * parametro (se distinguen minusculas y mausculas). Si existe, devuelve un
	 * puntero como resultado, de lo contrario lanza una excepcion.
	 */
	public Simbolo buscar_simbolo(String nombre) throws SimboloNoEncontradoException {
		int clave = h(nombre);
		//System.out.println("Salgo de la clave " + clave);
		for (Simbolo s : tabla_hash[clave]) {
			//System.out.println("Estoy buscando:" + nombre + " y lo comparo con: "+ s.getNombre());
			if (s.nombre.equals(nombre) && s.esVisible()) {
				return s;
			}
		}
		//return null;

		// Si no se ha encontrado
		//TODO: mirar lo de las excepciones
		throw new SimboloNoEncontradoException();
	}

	/*
	 * Introduce en la tabla un simbolo PROGRAMA, con el nombre del parametro, de
	 * nivel 0, con la direccion del parametro. Dado que debe ser el primer simbolo
	 * a introducir, NO SE VERIFICA QUE EL SIMBOLO YA EXISTA.
	 */
	public Simbolo introducir_programa(String nombre, int dir) {
		Simbolo simbolo = new Simbolo();
		simbolo.introducir_programa(nombre, 0, dir);
		simbolo.setDir(dir);

		int clave = h(nombre);
		tabla_hash[clave].addFirst(simbolo);

		return simbolo;
	}




	/*
	 * Si existe un simbolo en la tabla del mismo nivel y con el mismo, nombre,
	 * lanza una excepcion. De lo contrario, introduce el simbolo pasado como
	 * parmetro.
	 */
	private Simbolo introducir_simbolo(Simbolo simbolo) throws SimboloYaDeclaradoException {
		int clave = h(simbolo.getNombre());

		for (Simbolo s : tabla_hash[clave]) {
			// Si el simbolo ya esta declarado en ese mismo nivel, lanzar una excepcion
			if (s.getNombre().equals(simbolo.getNombre()) && s.getNivel() == simbolo.getNivel()) {
				
				//permitimos simbolos en el mismo nivel con el mismo nombre si son de tipos distintos
				if(s.tipo == simbolo.tipo) {
					throw new SimboloYaDeclaradoException();
				}
				else {
						System.out.println("ya hay un simbolo con el nombre: " + simbolo.getNombre() +" pero se ha a�adido porque era de tipo distinto");
				}
			}
		}

		// Si no se ha lanzado la excepcion, se anade
		tabla_hash[clave].addFirst(simbolo);

		return simbolo;
	}




	/*
	 * Si existe un simbolo en la tabla del mismo nivel y con el mismo nombre, lanza
	 * una excepcion. De lo contrario, introduce un simbolo VARIABLE (simple) con
	 * los datos de los argumentos.
	 */
	public Simbolo introducir_variable(String nombre, Tipo_variable variable, int nivel, int dir)
			throws SimboloYaDeclaradoException {
		Simbolo simbolo = new Simbolo();
		simbolo.introducir_variable(nombre, variable, nivel, dir);
		return introducir_simbolo(simbolo);
	}

	/*
	 * Si existe un simbolo en la tabla del mismo nivel y con el mismo nombre, lanza
	 * una excepcion. De lo contrario, introduce un simbolo ACCION con los datos de
	 * los argumentos.
	 */
	public Simbolo introducir_accion(String nombre, int nivel, int dir) throws SimboloYaDeclaradoException {
		Simbolo simbolo = new Simbolo();
		simbolo.introducir_accion(nombre, nivel, dir);
		return introducir_simbolo(simbolo);
	}

	/*
	 * Si existe un simbolo en la tabla del mismo nivel y con el mismo nombre, lanza
	 * una excepcion. De lo contrario, introduce un simbolo PARAMETRO con los datos
	 * de los argumentos.
	 */
	public Simbolo introducir_parametro(String nombre, Tipo_variable variable, Clase_parametro parametro, int nivel,
			int dir) throws SimboloYaDeclaradoException {
		Simbolo simbolo = new Simbolo();
		simbolo.introducir_parametro(nombre, variable, parametro, nivel, dir);

		return introducir_simbolo(simbolo);
	}

	/*
	 * Si existe un simbolo en la tabla del mismo nivel y con el mismo nombre, lanza
	 * una excepcion. De lo contrario, introduce un simbolo VARIABLE vector con los datos
	 * de los argumentos.
	 */
	public Simbolo introducir_variable_vector(String nombre, Tipo_variable variable, int longitud, int nivel,
			int dir) throws SimboloYaDeclaradoException {
		Simbolo simbolo = new Simbolo();
		simbolo.introducir_variable_vector(nombre, variable, longitud, nivel, dir);

		return introducir_simbolo(simbolo);
	}

	/*
	 * Si existe un simbolo en la tabla del mismo nivel y con el mismo nombre, lanza
	 * una excepcion. De lo contrario, introduce un sÃ­mbolo PARAMETRO vector con los datos
	 * de los argumentos.
	 */
	public Simbolo introducir_parametro_vector(String nombre, Tipo_variable variable, Clase_parametro clase, int longitud, int nivel,
			int dir) throws SimboloYaDeclaradoException {
		Simbolo simbolo = new Simbolo();
		simbolo.introducir_parametro_vector(nombre, variable, clase, longitud, nivel, dir);

		return introducir_simbolo(simbolo);
	}

	/*
	 * Elimina de la tabla todos los simbolos del nivel y tipo pasados como
	 * parametros
	 */
	private void eliminar_tipo_en_nivel(int nivel, Tipo_simbolo tipo) {
		for (int i = 0; i < M; i++) {
			Iterator<Simbolo> iter = tabla_hash[i].iterator();
			while (iter.hasNext()) {
				Simbolo s = iter.next();
				if (s.nivel == nivel && s.tipo == tipo) {
					iter.remove();
				}
			}
		}
	}

	/*
	 * Elimina el simbolo con nombre y nivel iguales a los pasados como parametros
	 */
	@SuppressWarnings("unused")
	private void eliminar_simbolo(String nombre, int nivel) {
		int clave = h(nombre);
		Iterator<Simbolo> iter = tabla_hash[clave].iterator();

		Boolean borrado = false;
		while (iter.hasNext() && borrado == false) {
			Simbolo s = iter.next();
			if (s.nombre == nombre && s.nivel == nivel) {
				iter.remove();
				borrado = true;
			}
		}
	}

	/*
	 * Elimina de la tabla todos los simbolos PROGRAMA de nivel 0 (deberia haber uno
	 * solo).
	 */
	public void eliminar_programa() {
		eliminar_tipo_en_nivel(0, Tipo_simbolo.PROGRAMA);
	}

	/*
	 * Elimina de la tabla todas las variables que sean del nivel del argumento. NO
	 * ELIMINA PARAMETROS.
	 */
	public void eliminar_variables(int nivel) {
		eliminar_tipo_en_nivel(nivel, Tipo_simbolo.VARIABLE);
	}

	/*
	 * Elimina de la tabla todos los parametros de un nivel.
	 */
	public void eliminar_parametros(int nivel) {
		eliminar_tipo_en_nivel(nivel, Tipo_simbolo.PARAMETRO);
	}

	/*
	 * Elimina de la tabla todas las acciones de un nivel. LOS PARAMETROS DE ESTAS
	 * ACCIONES DEBEN SER ELIMINADOS TAMBIEN PARA MANTENER LA COHERENCIA DE LA
	 * TABLA.
	 */
	public void eliminar_acciones(int nivel) {
		eliminar_tipo_en_nivel(nivel, Tipo_simbolo.ACCION);
	}
	
	public void ocultar_parametros(int nivel) {
		//System.out.println("Voy a ocultar parametros");
		for (int i = 0; i < M; i++) {
			Iterator<Simbolo> iter = tabla_hash[i].iterator();
			while (iter.hasNext()) {
				Simbolo s = iter.next();
				if (s.nivel == nivel && s.tipo == Tipo_simbolo.PARAMETRO) {
					//System.out.println("Se ha ocultado el parametro: "+s.getNombre());
					s.setVisible(false);
				}
			}
		}
	}
	
	public void eliminar_parametros_ocultos(int nivel) {
		//System.out.println("Voy a eliminar los parametros ocultos del nivel: "+nivel);
		for (int i = 0; i < M; i++) {
			Iterator<Simbolo> iter = tabla_hash[i].iterator();
			while (iter.hasNext()) {
				Simbolo s = iter.next();
				if (s.nivel == nivel && s.tipo == Tipo_simbolo.PARAMETRO && s.esVisible() == false) {
					System.out.println("Se ha eliminado el parametro oculto: " + s.getNombre());
					iter.remove();
				}
			}
		}
	}

	/*
	 * Imprime por pantalla los contendios de la tabla de simbolos
	 */
	public void imprimirTabla() {
		System.out.println("+" + new String(new char[59]).replace("\0", "-") + "+");
		System.out.println("| Tabla de sÃ­mbolos                                         |");
		System.out.println("+" + new String(new char[59]).replace("\0", "-") + "+");

		for (int i = 0; i < tabla_hash.length; i++) {
			if (!tabla_hash[i].isEmpty()) {
				Simbolo s = tabla_hash[i].getFirst();
				System.out.format("| %5d  %-50s |\n", i, s);

				if (tabla_hash[i].size() > 1) {
					for (Simbolo resto : tabla_hash[i].subList(1, tabla_hash[i].size())) {
						System.out.format("|        %-50s |\n", resto);
					}
				}
			}
		}

		System.out.println("+" + new String(new char[59]).replace("\0", "-") + "+");
	}
}