// Ejercicio 12
// Escribir una función flecha de JavaScript que reciba un argumento y retorne el tipo de
// dato.

let argumento = prompt("Ingresa algo");

let func = (parametro) => typeof parametro;

console.log(func(argumento));