// Ejercicio 9
// Realizar un programa que pida una frase y el programa deberá mostrar la frase con un
// espacio entre cada letra. La frase se mostrara así: H o l a. Nota: recordar el
// funcionamiento de la función Substring().

let palabra = prompt("Ingresá una palabra");

let letras = palabra.split("");

let nuevoArray = "";

for (let i = 0; i < letras.length; i++) {
  nuevoArray += letras[i] + " ";
}

console.log(nuevoArray);
