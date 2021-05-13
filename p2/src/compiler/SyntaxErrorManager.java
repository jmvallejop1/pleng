package compiler;

/**
 * Clase encargada de manejar los errores sintacticos del lenguaje minileng
 * **/
public class SyntaxErrorManager {
	public static void printSyntaxError(Token nextToken, int[][] expectedTokenSequences,String[] tokenImage) {
	    StringBuilder s = new StringBuilder();
	      for (int i = 0; i < expectedTokenSequences.length; i++) {
	        for (int j = 0; j < expectedTokenSequences[i].length; j++) {
	          s.append(tokenImage[expectedTokenSequences[i][j]]).append("\t");
	        }
	      }
	      System.out.println("ERROR SINTACTICO en la linea " + nextToken.beginLine + ", en la columna  " + nextToken.beginColumn + ". Encontrado: "  + tokenImage[nextToken.kind] + ", esperado: " + s);
	}
}
