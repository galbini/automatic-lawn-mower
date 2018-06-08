## Automatic lawn mowers

This project is a Gradle project to play with several automatic lawn mowers.
The automatic lawn mowers move on a grid where bottom left corner is (0,0) and the top right corner is defined in a file.
The automatic lawn mowers does not quit the grid and avoid the busy places.

### Prerequisite
* Java 8 or higher
* Gradle

### Run with Gradle
```script
gradle run -Pfile=src/test/data-test.txt
gradle run -Pfile=src/test/data-test-2.txt
```
### Gradle output
Display the last position of each lawn mowers defined in the file

```script
> Task :run
1 3 N
5 1 E
```
### File format
TODO
