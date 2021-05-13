package compiler;

public class LexicalErrorManager{
	static void printLexicalError(int linea,int columna, char c) {
		System.out.println("ERROR LEXICO linea " + linea+ " columna " +columna + " caracter desconocido: " + c );
	}
	
}
