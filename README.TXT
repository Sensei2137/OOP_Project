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


Wszystkie pliki textowe oraz graficzne s� na swoich miejscach, prosz� ich nie przestawia�. Po uruchomieniu programu losowana jest karta da�, sk�adaj�ca si� z 10 potraw, mo�na do niej tak�e do�o�y� posi�ki. Ka�dy rodzaj klienta posiada sw�j w�asny domek, co pozwala ich rozr�ni�. Klienci cyklicznie zamawiaj� posi�ki, a dostawcy staraj� si� je rozwozi�.
Pojazdy dostawc�w to smok lub ko�. Smok jest w stanie przewozi� 2 zam�wienia, gdy ma tak� mo�liwo�� w innym przypadku bierze jedno. Paliwa (dziewic) starcza mu rozwiezienie dw�ch zam�wie�. Ko� natomiast rozwozi jedno zam�wienie i na tyle te� ma paliwa (owsa).
Opis klas:
Dostawca - ustalenie danych, pobranie odpowiedniego pojazdu, cykliczne odbieranie zam�wie� z restuaracji, implementacja jazdy - w 4 kierunkach, nast�pnie dla smoka oraz dla ko�a, a takze powr�t po rozwiezieniu zam�wie�.
Klient - ustalanie danych, cykliczne zamawianie towar�w.
Dziedzicz�ce z klienta - ustalenie ich cech wyr�niaj�cych
Ku� - paramtetry kunia
Menu - klasa jFrame, serce programu, dzia�ania guzik�w, start resturacji, mapy oraz wszystkiego
Odczyt, klasa pomocnicza do odczytania danych tekstowych
Pojazd - klasa rodzic dla smoka i kunia
Posi�ek - rozlosowanie wartosci, dodanie do karty dan
Smok - parametry smoka
Restauracja - losowanie karty dan, odbieranie zamowien od klientow

Smoki jak wiadomo maja skrzyd�a, tak�e przelatuj� nad innymi dostawcami, natomiast konie to konie widmo extends Duch, wi�c mog� przenika�, oczywi�cie je�li tylko chc�.