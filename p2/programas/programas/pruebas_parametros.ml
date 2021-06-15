programa leer_vectores_basico;
entero i,n;

accion leer_entero(ref entero v);
Principio
	v:=3;
Fin

accion escribir_entero(val entero v2);
principio
	escribir(v2);
fin
Principio
	%Detecta el error semantico, no se puede pasar una contante como parametro por referencia
	%leer_entero(1);
	%Funciona correctamente
	%leer_entero(i);
	%i:=2;
	%escribir_entero(i);
	%escribir("Valor de i:", i);
	escribir_entero(2,2);

Fin