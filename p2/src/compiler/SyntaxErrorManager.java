package compiler;

/**
 * Clase encargada de manejar los errores sintacticos del lenguaje minileng
 * **/
public class SyntaxErrorManager {
	public static void printSyntaxError(Token nextToken, int[][] expectedTokenSequences,String[] tokenImage, String informer) {
	    StringBuilder s = new StringBuilder();
	    if (expectedTokenSequences.length > 4) {
	      for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < expectedTokenSequences[i].length; j++) {
	          	s.append(tokenImage[expectedTokenSequences[i][j]]).append("\t");
	        }
	      }
	    }
	    else {
	      for (int i = 0; i < expectedTokenSequences.length; i++) {
	        for (int j = 0; j < expectedTokenSequences[i].length; j++) {
	          	s.append(tokenImage[expectedTokenSequences[i][j]]).append("\t");
	        }
	      }
	    }
	    System.out.println("ERROR SINTACTICO debido a " + informer + " en la linea " + nextToken.beginLine + ", en la columna  " + nextToken.beginColumn + ". Encontrado: "  + tokenImage[nextToken.kind] + ", esperado: " + s);
	}
}

