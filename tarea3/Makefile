JC = javac

JFLAGS = -encoding UTF-8 -d . -Xlint:all

SOURCES = Entidades/*.java MecanicasCombate/*.java Simulador/*.java

all: clean compile
	@echo "¡Compilación y revisión de warnings lista!"

compile:
	$(JC) $(JFLAGS) $(SOURCES)

clean:
	@echo "Limpiando archivos compilados..."
	@rm -f Entidades/*.class MecanicasCombate/*.class Simulador/*.class

.PHONY: all compile clean
