# Tarea Junit

## Descripción:

Este programa corresponde a una tarea en la cual se simula el funcionamiento de una maquina expendedora de cafe en el lenguaje de Java. Ademas se utiliza la herramienta de Junit para generar pruebas unitarias y así probar las funcionalidades de la aplicación de manera independiente. Para mas informacion de las pruebas de Junit usadas y el comportamiento de la maquina ingresar a los .pdf de este directorio.

## Tecnología:

- Java jdk
- Junit 4.13.2
- Hamcrest-core-1.3

## Antes de empezar:

- Es necesario instalar Java jdk, para esto se debe ingresar a https://www.oracle.com/cl/java/technologies/javase-downloads.html y descargar el archivo dependiendo de el sistema operativo.
- Para asegurar que Java jdk esta instalado y la variable de entorno asociada esta configurada correctamente escribir el siguiente comando en la consola:
```
java -version
```
- En caso de que no se genere un error la variable de entorno esta configurada correctamente.
- En caso que se genere un error ingresar a el siguiente link para averiguar como configurar la variable de entorno: https://www.java.com/es/download/help/path_es.html

## Instrucciones de uso:

En caso de usar el sistema operativo de Windows solo es necesario ejecutar el archivo .bat que se requiera.
- Para ejecutar el programa, hacer doble click en ejecutablePrograma.
- Para ejecutar los test de Junit, hacer doble click en ejecutableTest.
En caso de usar el sistema Linux:

- Para ejecutar el programa, es necesario compilar y luego correr la clase TareaJunit.java usando el siguiente comando en este mismo directorio:
```
javac -cp "." TareaJunit.java
java -cp "." TareaJunit
```
- Para ejecutar los test de Junit, es necesario ejecutar los siguientes comandos
```
javac -cp ".:junit-4.13.2.jar:hamcrest-core-1.3.jar" UnitTest.java
java -cp ".:junit-4.13.2.jar:hamcrest-core-1.3.jar" org.junit.runner.JUnitCore UnitTest
```
