// Ejercicio 18
// A partir del siguiente array: var valores = [true, 5, false, "hola", "adios", 2]:
// a) Determinar cual de los dos elementos de texto es mayor
// b) Utilizando exclusivamente los dos valores booleanos del array, determinar los
// operadores necesarios para obtener un resultado true y otro resultado false
// c) Determinar el resultado de las cinco operaciones matemáticas realizadas con los
// dos elementos numéricos
var valores = [true, 5, false, "hola", "adios", 2];
let palabraLarga = "";

function textos(arreglo) {
  let suma = 0;
  let resta = 0;
  let multi = 1;
  arreglo.forEach((element) => {
    if (typeof element == "string") {
      if (element.length > palabraLarga.length) {
        palabraLarga = element;
      }
    }
    // if (typeof element == "boolean") {
    //   if (element) {
    //     console.log(element);
    //   } else {
    //     console.log(element);
    //   }
    // }
    if (typeof element == "number") {
      suma += element;
      resta -= element;
      multi *= element;
    }
  });
  let div = valores[1] / valores[5];
  let modulo = valores[1] % valores[5];
  console.log(suma, resta, multi, div, modulo);
}

let falso = valores[0] && valores[2];
let verdadero = valores[0] || valores[2];
console.log(verdadero, falso);

textos(valores);
console.log(palabraLarga);
