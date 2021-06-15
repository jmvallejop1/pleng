programa leer_vectores_basico;
entero   e[3];
entero i,n;

%%accion leer_vector(ref entero v[3]);
entero i,j;
Principio
	j:=1;	
	v[1]:=1;
	v[2]:=2;
	v[3]:=5;

Fin%%

%%accion leer_componente_vector(ref entero v2);
Principio
	v2 := 3;
Fin%%
Principio
	%Funcion basica por referencia funciona 
	%leer_vector(e);
	%%Funciona
	leer(e);
	leer_componente_vector(e[2]);
	escribir(e);
	%%
	%e[2]:=3;
	%escribir(e);
	%Mirar mañana, igual esta todo duplicado lo de mUl y SBT
	e[3]:=7;
	%n := e[2];
	%escribir(n); Funciona
	%escribir(e[2]); Funciona
	escribir(e[2+1]);


Fin