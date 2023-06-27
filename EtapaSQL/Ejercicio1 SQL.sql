-- 1. Obtener los datos completos de los empleados.
SELECT * FROM personal.empleados;

-- 2. Obtener los datos completos de los departamentos.
SELECT * FROM personal.departamentos;

-- 3. Listar el nombre de los departamentos.
SELECT nombre_depto FROM personal.departamentos;

-- 4. Obtener el nombre y salario de todos los empleados.
SELECT nombre, sal_emp FROM personal.empleados;

-- 5. Listar todas las comisiones.
SELECT comision FROM personal.empleados;

-- 6. Obtener los datos de los empleados cuyo cargo sea ‘Secretaria’.
SELECT * FROM personal.empleados WHERE cargo = 'Secretaria';

-- 7. Obtener los datos de los empleados vendedores, ordenados por nombre alfabéticamente.
SELECT * FROM personal.empleados WHERE cargo = 'Vendedor' ORDER BY nombre;

-- 8. Obtener el nombre y cargo de todos los empleados, ordenados por salario de menor a mayor.
SELECT nombre, cargo FROM personal.empleados ORDER BY sal_emp;

-- 9. Obtener el nombre de o de los jefes que tengan su departamento situado en la ciudad de “Ciudad Real”
SELECT nombre_jefe_depto FROM personal.departamentos WHERE ciudad = 'Ciudad Real';

-- 10. Elabore un listado donde para cada fila, figure el alias ‘Nombre’ y ‘Cargo’ para las respectivas tablas de empleados.
SELECT nombre AS 'Nombre', cargo AS 'Cargo' FROM personal.empleados;

-- 11. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado por comisión de menor a mayor.
SELECT sal_emp, comision FROM personal.empleados WHERE id_depto = 2000 ORDER BY comision;

-- 12. Obtener el valor total a pagar a cada empleado del departamento 3000, que resulta de: sumar el salario y la comisión, más una bonificación de 500. Mostrar el nombre del empleado y el total a pagar, en orden alfabético.
SELECT nombre, (sal_emp + IFNULL(comision, 0) + 500) AS 'Total a pagar' FROM personal.empleados WHERE id_depto = 3000 ORDER BY nombre;

-- 13. Muestra los empleados cuyo nombre empiece con la letra J.
SELECT * FROM personal.empleados WHERE nombre LIKE 'J%';

-- 14. Listar el salario, la comisión, el salario total (salario + comisión) y nombre, de aquellos empleados que tienen comisión superior a 1000.
SELECT sal_emp, comision, (sal_emp + comision) AS 'Salario total', nombre FROM personal.empleados WHERE comision > 1000;

-- 15. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen comisión.
SELECT sal_emp, comision, (sal_emp + IFNULL(comision, 0)) AS 'Salario total', nombre FROM personal.empleados WHERE comision IS NULL;

-- 16. Obtener la lista de los empleados que ganan una comisión superior a su sueldo.
SELECT * FROM personal.empleados WHERE comision > sal_emp;

-- 17. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo.
SELECT * FROM personal.empleados WHERE comision <= 0.3 * sal_emp;


-- 18. Hallar los empleados cuyo nombre no contiene la cadena “MA”
SELECT * FROM personal.empleados WHERE nombre NOT LIKE '%MA%';

-- 19. Obtener los nombres de los departamentos que sean “Ventas”, “Investigación” o ‘Mantenimiento.
SELECT nombre_depto FROM personal.departamentos WHERE nombre_depto IN ('VENTAS', 'INVESTIGACIÓN', 'MANTENIMIENTO');

-- 20. Ahora obtener el contrario, los nombres de los departamentos que no sean “Ventas” ni “Investigación” ni ‘Mantenimiento.
SELECT nombre_depto FROM personal.departamentos WHERE nombre_depto NOT IN ('VENTAS', 'INVESTIGACIÓN', 'MANTENIMIENTO');

-- 21. Mostrar el salario más alto de la empresa.
SELECT MAX(sal_emp) AS 'Salario más alto' FROM personal.empleados;

-- 22. Mostrar el nombre del último empleado de la lista por orden alfabético.
SELECT nombre FROM personal.empleados ORDER BY nombre DESC LIMIT 1;

-- 23. Hallar el salario más alto, el más bajo y la diferencia entre ellos.
SELECT MAX(sal_emp) AS 'Salario más alto', MIN(sal_emp) AS 'Salario más bajo', MAX(sal_emp)-MIN(sal_emp) AS 'Diferencia' FROM personal.empleados;

-- 24. Hallar el salario promedio por departamento.
SELECT id_depto, AVG(sal_emp) as 'Salario promedio' FROM personal.empleados GROUP BY id_depto;

-- 25. Hallar los departamentos que tienen más de tres empleados. Mostrar el número de empleados de esos departamentos.
SELECT id_depto, COUNT(id_emp) as 'Numero de empleados' FROM personal.empleados GROUP BY id_depto HAVING COUNT(id_emp) > 3;
SELECT d.nombre_depto, COUNT(e.id_emp) AS num_empleados FROM departamentos d INNER JOIN empleados e ON d.id_depto = e.id_depto GROUP BY d.nombre_depto HAVING COUNT(e.id_emp) > 3;
-- 26. Hallar los departamentos que no tienen empleados
SELECT d.nombre_depto FROM departamentos d LEFT JOIN empleados e ON d.id_depto = e.id_depto WHERE e.id_emp IS NULL;


-- 27. Mostrar la lista de empleados, con su respectivo departamento y el jefe de cada departamento.
SELECT e.nombre AS 'Nombre empleado', d.nombre_depto AS 'Departamento', d.nombre_jefe_depto AS 'Jefe departamento' 
FROM personal.empleados e 
JOIN personal.departamentos d 
ON e.id_depto = d.id_depto;

-- 28. Mostrar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa. Ordenarlo por departamento.
SELECT * FROM personal.empleados WHERE sal_emp >= (SELECT AVG(sal_emp) FROM personal.empleados) ORDER BY id_depto;