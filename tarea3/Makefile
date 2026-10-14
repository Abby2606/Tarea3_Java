#Ruta libreria de lectura Gson
CLASSPATH = lib/gson-2.14.0.jar

all: compile

compile:
	javac -cp "$(CLASSPATH)" Entidades/*.java MecanicasCombate/*.java Simulador/*.java

run: compile
	java -cp ".:$(CLASSPATH)" Simulador.Main movimientos.json equipos.json

clean:
	rm -f Entidades/*.class MecanicasCombate/*.class Simulador/*.class
