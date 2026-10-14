Nombre Gabriela Maggi Boabadilla
Rol 202473142-4

Instrucciones

https://www.w3schools.com/java/default.asp

1. Se asume que la entrega de los json son en el orden arg[0] = rutaMovimientos y arg[1] = rutaEquipos

2. Para la lectura y parseo de los json elegimos utilizar la libreria Gson por los siguientes motivos:
        En lugar de complicarnos haciendo que la libreria adivine por si sola que tipo de Ataque instanciar, hacemos que el proceso
        sea más facil y seguro:
        - Leemos los ataques del json
        - Miramos el campo de la categoria (Físico, Especial, Estado) //con esa estructura
        - Creamos la instancia que corresponda y la guardamos en una lista ordenada (catalogo), donde el nombre es la clave.
        - Cuando un Javaling necesite un ataque, simplemente lo buscamos en el catalogo y se lo asignamos
    Para mayor estructura y limpieza del codigo, toda esta logica quedará dentro de una clase aparte: Lector.java dentro del package
    Simulador.

    Utilizamos la version 2.14.0, el archivo se encuentra en la carpeta lib del proyecto.

3. Compilacion y ejecución:
    javac -cp "lib/gson-2.14.0.jar" -d bin Entidades/*.java MecanicasCombate/*.java Simulador/*.java
    java -cp "lib/gson-2.14.0.jar;bin" Simulador.Main movimientos.json equipos.json
