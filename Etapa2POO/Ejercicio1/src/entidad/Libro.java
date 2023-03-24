package entidad;

import java.util.Scanner;

/*Crear una clase llamada Libro que contenga los siguientes atributos: ISBN, Título, Autor, Número de páginas,
y un constructor con todos los atributos pasados por parámetro y un constructor vacío. 
Crear un método para cargar un libro pidiendo los datos al usuario y luego 
informar mediante otro método el número de ISBN, el título, el autor del libro y el número de páginas.*/
public class Libro {

    public  int ISBN;
    public String titulo;
    public String autor;
    public int paginas;

    public Libro() {
    }

    public Libro(int ISBN, String titulo, String autor, int paginas) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public static void cargarLibro(Libro libro) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el ISBN del libro");
        libro.setISBN(leer.nextInt());
        System.out.println("Ingrese el título");
        libro.setTitulo(leer.next());
        System.out.println("Ingrese el autor");
        libro.setAutor(leer.next());
        System.out.println("Ingrese el número de páginas");
        libro.setPaginas(leer.nextInt());
    }

    public static void mostrarLibro(Libro libro) {
        System.out.println("El ISBN del libro es: " + libro.getISBN());
        System.out.println("El título es: " + libro.getTitulo());
        System.out.println("El autor es: " + libro.getAutor());
        System.out.println("El número de páginas es: " + libro.getPaginas());
    }
}