-- GAME REPO--

Antes de empezar:
=> Para que se muestren las imágenes de los videojuegos de la lista al seleccionarlos, deben situarse dentro de la carpeta "assets/caseImage" y el nombre 
de la imágen debe ser igual al título del videojuego introducido.


Descripción programa:
=> Programa de gestión de datos sobre una colección de videojuegos.

=> El usuario puede registrar datos sobre sus videojuegos como por ejemplo: 
(Título, año de publicación, empresa, consola, imagen de portada...)

=> Todos los datos persisten. Una vez el usuario cierra la aplicación, si ha seleccionado la opción de guardar, los datos
son transferidos a la base de datos. Si no ha guardado, se le advierte de que podría perderlos si sale del programa y le permite guardarlos antes de salir.
binario.

=> Los usuarios también se guardan en la base de datos justo en el momento de registrarse.


Interfaz Usuario:
=> Login inicial en el que el usuario puede acceder al programa, registrarse o recuperar su contraseña.

=> Funciones principales:
	=> Añadir videojuego.
	=> Eliminar videojuego.
	=> Guardar datos.
	=> Estadísticas (total de videojuegos introducidos y porcentaje de completados).
	=> Ordenar lista de videojuegos según título, consola, empresa o fecha.
	=> Eliminar todos los datos. (hay que escribir una palabra de seguridad para realizar esta acción).
	=> Conectar con una Base de Datos externa para importar o exportar la información.
	=> Salir (si hay datos modificados se pregunta al usuario si quiere guardarlos antes de salir).

Conexión con la base de datos:
=> El programa incluye una función para conectar con una base de datos externa y poder acceder a los datos del programa desde cualquier dispositivo.
=> Para poder ejecutar dichas funciones es necesaria la conexión con el servidor.
=> Para hacerlo, se debe ejecutar el archivo "VideogameCollection.sql" e importar la base de datos desde cualquier gestor MySQL.
=> En el caso de que aparezca una ventana de error quiere decir que no se ha podido conectar con la base de datos. Por favor revisa la conexión o las credenciales de acceso.


Tecnologías utilizadas:
=> Programado en Java utilizando JSwing para la GUI.
=> Base de datos SQL.


Versión 1.0 (24/05/2021)
Versión 2.0 (20/06/2021)
Versión 3.0 (EN DESARROLLO)

Fecha de inicio del proyecto 20/05/2021

Contacto para informar de errores: alexguiraolopez@gmail.com