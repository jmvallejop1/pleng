programa leer_vectores_basico;
entero i,n;
caracter a,b;

accion leer_entero(ref entero v);
Principio
	v:=3;
Fin

accion escribir_entero(val entero v2);
principio
	escribir(v2);
fin

accion leer_caracter(ref caracter v3);
Principio
	v3:="x";
Fin

accion escribir_caracter(val caracter v4);
principio
	escribir(v4);
fin

Principio
	%Detecta el error semantico, no se puede pasar una contante como parametro por referencia
	%leer_entero(1);

	%Funciona correctamente
	leer_entero(i);
	escribir("Valor de i:", i);

	%i:=2;
	%escribir_entero(i);
	
	%escribir constante funciona correctamente
	%escribir_entero(3);

	%Numero incorrecto de parametros, funciona correctamente
	%escribir_entero(2,2);
	
	%--------------CARACTERES------------------
	%Detecta el error semantico, no se puede pasar una contante como parametro por referencia
	%leer_caracter("a");

	%Funciona correctamente
	%leer_caracter(a);
	%escribir("Valor de a:", a);
	
	%Funciona correctamente
	%a:="r";
	%escribir_caracter(a);
	
	%escribir constante funciona correctamente
	%escribir_caracter("a");

	%Numero incorrecto de parametros, funciona correctamente
	%escribir_caracter("a",2);
	
	%Parametro de tipo incorrecto funciona correctamente
	%escribir_caracter(i);

Fin