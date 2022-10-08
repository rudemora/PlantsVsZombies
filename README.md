# tp1
AÑADIR ZOMBIS:
Should add zombie(implementado trabajando con la aletoriedad de la frecuencia, en zombi manager)
Add zombie(medio implementado, en zombi manager)Falta:
	-Disminuir el numero de zombis que quedan por salir
	-Añadir el zombi en si:
		i)en la posicion i de la zombie list (el zombie q añades) le metes al zombi su posicion en el tablero (Lo que haria sería
		  añadirle atributos al zombie para la posicion con métodos accesores y mutadores)
		
Luego todo esto lo metes en el update de game (por cada ciclo un add que ya lleva todo dentro implementado)


ZOMBIES AVANZAN:
-Método en game si una casilla está ocupada
-Compruebo que la casilla siguiente a un zombi no esté ocupada
-Cambio su posicion
-Con el contador que avanza una casilla cada 2 ciclos.

ZOMBIE ATACA A PLANTA:
-Método en game para saber si un zombie tiene que avanzar o atacar (viendo la casilla siguiente)
-Método game que un zombie ataque a una planta en caso necesario:
	i) Metodo accesor en zombi get daño
	ii) Metodo accesor en planta get vida
	iii) Metodo set en planta cambiar vida
	iv)Comprobar si la planta ha llegado a 0 de vida y desaparecer en dicho caso


GENERACIÓN DE SOLES SUNFLOWER:
-Añadir un método a la clase sunflower que sea añadir soles (teniendo en cuenta q se añaden 10 cada 3 ciclos por tanto con vble cuenta y tal)
-Lo haces para todos con un método con for en sunflower list


LANZAGUISANTES DISPARAN:
-



EL USUARIO ELIJE LA OPCIÓN:
1) se lee lo que ha introducido con el prompt
2) Luego para saber lo que hay que hacer se hace un switch comparando la entrada del usuario con el nombre de las opciones (con .equals creo)
3) Dentro de cada opción, se hace la opción

NOTAS:
Obviamente en la clase game va a haber que crear listas de todo.
Para poder pintar el tablero podríamos crear una matriz bidemensional con lo q hay en cada cosa porq si hay que tirar con los zombilist y
tal igual es mucho orden de complejidad.

-Imprimir el tablero (el metodo printgame que ya estaba creado y el tostring de game printer)


PREGUNTAS: 
Como se gestiona lo que hay en el tablero?
Hasta que punto los métodos set y get rompen la encapsulación?
