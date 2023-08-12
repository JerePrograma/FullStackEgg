// Ejercicio 6
// Realizar un programa que, dado un número entero, visualice en pantalla si es par o impar.
// En caso de que el valor ingresado sea 0, se debe mostrar “el número no es par ni impar”. 

let numero = parseInt(prompt("Ingrese un número"));

if(numero === 0){
    console.log("El número no es par ni impar");
}else if (numero % 2 === 0){
    console.log("El número es par");
}else{
    console.log("El número es impar");
}