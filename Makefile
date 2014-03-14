CC=jar

files := $(wildcard */*.java) $(wildcard */*/*.java)

build: application.jar

application.jar: $(files)
	$(CC) cf $@ $^

clear:
	rm application.jar
