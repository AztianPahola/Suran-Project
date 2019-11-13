@echo off
echo ****************** Ascending Sort Test ******************
java -jar SuranSorting\dist\SuranSorting.jar A
fc SortAttempt1.txt SortedA1.txt
echo ****************** Descending Sort Test ******************
java -jar SuranSorting\dist\SuranSorting.jar D
fc SortAttempt1.txt SortedD1.txt
PAUSE
