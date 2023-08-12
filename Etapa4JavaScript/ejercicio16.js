// Ejercicio 16
// Realizar un programa que rellene dos vectores al mismo tiempo, con 5 valores aleatorios
// y los muestre por pantalla.

function llenarVectores(vec1, vec2) {
  for (let index = 0; index < 5; index++) {
    vec1.push(Math.random() * 10);
    vec2.push(Math.random() * 10);
  }
}

let vec1 = [];
let vec2 = [];
console.log(Math.random());
llenarVectores(vec1, vec2);

vec1.forEach((element) => {
  console.log(element);
});

vec2.forEach((element) => {
  console.log(element);
});
