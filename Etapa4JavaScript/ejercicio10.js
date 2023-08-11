// Ejercicio 10
// Escribir una función flecha que reciba una palabra y la devuelva al revés.

let palabra = prompt("Ingrese una palabra");
let func = function (palabra) {
  let palabraReves = "";
  for (let i = palabra.length - 1; i >= 0; i--) {
    palabraReves += palabra[i];
  }
  return palabraReves;
};
let palabraReves = func(palabra);
console.log(palabraReves);
