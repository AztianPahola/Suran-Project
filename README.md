This project is a simple application which takes a simple text document which for my example contains names, sperated 
by new lines and sorts them either ascending or descending by length and then ascending by alphabet.

Prerequisites: 
-Java APK on the target machine (Version 1.8+ recommended)

Instructions:
1. To sort the text file named 'Unsorted1.txt', simply double click the Sort.bat file and 
	the sorted output will be written to the 'SortAttempt1.txt' file.

2. The command prompt will ask you to enter 'A' to sort ascending by length or 'D' to sort
	descending by length, enter the one you would like, or neither if you want to be requested
	for 'A' or 'D' again.
3. To verify the sort was done effectively, feel free to check it yourself, or use the 'CompareAscending.bat'
	to verify the Ascending sort was done effectively, or "CompareDescending.bat' to verify
	descending sorting was done effectively.

Notes:
-If you wish to sort a different list than the one provided, replace the 'Unsorted1.txt' with whatever simple 
	test file you wish to sort. Keep in mind, however, that the tests will no longer work unless you also 
	replace the 'SortedD1' and 'SortedA1' with succesfully descending and ascending sorts respectively,
	as the 'Compare' bat files simply compare the attempt made by the program to the text file known to be
	the correct output.
