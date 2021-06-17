programa leer_vectores_basico;

booleano b[3];
caracter c[4];
entero   e[3];
entero   e2[3];
entero i,n;

accion leer_vector(ref entero a[3];ref entero a2[3]);
principio
	leer(a[1]);
	leer(a2[3]);
fin

accion leer_compo(ref entero ax);
principio
	leer(ax);
fin
Principio

	%%leer(e);
	leer(e2);
	leer_vector(e,e2);
	escribir(e,e2);%%
		
	%%leer(e);
	leer_compo(e[2]);
	escribir(e);%%

	%%Leer y escribir vectores enteros funiona
	leer(e);
	escribir(e);%%
	%Asignaciones con constantes funciona
	e[1]:=5;
	e[2]:=6;
	e[3]:=7;
	escribir(e);

	%Asignaciones con solo variables funciona
	i := 1;
	e[i] := 5;
	i := i + 1;
	e[i] := 3;
	i := i+ 1;
	e[i] := 8;
	escribir(e);
	
	%Asignaciones con expresiones dentyro funcions
	i:=1;
	e[i] := 5;
	e[i+1] := 3;
	e[i+2] := 8;
	escribir(e);
	
	%Lectura de componente a componente funciona
	leer(e[1]);
	leer(e[2]);
	leer(e[3]);
	escribir(e);

	%Lectura de vector con variable simple funciona
	i := 1;
	leer(e[i]);
	i := i + 1;
	leer(e[i]);
	i := i+ 1;
	leer(e[i]);
	escribir(e);

	%Asignacion basica funciona
	leer(e);
	i := e[3];
	escribir(i);

	%Assignacion de una componente de vector indexada con variable funciona	
	n:= 2;
	leer(e);
	i := e[n];
	escribir(i);

	%Assignacion de una componente de vector indexada con expresion funciona	
	n:= 2;
	leer(e);
	i := e[n+1];
	escribir(i);

	%Assignacion de una componente de vector indexada con expresion compleja funciona	
	n:= 1;
	leer(e);
	i := e[n+n+1];
	escribir(i);
	


	%%TODO: Esto falta de probar
	i := 0;
	n:=3;
	mq i < n
          escribir("Introduce el numero ", i+1, ": ");
          leer(e[i+1]); % sí, el acceso con el i+1 está hecho a propósito
          i := i + 1;
     	fmq
	escribir(e);%%


	


	%%leer(e[1]);
	leer(e[2]);
	leer(e[3]);
	escribir(e[1],e[2], e[3]);%%
	
Fin