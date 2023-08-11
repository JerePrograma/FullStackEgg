// Ejercicio 13
// Crear un objeto persona, con las propiedades nombre, edad, sexo ('H' hombre, 'M' mujer,
// 'O' otro), peso y altura. A continuación, muestre las propiedades del objeto JavaScript.

function Persona (nombre,edad,sexo,peso,altura){
    this.nombre = nombre;
    this.edad = edad;
    this.sexo = sexo;
    this.peso = peso;
    this.altura = altura;
}

let persona = new Persona("Jeremias",28,'H',100,1.68);

console.log(persona);