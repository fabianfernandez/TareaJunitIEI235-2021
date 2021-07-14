@ECHO OFF
javac -cp ".;junit-4.13.2.jar;hamcrest-core-1.3.jar" UnitTest.java
java -cp ".;junit-4.13.2.jar;hamcrest-core-1.3.jar" org.junit.runner.JUnitCore UnitTest
PAUSE
