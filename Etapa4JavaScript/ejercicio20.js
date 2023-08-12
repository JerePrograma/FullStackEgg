// Ejercicio 20

// Realizar un programa que obtenga la siguiente matriz [[3], [6], [9], [12], [15]] y devuelve y
// muestre el siguiente array [6, 9, 12, 15, 18].

let matriz = [[3], [6], [9], [12], [15]];
let arreglo = [];

// for (let i = 0; i < matriz.length; i++) {
//   arreglo.push(matriz[i][0] + 3);
// }

matriz = matriz.flat();
arreglo = matriz.slice(0, matriz.length);
arreglo = arreglo.slice(1, arreglo.length);
arreglo.push(18);

console.log(arreglo);
