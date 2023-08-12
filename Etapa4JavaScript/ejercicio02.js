//Ejercicio 2
// Conocido el número en matemática PI π, pedir al usuario que ingrese el valor del radio
// de una circunferencia y calcular y mostrar por pantalla el área y perímetro. Recuerde que
// para calcular el área y el perímetro se utilizan las siguientes fórmulas:
// area = PI * radio2
// perimetro = 2 * PI * radio

const PI = Math.PI;

let radio = prompt("Ingrese el radio de la circunferencia");

let area = PI * Math.pow(radio,2);

let perimetro = 2 * PI * radio;

console.log(`El area de la circunferencia es de ${area}`);

console.log(`El perimetro de la circunferencia es de ${perimetro}`);