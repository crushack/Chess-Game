CC=jar

files := $(wildcard */*.java) $(wildcard */*/*.java)

build: application.jar

application.jar: $(files)
	$(CC) cfe $@ default.application $^

clear:
	rm application.jar
