programa prueba_expresiones;

entero n, r;
booleano a,b,c;
Principio

%Casos basicos funcionan todos MIRAR
%%Con numero funcionan todos
a:= 3>2; 
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

%% Funciona con caracteres
a:= "a">"b"; 
a:= "b" > "a";
a:= "a">="b"; 
a:= "b" <= "a";
a:= "b" >= "a";
a:= "b" = "a"; 
a:= "b" <> "a"; 
a:= "b" <> "b";
a:= "a" = "a";%%

%%Funciona con booleanos
a:= true <> true;
a:= true = true;
a:= true <> false;
a:= true = false;%%

%%Da error oporque no son del mismo tipo
a:= true <> "a";
a:= 3 <> true;
a:= 4 < "c";%%


%combinaciones de terminos, expresiones simples y expresiones. Basicas Funciona correctamente
%%a := 5 + 4 > 5;
a := 5 + 4 < 5;
a := 5 + 4 = 9;
a := 5 + 4 <> 9;
a := 5 + 4 >= 10;
a := 5 + 4 >= 9;
a := 5 + 4 <= 8;%%


%% Un pcoo mas complejas funcionan correctamente
a := 5 + 4 > 5 + 3;
a := 5 + 4 < 5 +3;
a := 5 + 4 = 9 + 3;
a := 5 + 4 <> 9 + 2;
a := 5 + 4 >= 10 -6;
a := 5 + 4 >= 9 -6;
a := 5 + 4 <= 8 +56;%%


%Combinaciones mas complicadas funciona correctamente

%a := (5 * 3) mod 7 > 1;
%a:= (5 + 4) mod 7 * 5 < 20 div 2 -3;
%a:= (4) + 7 mod 5 > (((5*7))- 30) mod (4 div 2);

Fin
