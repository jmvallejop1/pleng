programa prueba_expresiones;

entero n, r;
booleano a,b,c;
Principio

%correcto, expresiones con constantes
%%n := 2;
n := 2 * 3;
n := 6 mod 4;
n := 6 div 3;
a := TRUE and TRUE;
a := TRUE and FALSE;
n:=3;
n := 3*3*3;
n:= 3 mod 7 mod 2;
n:= 12 div 2 div 2;
a := TRUE and TRUE and FALSE;%%
%n := 2 + 2 + 2;

%pruebas de prioridad de operaciones

%n:= 2+3*4;
%n:= 2-3*4;
%n:= 2 + 3* 4 * 2;
%n:= 2 -3*4 div 6;
%a := TRUE ANDTRUE OR FALSE;
%a := TRUE and FALSE or FALSE;
a := TRUE AND TRUE;
n:= 3*3;


%incorrecto
%n := TRUE;
%a := 3;
%a := 3 +3;
%a := n;
%n := a;
%n := a +3;

%mirar estos casos, hay dudas porque son variables
%n:= n * 2;
%a := b and c;

Fin