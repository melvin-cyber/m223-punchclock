# Punchclock - Zeiterfassung

## Was ist Punchclock
* Punchclock ist eine Webanwendung, mit der man Zeiten für diverse AUfträge erfassen kann.

## Bedingungen zur ausführung der Applikation sind folgende:
* Es wird mindestens JDK 11 benötigt JDK 12 ist auch akzeptabel.
* Gradle muss installiert und verfügbar sein.

## Starten
1.  Im Verzeichnis der Applikation `./gradlew bootRun` (auf Unix-Systemen) oder `./gradlew.bat bootRun` (auf Windows-Systemen) ausführen;
2.  Im Browser auf http://localhost:8081/index.html aufrufen, nachdem gradle gestartet wurde;
3.  Nun muss ein neuer Benutzer hinzugefügt werden;
4.  mit dem angelegten User sollte man sich anmelden;
5.  Das verwalten von Benutzern und Einträgen sollte nun möglich sein;
6.  in der Date dump.sql findet sich ein Skript zum Einfügen von Beispieldaten
