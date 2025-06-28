# prueba-tecnica-java-basico


El proyecto se trata de un CRUD, clasificado por capas (entities,persistence y controllers).
Consta de un menú en el que tienes las opciones de: Agregar un cliente
						                                        Listar clientes
						                                        Actualizar clientes
						                                        Eliminar clientes
						                                        Buscar a los clientes de una ciudad
						                                        Salir

En el Main tenemos un Scanner para recibir los datos que inserte el usuario. Estan invocados los metodos derivados de controller.

En Cliente JPA tenemos los codigos relacionados que llaman al EntityManager para conectarse a la base de datos(BD) 
y las funciones que deben realizar como añadir el cliente a la BD o eliminarlo.

En ConfigJPA está el codigo que crea el EntityManager para conectarse con la BD.

Sexo contiene el enum de la variable sexo para obligar al usuario entre escoger entre hombre o mujer u otro.

ClienteController obtiene las funciones necesarias para realizar las opciones del menu.
Dispone de condicionales como while para avisar al usuario de que las variables no pueden estar vacias pidiendo de nuevo que inserte algun dato valido.
A la hora de ingresar el sexo tiene un try para prevenir errores de forma que 
si el usuario inserta un dato que no sea mujer, hombre u otro salte al catch diciendole que el dato insertado no es valido.
También dispone de : find para buscar el cliente por ID.
		     if para mandar un mensaje al usuario cuando inserte un dato vacio y otro para dar la opcion de salir al menu.

En Cliente esta el Entity para representar una entidad en la base de datos y Table para asignar el nombre de la tabla en la BD.
El @ID para marcar el id como clave primaria, el @GeneratedValue para generar el valor automaticamente, 
@Column definiendo que no puede ser null y la longitud maxima de la colummna que seria 50.
También están las variables, un constructor vacio que és obligatorio en trabajos con BD. getter de id y getters y setters del resto a mas del ToString de todo.

