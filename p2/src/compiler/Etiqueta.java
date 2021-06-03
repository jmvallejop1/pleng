package compiler;

public class Etiqueta {
	static int num_etiqueta = -1;
	
	public String nueva_et() {
		num_etiqueta++;
		return "L"+ num_etiqueta;
	}
			

}
