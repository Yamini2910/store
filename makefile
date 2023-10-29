all: Main.java User.java CustomerMenu.java AdminMenu.java Shopping.java DataManager.java
	javac Main.java User.java CustomerMenu.java AdminMenu.java Shopping.java DataManager.java
run: all
	java Main
clean:
	rm *.class
