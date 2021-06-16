programa leer_vectores_basico;
entero   e[3];
entero i,n;

%%accion asignar_vector(ref entero v[3]);
entero i,j;
Principio	
	v[1]:=1;
	v[2]:=2;
	v[3]:=5;

Fin%%

%%accion leer_vector(ref entero v2[3]);
Principio
	leer(v2);
Fin%%

accion asignar_componente_vector(ref entero v3);
Principio
	v3 := 8;
Fin

Principio
	%Funcion asignacion vector en funcion por referncia funciona
	%asignar_vector(e);
	%escribir(e);
	
	%%Funciona Lectura de vector entero por referencia
	leer_vector(e);
	escribir(e);%%

	%%Funciona paso de componente por referencia y con contante en el indice
	leer(e);
	asignar_componente_vector(e[3]);
	escribir(e);%%

	i:= 2;
	leer(e);
	asignar_componente_vector(e[i+1]);
	escribir(e);

	%e[2]:=3;
	%escribir(e);
	%Mirar mañana, igual esta todo duplicado lo de mUl y SBT
	%e[3]:=7;
	%n := e[2];
	%escribir(n); Funciona
	%escribir(e[2]); Funciona
	%escribir(e[2+1]);


Fin