programa prueba_expresiones;

entero n, r;
booleano a,b,c;
Principio

%Casos basicos funcionan todos
%%a:= 3>2; 
a:= 2 >3;
a:= 3>=2;
a:= 3>=3;
a:= 2>=3;
a:= 3<=3;
a:= 3<=2;
a:= 2<=3;
a:= 3<>2;
a:= 3<> 3;
a:= 3=2;
a:= 3=3;%%



%combinaciones de terminos, expresiones simples y expresiones. Basicas
%%
a := 5 + 4 > 5;
a := 5 + 4 < 5;
a := 5 + 4 = 9;
a := 5 + 4 <> 9;
a := 5 + 4 >= 10;
a := 5 + 4 >= 9;
a := 5 + 4 <= 8;
%%

%%
a := 5 + 4 > 5 + 3;
a := 5 + 4 < 5 +3;
a := 5 + 4 = 9 + 3;
a := 5 + 4 <> 9 + 2;
a := 5 + 4 >= 10 -6;
a := 5 + 4 >= 9 -6;
a := 5 + 4 <= 8 +56;
%%

%Combinaciones mas complicadas

%a := (5 * 3) mod 7 > 1;
%a:= (5 + 4) mod 7 * 5 < 20 div 2 -3;
%a:= (4) + 7 mod 5 > (((5*7))- 30) mod (4 div 2);

Fin
