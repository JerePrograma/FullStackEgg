// Ejercicio 7
// Escriba un programa en el cual se ingrese un valor límite positivo, y a continuación
// solicite números al usuario hasta que la suma de los números introducidos supere el
// límite inicial.

let limite = parseInt(prompt("Ingrese un límite positivo"));
let numero = 0;
while (numero <= limite) {
  numero += parseInt(prompt("Ingrese un número"));
}

console.log(`${numero} superó el límite ${limite}`)
