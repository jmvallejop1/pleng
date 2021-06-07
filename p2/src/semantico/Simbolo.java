/*********************************************************************************
 * Clase que define los simbolos que conforman los programas MiniLeng
 *
 * Fichero:    Simbolo.java
 * Fecha:      1/4/2021
 * Version:    v2.0
 * Asignatura: Procesadores de Lenguajes, curso 2020-2021
 **********************************************************************************/

package semantico;

import java.util.ArrayList;

public class Simbolo {

	// Representa el tipo de simbolo
	public enum Tipo_simbolo {
		PROGRAMA, VARIABLE, ACCION, PARAMETRO
	};

	// Representa el tipo de variable
	public enum Tipo_variable {
		DESCONOCIDO, ENTERO, BOOLEANO, CHAR, CADENA, VECENT, VECCHAR,VECBOOL
	};

	// Representa la clase de los parámetros en las acciones
	public enum Clase_parametro {
		VAL, REF
	};

	/////////////////////////////
	// Atributos del simbolo //
	/////////////////////////////

	String nombre;
	Integer nivel; // Nivel en el que se ha declarado el simbolo (primer nivel = 0)
	Integer dir; // Direccion del simbolo
	boolean visible;

	Tipo_simbolo tipo;
	Tipo_variable variable;
	Clase_parametro parametro;
	String etiqueta;

	ArrayList<Simbolo> lista_parametros; // Lista de simbolos que representan los parametros de una accion

	Boolean vector = false; // Vale true si el simbolo es una variable o parametro vector
	Integer longitud; // Longitud para los vectores

	// Boolean inicializado = false; // Vale true si el simbolo es una variable o parametro y ha sido inicializado


	// Getters y setters
	public String getEtiqueta() {
		return etiqueta;
	}
	
	public void setEtiqueta(String e) {
		this.etiqueta = e;
	}
	
	public boolean esVisible() {
		return visible;
	}
	
	public void setVisible(boolean v) {
		this.visible = v;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Tipo_simbolo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo_simbolo tipo) {
		this.tipo = tipo;
	}

	public Tipo_variable getVariable() {
		return variable;
	}

	public void setVariable(Tipo_variable variable) {
		this.variable = variable;
	}

	public Clase_parametro getParametro() {
		return parametro;
	}

	public void setParametro(Clase_parametro parametro) {
		this.parametro = parametro;
	}

	public ArrayList<Simbolo> getListaParametros() {
		return lista_parametros;
	}

	public void setListaParametros(ArrayList<Simbolo> lista_parametros) {
		this.lista_parametros = lista_parametros;
	}

	public void addParametro(Simbolo parametro) {
		this.lista_parametros.add(parametro);
	}

	public int getDir() {
		return dir;
	}

	public void setDir(Integer dir) {
		this.dir = dir;
	}

	public void setVector(Boolean vector) {
		this.vector = vector;
	}

	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}

	public Integer getLongitud() {
		return longitud;
	}

	/*
	public void setInicializado(Boolean inicializado) {
		this.inicializado = inicializado;
	}

	public Boolean INICIALIZADO() {
		return inicializado;
	}
	*/


	// Metodos para construir los tipos de imbolos

	// Configura los campos del simbolo correspondientes a un programa
	public void introducir_programa(String nombre, int nivel, int dir) {
		this.nombre = nombre;
		this.tipo = Tipo_simbolo.PROGRAMA;
		this.nivel = nivel;
		this.visible = true;
	}

	// Configura los campos del simbolo correspondiente a una variable
	public void introducir_variable(String nombre, Tipo_variable tipo_var, int nivel, int dir) {
		this.nombre = nombre;
		this.tipo = Tipo_simbolo.VARIABLE;
		this.variable = tipo_var;
		this.nivel = nivel;
		this.dir = dir;
		this.visible = true;
	}

	// Configura los campos del simbolo correspondiente a una accion
	public void introducir_accion(String nombre, int nivel, int dir, String s) {
		this.nombre = nombre;
		this.tipo = Tipo_simbolo.ACCION;
		this.lista_parametros = new ArrayList<Simbolo>();
		this.nivel = nivel;
		this.dir = dir;
		this.visible = true;
		this.etiqueta = s;
	}

	// Configura los campos del simbolo correspondiente a un parametro
	public void introducir_parametro(String nombre, Tipo_variable tipo_var, Clase_parametro clase_param, int nivel,
			int dir) {
		this.nombre = nombre;
		this.tipo = Tipo_simbolo.PARAMETRO;
		this.variable = tipo_var;
		this.parametro = clase_param;
		this.nivel = nivel;
		this.dir = dir;
		this.visible = true;
	}

	// Configura los campos del simbolo correspondiente a un vector
	public void introducir_variable_vector(String nombre, Tipo_variable tipo_var, int longitud, int nivel, int dir) {
		this.nombre = nombre;
		this.tipo = Tipo_simbolo.VARIABLE;
		this.variable = tipo_var;
		this.vector = true;
		this.longitud = longitud;
		this.nivel = nivel;
		this.dir = dir;
		this.visible =true;
	}

	public void introducir_parametro_vector(String nombre, Tipo_variable tipo_var, Clase_parametro clase_param,
			int longitud, int nivel, int dir) {
		this.nombre = nombre;
		this.tipo = Tipo_simbolo.PARAMETRO;
		this.variable = tipo_var;
		this.parametro = clase_param;
		this.vector = true;
		this.longitud = longitud;
		this.nivel = nivel;
		this.dir = dir;
		this.visible = true;
	}

	// Comprobadores del tipo de simbolo

	public Boolean ES_PROGRAMA() {
		return tipo == Tipo_simbolo.PROGRAMA;
	}

	public Boolean ES_VARIABLE() {
		return tipo == Tipo_simbolo.VARIABLE;
	}

	public Boolean ES_ACCION() {
		return tipo == Tipo_simbolo.ACCION;
	}

	public Boolean ES_PARAMETRO() {
		return tipo == Tipo_simbolo.PARAMETRO;
	}

	public Boolean ES_VALOR() {
		return (tipo == Tipo_simbolo.PARAMETRO) && (parametro == Clase_parametro.VAL);
	}

	public Boolean ES_REFERENCIA() {
		return (tipo == Tipo_simbolo.PARAMETRO) && (parametro == Clase_parametro.REF);
	}

	public Boolean ES_VECTOR() {
		return vector;
	}

	public Boolean es_asignable() {
		return this.ES_VARIABLE() || this.ES_REFERENCIA();
	}
	
	public int get_tamanyo() {
		int bytes;
		switch (this.variable) {
			case ENTERO:
				bytes = 2;
				break;
			
			case CHAR:
				bytes =1;
				break;
			
			case BOOLEANO:
				bytes = 1;
				break;
			case VECENT:
				bytes = this.longitud * 2;
				break;
			case VECCHAR:
				bytes = this.longitud * 1;
				break;
			case VECBOOL:
				bytes = this.longitud * 1;
				break;
			default:
				bytes = 1;
			break;
		};
		return bytes;
	}
	
	public int get_tamanyo_componente() {
		int bytes;
		switch (this.variable) {
			case VECENT:
				bytes =  2;
				break;
			case VECCHAR:
				bytes =  1;
				break;
			case VECBOOL:
				bytes =  1;
				break;
			default:
				bytes = 1;
			break;
		};
		return bytes;
	}
	
	public Tipo_variable getTipoComponente() {
		if(this.vector) {
			switch (this.variable) {
				case VECENT:
					return Tipo_variable.ENTERO;
				case VECCHAR:
					return Tipo_variable.CHAR;
				case VECBOOL:
					return Tipo_variable.BOOLEANO;
				default:
					return Tipo_variable.DESCONOCIDO;
			}
		}else {
			return Tipo_variable.DESCONOCIDO;
		}
	}
	
	public int calcularDesplazamientoDireccion(int desp) {
		if(this.vector) {
			switch (this.variable) {
				case VECENT:
					return this.dir + desp * 2;
				case VECCHAR:
					return this.dir + desp;
				case VECBOOL:
					return this.dir + desp;
				default:
					return this.dir;
			}
		}else {
			return this.dir;
		}
	}

	// Funcion toString()

	public String getVariableString() {
		String res = "";
		switch (variable) {
		case DESCONOCIDO:
			res = "DESCONOCIDO";
			break;
		case ENTERO:
			res = "ENTERO";
			break;
		case BOOLEANO:
			res = "BOOLEANO";
			break;
		case CHAR:
			res = "CHAR";
			break;
		case CADENA:
			res = "CADENA";
			break;
		}
		return res;
	}

	public String getParametroString() {
		String res = "";
		switch (parametro) {
		case VAL:
			res = "VAL";
			break;
		case REF:
			res = "REF";
			break;
		}
		return res;
	}

	@Override
	public String toString() {
		String res;

		String nombre = this.nombre;
		if (vector) {
			nombre += "[" + longitud + "]";
		}

		switch (tipo) {
		case PROGRAMA:
			res = String.format("%-25s %s [%d, -]", "PROGRAMA:", nombre, nivel);
			break;

		case VARIABLE:
			res = String.format("%-25s %s [%d, %d]", "VARIABLE " + getVariableString() + ":", nombre, nivel, dir);
			break;

		case ACCION:
			String signatura = nombre + "(";
			boolean primero = true;
			for (Simbolo par : lista_parametros) {
				if (primero) {
					primero = false;
				} else {
					signatura += ", ";
				}
				signatura += par.nombre;
			}
			signatura += ")";
			res = String.format("%-25s %s [%d, %d]", "ACCION:", signatura, nivel, dir);
			break;

		case PARAMETRO:
			res = String.format("%-25s %s [%d, %d]",
					"PARAMETRO " + getParametroString() + " " + getVariableString() + ":", nombre, nivel, dir);
			break;

		default:
			res = String.format("%-25s %s [%d, %d]", "SIMBOLO DESCONOCIDO", nombre, nivel, dir);
			break;
		}

		return res;
	}
}
