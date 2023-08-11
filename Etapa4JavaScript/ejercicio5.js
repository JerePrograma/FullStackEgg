// Ejercicio 5
// Construir un programa que simule un menú de opciones para realizar las cuatro
// operaciones aritméticas básicas (suma, resta, multiplicación y división) con dos valores
// numéricos enteros. El usuario, además, debe especificar la operación con el primer
// carácter de la operación que desea realizar: ‘S' o ‘s’ para la suma, ‘R’ o ‘r’ para la resta, ‘M’
// o ‘m’ para la multiplicación y ‘D’ o ‘d’ para la división.

let operacion = prompt("Ingrese la operación que desea realizar");

let num1 = parseInt(prompt("Ingrese el primer número"));
let num2 = parseInt(prompt("Ingrese el segundo número"));
let operaciones;

switch (operacion) {
  case ("S", "s"):
    operaciones = num1 + num2;
    break;
  case ("R", "r"):
    operaciones = num1 - num2;
    break;
  case ("M", "m"):
    operaciones = num1 * num2;
    break;
  case ("D", "d"):
    operaciones = num1 / num2;
    break;
  default:
    console.log("No se reconoce la operación a realizar");
}

console.log(`La operación da: ${operaciones}`);
