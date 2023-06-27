package main;
//Ha llegado el momento de poner de prueba tus conocimientos. Para te vamos a contar que te
//ha contratado “La Tercera Seguros”, una empresa aseguradora que brinda a sus clientes

import entidad.Poliza;
import servicio.PolizaServicio;

//coberturas integrales para vehículos.
//Luego de un pequeño relevamiento, te vamos a pasar en limpio los requerimientos del sistema
//que quiere realizar la empresa.
//a. Gestión Integral de clientes. En este módulo vamos a registrar la información personal de
//cada cliente que posea pólizas en nuestra empresa. Nombre y apellido, documento, mail,
//domicilio, teléfono.
//b. Gestión de vehículos. Se registra la información de cada vehículo asegurado. Marca,
//modelo, año, número de motor, chasis, color, tipo (camioneta, sedán, etc.).
//c. Gestión de Pólizas: Se registrará una póliza, donde se guardará los datos tanto de un
//vehículo, como los datos de un solo cliente. Los datos incluidos en ella son: número de
//póliza, fecha de inicio y fin de la póliza, cantidad de cuotas, forma de pago, monto total
//asegurado, incluye granizo, monto máximo granizo, tipo de cobertura (total, contra
//terceros, etc.). Nota: prestar atención al principio de este enunciado y pensar en las
//relaciones entre clases. Recuerden que pueden ser de uno a uno, de uno a muchos, de
//muchos a uno o de muchos a muchos.
//d. Gestión de cuotas: Se registrarán y podrán consultar las cuotas generadas en cada póliza.
//Esas cuotas van a contener la siguiente información: número de cuota, monto total de la
//cuota, si está o no pagada, fecha de vencimiento, forma de pago (efectivo, transferencia,
//etc.).
//Debemos realizar el diagrama de clases completo, teniendo en cuenta todos los
//requerimientos arriba
public class Main {

    public static void main(String[] args) {
        PolizaServicio ps = new PolizaServicio();
        Poliza poliza = ps.contratarSeguro();
    }
}
