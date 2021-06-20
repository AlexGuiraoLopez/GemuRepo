-- GAME REPO--

Antes de empezar:
=> Para poder ejecutar el programa es necesario que el servidor local tenga conectada la base de datos.
=> Para hacerlo, se debe ejecutar el archivo "VideogameCollection.sql" e importar la base de datos.
=> Una vez conectada la base de datos ya es posible ejecutar el programa desde el archivo ejecutable "dist/GemuRepository.jar".
=> En el caso de que aparezca una ventana de error quiere decir que el programa no ha podido conectar con la base de datos. Por favor revisa la conexión.


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

=> Programa principal:
	- Menú superior con las siguientes funcionalidades:
	=> Añadir videojuego.
	=> Eliminar videojuego.
	=> Guardar datos.
	=> Estadísticas (total de videojuegos introducidos y porcentaje de completados).
	=> Ordenar lista de videojuegos según título, consola, empresa o fecha.
	=> Eliminar todos los datos. (hay que escribir una palabra de seguridad para realizar esta acción).
	=> Salir (si hay datos modificados se pregunta al usuario si quiere guardarlos antes de salir).


Tecnologías utilizadas:
=> Programado en Java utilizando JSwing para la GUI.
=> Base de datos SQL.

Observaciones:
=> Para vincular la imagen de un videojuego cuando lo añadimos a la lista, dicha imagen tiene que estar en assets/caseImage
y tiene que tener el nombre de archivo equivalente al título del juego que se introduce.


Versión 1.0 (24/05/2021)
Versión 2.0 (20/06/2021)

Fecha de inicio del proyecto 20/05/2021

Contacto para informar de errores: alexguiraolopez@gmail.com