programa asignar;

entero n,r,c;
entero n2[3];

%-----------------------------------------------------------
accion cambiar_de_linea ;
%-----------------------------------------------------------
Principio
  escribir (entacar (13), entacar (10));
Fin


Principio 
	n:=3;

	r:=2;
	c:=-3;
	c:= c + 1;
	%r:= r +1;
	escribir(r,c);
	cambiar_de_linea;
	escribir(n+1-r, 7-r*2,c);
	cambiar_de_linea;

	n2[1]:= 2;
	n2[r]:= 5;
	n2[r+1] := 8;
	escribir(n2);
	cambiar_de_linea;
	n:=n2[2+1];
	escribir("valor de n:", n);
	cambiar_de_linea;
	n:=n2[2];
	escribir(n);
	cambiar_de_linea;

	n:=n2[r+1];
	escribir(n);
	cambiar_de_linea;

	%TODO: mirar si se puede hacer n2[n2[1]]

	
	
Fin