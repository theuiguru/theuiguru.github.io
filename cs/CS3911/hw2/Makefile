hw2:		hw2.o
		g++ hw2.o -o hw2.exe

hw2.o:		hw2.cpp dictionary.h
		g++ -c hw2.cpp
		
dictionary.o:	dictionary.cpp dictionary.h Linked_List.h
		g++ -c dictionary.cpp

Linked_List.o:	Linked_List.cpp Linked_List.h String.h
		g++ -c Linked_List.cpp
		
string.o:	string.cpp string.h
		g++ -c string.cpp