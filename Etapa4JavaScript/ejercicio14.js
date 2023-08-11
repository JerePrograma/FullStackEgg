// Ejercicio 14
// Crear un objeto libro que contenga las siguientes propiedades: ISBN, Título, Autor,
// Número de páginas. Crear un método para cargar un libro pidiendo los datos al usuario
// y luego informar mediante otro método el número de ISBN, el título, el autor del libro y el
// numero de páginas.

function Libro(ISBN,titulo, autor, numeroDePaginas) {
    this.ISBN = prompt("Ingresa el ISBN");
    this.titulo = prompt("Ingresa el título");
    this.autor = prompt("Ingresa el autor");
    this.numeroDePaginas = parseInt(prompt("Ingresa la cantidad de páginas"));
};

console.log(new Libro());