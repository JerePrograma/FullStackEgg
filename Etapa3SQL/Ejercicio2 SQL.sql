/* Consulta 1: Lista el nombre de todos los productos que hay en la tabla producto. */
SELECT 
    nombre
FROM
    producto;

/* Consulta 2: Lista los nombres y los precios de todos los productos de la tabla producto. */
SELECT 
    nombre, precio
FROM
    producto;

/* Consulta 3: Lista todas las columnas de la tabla producto. */
SELECT 
    *
FROM
    producto;

/* Consulta 4: Lista los nombres y los precios de todos los productos de la tabla producto, redondeando el valor del precio. */
SELECT 
    nombre, ROUND(precio, 0)
FROM
    producto;

/* Consulta 5: Lista el código de los fabricantes que tienen productos en la tabla producto. */
SELECT 
    codigo_fabricante
FROM
    producto;

/* Consulta 6: Lista el código de los fabricantes que tienen productos en la tabla producto, sin mostrar los repetidos. */
SELECT DISTINCT
    codigo_fabricante
FROM
    producto;

/* Consulta 7: Lista los nombres de los fabricantes ordenados de forma ascendente. */
SELECT 
    nombre
FROM
    fabricante
ORDER BY nombre ASC;

/* Consulta 8: Lista los nombres de los productos ordenados en primer lugar por el nombre de forma ascendente y en segundo lugar por el precio de forma descendente. */
SELECT 
    nombre, precio
FROM
    producto
ORDER BY nombre ASC , precio DESC;

/* Consulta 9: Devuelve una lista con las 5 primeras filas de la tabla fabricante. */
SELECT * FROM fabricante LIMIT 5;

/* Consulta 10: Lista el nombre y el precio del producto más barato. (Utilice solamente las cláusulas ORDER BY y LIMIT) */
SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT 1;

/* Consulta 11: Lista el nombre y el precio del producto más caro. (Utilice solamente las cláusulas ORDER BY y LIMIT) */
SELECT nombre, precio FROM producto ORDER BY precio DESC LIMIT 1;

/* Consulta 12: Lista el nombre de los productos que tienen un precio menor o igual a $120. */
SELECT nombre FROM producto WHERE precio <= 120;

/* Consulta 13: Lista todos los productos que tengan un precio entre $60 y $200. Utilizando el operador BETWEEN. */
SELECT * FROM producto WHERE precio BETWEEN 60 AND 200;

/* Consulta 14: Lista todos los productos donde el código de fabricante sea 1, 3 o 5. Utilizando el operador IN. */
SELECT * FROM producto WHERE codigo_fabricante IN (1, 3, 5);

/* Consulta 15: Devuelve una lista con el nombre de todos los productos que contienen la cadena 'Portátil' en el nombre. */
SELECT nombre FROM producto WHERE nombre LIKE '%Portátil%';


/* Consulta 1: Devuelve una lista con el código del producto, nombre del producto, 
código del fabricante y nombre del fabricante, de todos los productos de la base de datos. */
SELECT producto.codigo, producto.nombre, fabricante.codigo, fabricante.nombre
FROM producto
JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo;
/* Consulta 2: Devuelve una lista con el nombre del producto, precio y nombre de 
fabricante de todos los productos de la base de datos, ordenado por el nombre del fabricante alfabéticamente. */
SELECT producto.nombre, producto.precio, fabricante.nombre
FROM producto
JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo
ORDER BY fabricante.nombre ASC;
/* Consulta 3: Devuelve el nombre del producto, su precio y el nombre de su fabricante, 
del producto más barato. */
SELECT producto.nombre, producto.precio, fabricante.nombre
FROM producto
JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo
ORDER BY producto.precio ASC
LIMIT 1;
/* Consulta 4: Devuelve una lista de todos los productos del fabricante Lenovo. */
SELECT producto.*
FROM producto
JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo
WHERE fabricante.nombre = 'Lenovo';
/* Consulta 5: Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que $200. */
SELECT producto.*
FROM producto
JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo
WHERE fabricante.nombre = 'Crucial' AND producto.precio > 200;
/* Consulta 6: Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard, utilizando el operador IN. */
SELECT producto.*
FROM producto
JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo
WHERE fabricante.nombre IN ('Asus', 'Hewlett-Packard');
/* Consulta 7: Devuelve un listado con el nombre de producto, precio y nombre de fabricante, 
de todos los productos que tengan un precio mayor o igual a $180. Ordena el resultado primero por el precio (descendente) 
y segundo por el nombre (ascendente). */
SELECT producto.nombre, producto.precio, fabricante.nombre
FROM producto
JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo
WHERE producto.precio >= 180
ORDER BY producto.precio DESC, producto.nombre ASC;

/* Consulta Multitabla 1: Devuelve un listado de todos los fabricantes que existen en la base de datos, junto con los productos que tiene cada uno de ellos. También muestra aquellos fabricantes que no tienen productos asociados. */
SELECT fabricante.nombre, producto.nombre
FROM fabricante
LEFT JOIN producto ON fabricante.codigo = producto.codigo_fabricante;

/* Consulta Multitabla 2: Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado. */
SELECT 
    fabricante.nombre
FROM
    fabricante
        LEFT JOIN
    producto ON fabricante.codigo = producto.codigo_fabricante
WHERE
    producto.codigo IS NULL;

/* Subconsulta 1: Devuelve todos los productos del fabricante Lenovo (Sin utilizar INNER JOIN). */
SELECT 
    *
FROM
    producto
WHERE
    codigo_fabricante = (SELECT 
            codigo
        FROM
            fabricante
        WHERE
            nombre = 'Lenovo');

/* Subconsulta 2: Devuelve todos los datos de los productos que tienen el mismo precio que el producto más caro del fabricante Lenovo. (Sin utilizar INNER JOIN). */
SELECT * FROM producto
WHERE precio = (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo'));

/* Subconsulta 3: Lista el nombre del producto más caro del fabricante Lenovo. */
SELECT 
    nombre
FROM
    producto
WHERE
    precio = (SELECT 
            MAX(precio)
        FROM
            producto
        WHERE
            codigo_fabricante = (SELECT 
                    codigo
                FROM
                    fabricante
                WHERE
                    nombre = 'Lenovo'));

/* Subconsulta 4: Lista todos los productos del fabricante Asus que tienen un precio superior al precio medio de todos sus productos. */
SELECT 
    *
FROM
    producto
WHERE
    codigo_fabricante = (SELECT 
            codigo
        FROM
            fabricante
        WHERE
            nombre = 'Asus')
        AND precio > (SELECT 
            AVG(precio)
        FROM
            producto
        WHERE
            codigo_fabricante = (SELECT 
                    codigo
                FROM
                    fabricante
                WHERE
                    nombre = 'Asus'));

/* Subconsulta con IN 1: Devuelve los nombres de los fabricantes que tienen productos asociados. */
SELECT 
    nombre
FROM
    fabricante
WHERE
    codigo IN (SELECT DISTINCT
            codigo_fabricante
        FROM
            producto);

/* Subconsulta con IN 2: Devuelve los nombres de los fabricantes que no tienen productos asociados. */
SELECT 
    nombre
FROM
    fabricante
WHERE
    codigo NOT IN (SELECT DISTINCT
            codigo_fabricante
        FROM
            producto);

/* Subconsulta en HAVING 1: Devuelve un listado con todos los nombres de los fabricantes que tienen el mismo número de productos que el fabricante Lenovo. */
SELECT 
    fabricante.nombre
FROM
    fabricante
        JOIN
    producto ON fabricante.codigo = producto.codigo_fabricante
GROUP BY fabricante.nombre
HAVING COUNT(producto.codigo) = (SELECT 
        COUNT(producto.codigo)
    FROM
        producto
    WHERE
        codigo_fabricante = (SELECT 
                codigo
            FROM
                fabricante
            WHERE
                nombre = 'Lenovo'));