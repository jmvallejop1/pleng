programa fibbonaci;

entero n, r;
booleano a,b;

%-----------------------------------------------------------
accion dato (ref entero dato;val entero d);
%-----------------------------------------------------------
booleano correcto;
Principio
	correcto := TRUE;
Fin

%-----------------------------------------------------------
accion dato2 (ref booleano dat;val booleano da);
%-----------------------------------------------------------
booleano correcto;
Principio
	correcto := TRUE;
Fin

Principio

%Correctos
dato2(a,b);
dato2(a,FALSE);
%error parametro pasado por vaor y tiene que ser por referencia
dato2(TRUE,TRUE);

%error numero incorrecto de parametros
dato2(a);
dato2(a,b,false);

Fin