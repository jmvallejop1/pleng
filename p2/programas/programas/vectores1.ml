% Este programa lee 5 valores del usuario y los almacena en un
% vector. Después, escribe los elementos del array. 

programa muestra_valores;

  entero valores[5], i;

principio

  escribir("Introduce 5 valores: ");

  i := 0;
  mq i < 5 
    leer(valores[i+1]); % si, el acceso con el i+1 esta hecho a proposito
    i := i + 1;
  fmq

  escribir("Mostrando los valores: ");

  % Alternativa a esta estructura iterativa y que tiene que
  % funcionar correctamente:
  % escribir(valores);
  i := 0;
  mq i < 5 
    escribir(valores[i+1]);
    i := i + 1;
  fmq

fin