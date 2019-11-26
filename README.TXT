========================
BUILD OUTPUT DESCRIPTION
========================

When you build an Java application project that has a main class, the IDE
automatically copies all of the JAR
files on the projects classpath to your projects dist/lib folder. The IDE
also adds each of the JAR files to the Class-Path element in the application
JAR files manifest file (MANIFEST.MF).

To run the project from the command line, go to the dist folder and
type the following:

java -jar "Projekt_PO_2.jar" 

To distribute this project, zip up the dist folder (including the lib folder)
and distribute the ZIP file.

Notes:

* If two JAR files on the project classpath have the same name, only the first
JAR file is copied to the lib folder.
* Only JAR files are copied to the lib folder.
If the classpath contains other types of files or folders, these files (folders)
are not copied.
* If a library on the projects classpath also has a Class-Path element
specified in the manifest,the content of the Class-Path element has to be on
the projects runtime path.
* To set a main class in a standard Java project, right-click the project node
in the Projects window and choose Properties. Then click Run and enter the
class name in the Main Class field. Alternatively, you can manually type the
class name in the manifest Main-Class element.


JAVAblalalalalalal


Wszystkie pliki textowe oraz graficzne s¹ na swoich miejscach, proszê ich nie przestawiaæ. Po uruchomieniu programu losowana jest karta dañ, sk³adaj¹ca siê z 10 potraw, mo¿na do niej tak¿e do³o¿yæ posi³ki. Ka¿dy rodzaj klienta posiada swój w³asny domek, co pozwala ich rozró¿niæ. Klienci cyklicznie zamawiaj¹ posi³ki, a dostawcy staraj¹ siê je rozwoziæ.
Pojazdy dostawców to smok lub koñ. Smok jest w stanie przewoziæ 2 zamówienia, gdy ma tak¹ mo¿liwoœæ w innym przypadku bierze jedno. Paliwa (dziewic) starcza mu rozwiezienie dwóch zamówieñ. Koñ natomiast rozwozi jedno zamówienie i na tyle te¿ ma paliwa (owsa).
Opis klas:
Dostawca - ustalenie danych, pobranie odpowiedniego pojazdu, cykliczne odbieranie zamówieñ z restuaracji, implementacja jazdy - w 4 kierunkach, nastêpnie dla smoka oraz dla koña, a takze powrót po rozwiezieniu zamówieñ.
Klient - ustalanie danych, cykliczne zamawianie towarów.
Dziedzicz¹ce z klienta - ustalenie ich cech wyró¿niaj¹cych
Kuñ - paramtetry kunia
Menu - klasa jFrame, serce programu, dzia³ania guzików, start resturacji, mapy oraz wszystkiego
Odczyt, klasa pomocnicza do odczytania danych tekstowych
Pojazd - klasa rodzic dla smoka i kunia
Posi³ek - rozlosowanie wartosci, dodanie do karty dan
Smok - parametry smoka
Restauracja - losowanie karty dan, odbieranie zamowien od klientow

Smoki jak wiadomo maja skrzyd³a, tak¿e przelatuj¹ nad innymi dostawcami, natomiast konie to konie widmo extends Duch, wiêc mog¹ przenikaæ, oczywiœcie jeœli tylko chc¹.