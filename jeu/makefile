.PHONY : clean mainRun 

all : CLASS

CLASS:
	mkdir bin;cd src/; javac serpent/Jeu.java -d ../bin; cd ..

doc:
	make;mkdir docs;cd src/; javadoc serpent serpent.controller serpent.entities serpent.music serpent.view -d ../docs; cd ..

mainRun:
	make;java -classpath bin serpent.Jeu

clean:
	-rm bin/*
	-rm -Rf bin/*
