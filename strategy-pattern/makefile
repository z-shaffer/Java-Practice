
JFLAGS = -d bin -sourcepath src

default:
	@echo "'make clean' removes *.class *~ files"
	@echo "'make compile' compiles all Java files"
	@echo "'make demo' runs simulator demo"
	@echo "'make test' runs JUnit5 test cases"

test: junit-platform-console-standalone-1.2.0.jar 
	java -cp .:bin:junit-platform-console-standalone-1.2.0.jar org.junit.platform.console.ConsoleLauncher --scan-class-path

clean:
	rm -f bin/*.class
	rm -f src/*~
	rm -f *~

compile: junit-platform-console-standalone-1.2.0.jar 
	javac $(JFLAGS) -cp .:junit-platform-console-standalone-1.2.0.jar src/*.java

demo: bin/Demo.class
	java -cp bin Demo

