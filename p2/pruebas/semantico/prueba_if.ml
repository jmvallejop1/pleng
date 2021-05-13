programa prueba_if;

entero n, r;
booleano a,b,c;
Principio

%Funcionamiento basico funciona correctamente
si a ent
	a := TRUE;
Fsi

%Pasamos variable que no es booleana ERROR

si n ent
	a:= true;
Fsi
%Siempre se va a ejecutar el codigo, constante true
si 3 < 4 ent
	a:= true;
Fsi

%Siempre se va a ejecutar el codigo, constante false
si 3 > 4 ent
	a:= true;
Fsi
Fin