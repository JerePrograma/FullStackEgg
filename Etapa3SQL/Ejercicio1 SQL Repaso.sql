#1. Obtener los datos completos de los empleados.
SELECT * FROM empleados;
#2. Obtener los datos completos de los departamentos.
SELECT * FROM departamentos;
#3. Listar el nombre de los departamentos.
SELECT distinct nombre_depto AS nombre_departamentos from departamentos;
#4. Obtener el nombre y salario de todos los empleados.
SELECT nombre, sal_emp as salario FROM empleados;
#5. Listar todas las comisiones.
select nombre, comision_emp from empleados;
#6. Obtener los datos de los empleados cuyo cargo sea ‘Secretaria’.
SELECT * FROM empleados where cargo_emp = 'secretaria';
#7. Obtener los datos de los empleados vendedores, ordenados por nombre
#alfabéticamente.
SELECT * FROM empleados where cargo_emp = "vendedor" order by nombre;
#8. Obtener el nombre y cargo de todos los empleados, ordenados por salario de menor a
#mayor.
SELECT nombre, cargo_emp FROM empleados order by sal_emp;
#9. Obtener el nombre de o de los jefes que tengan su departamento situado en la ciudad
#de “Ciudad Real”
SELECT nombre_jefe_depto FROM departamentos where ciudad = "Ciudad Real";
#10. Elabore un listado donde para cada fila, figure el alias ‘Nombre’ y ‘Cargo’ para las
#respectivas tablas de empleados.
SELECT nombre as "Nombre", cargo_emp as "Cargo" from empleados;
#11. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado
#por comisión de menor a mayor.
SELECT sal_emp, comision_emp FROM empleados where id_depto = 2000 order by comision_emp asc;
#12. Obtener el valor total a pagar a cada empleado del departamento 3000, que resulta
#de: sumar el salario y la comisión, más una bonificación de 500. Mostrar el nombre del
#empleado y el total a pagar, en orden alfabético.
SELECT nombre, (sal_emp + comision_emp +500) as Total_a_pagar from empleados where id_depto = 3000 order by nombre asc;
#13. Muestra los empleados cuyo nombre empiece con la letra J.
SELECT * FROM empleados where nombre like "J%";
#14. Listar el salario, la comisión, el salario total (salario + comisión) y nombre, de aquellos
#empleados que tienen comisión superior a 1000.
SELECT sal_emp, comision_emp, (sal_emp+comision_emp) as salario_total, nombre FROM empleados where comision_emp > 1000;
#15. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen
#comisión.
SELECT sal_emp, comision_emp, (sal_emp+comision_emp) as salario_total, nombre FROM empleados where NOT comision_emp;
#16. Obtener la lista de los empleados que ganan una comisión superior a su sueldo.
SELECT * FROM empleados where comision_emp > sal_emp;
#17. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo.
SELECT * FROM empleados where comision_emp <= (sal_emp * 0.3);
#18. Hallar los empleados cuyo nombre no contiene la cadena “MA”
SELECT * FROM empleados where nombre NOT LIKE "%ma%";
#19. Obtener los nombres de los departamentos que sean “Ventas”, “Investigación” o
#‘Mantenimiento.
SELECT * FROM departamentos where nombre_depto in("Ventas","Investigacion", "Mantenimiento");
#20. Ahora obtener el contrario, los nombres de los departamentos que no sean “Ventas” ni
#“Investigación” ni ‘Mantenimiento.
SELECT * FROM departamentos where nombre_depto not in("Ventas","Investigacion", "Mantenimiento");
#21. Mostrar el salario más alto de la empresa.
select MAX(sal_emp) FROM empleados;
#22. Mostrar el nombre del último empleado de la lista por orden alfabético.
select nombre from empleados order by nombre desc limit 1;
#23. Hallar el salario más alto, el más bajo y la diferencia entre ellos.
SELECT MAX(sal_emp) as salario_mas_alto,
MIN(sal_emp) as salario_mas_bajo, 
(MAX(sal_emp)-MIN(sal_emp)) as diferencia 
FROM empleados;
#24. Hallar el salario promedio por departamento.
SELECT ROUND(AVG(sal_emp)) as salario_promedio_depto 
FROM empleados 
group by id_depto;
#Consultas con Having
#25. Hallar los departamentos que tienen más de tres empleados. Mostrar el número de
#empleados de esos departamentos.
SELECT id_depto FROM empleados group by id_depto having COUNT(id_emp)>3;
#Consulta con JOIN
select d.nombre_depto, count(e.id_emp) as numero_empleado
from departamentos d
join empleados e on d.id_depto = e.id_depto
group by d.nombre_depto
having count(e.id_emp) > 3;
#Consulta con Subconsulta
#26. Hallar los departamentos que no tienen empleados
SELECT id_depto FROM empleados group by id_depto having COUNT(id_emp) = 0;
#27. Mostrar la lista de empleados, con su respectivo departamento y el jefe de cada departamento.
SELECT nombre, nombre_depto, nombre_jefe_depto 
FROM empleados e
JOIN departamentos d
where d.id_depto = e.id_depto;
#28. Mostrar la lista de los empleados cuyo salario es mayor o igual que el promedio de la
#empresa. Ordenarlo por departamento.
SELECT * FROM empleados 
where sal_emp >= 
(SELECT avg(sal_emp) FROM empleados) 
order by id_depto;