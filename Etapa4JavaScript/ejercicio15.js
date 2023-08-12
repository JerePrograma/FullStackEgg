// Ejercicio 15
// Escribe un programa JavaScript para calcular el área y el perímetro de un objeto Círculo
// con la propiedad radio. Nota: Cree dos métodos para calcular el área y el perímetro. El
// radio del círculo lo proporcionará el usuario
function calcularArea(radio) {
  return Math.PI * Math.pow(radio, 2);
}
function calcularPerimetro(radio) {
  return 2 * Math.PI * radio;
}
function Circulo(radio) {
  this.area = calcularArea(radio);
  this.calcularArea = calcularArea;
  this.perimetro = calcularPerimetro(radio);
  this.calcularPerimetro = calcularPerimetro;
}
let circu = new Circulo(parseInt(prompt("Ingresá el radio del círculo")));

// class Circulo{
//     constructor(radio){
//         this.radio = radio;
//         this.area = calcularArea(radio);
//         this.calcularArea = calcularArea;
//         this.perimetro = calcularPerimetro(radio);
//         this.calcularPerimetro = calcularPerimetro;
//     }

// }
