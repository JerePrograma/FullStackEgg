// Ejercicio 21
// Escribir un programa para obtener un array de las propiedades de un objeto Persona.
// Las propiedades son nombre, edad, sexo ('H' hombre, 'M' mujer, 'O' otro), peso y altura.

let Persona = {
  nombre: "Jere",
  edad: 28,
  sexo: "H",
  peso: 100,
  altura: 1.68,
};
let datos = [
  Persona.nombre,
  Persona.edad,
  Persona.sexo,
  Persona.peso,
  Persona.altura,
];

console.log(datos);
console.log(Persona);
