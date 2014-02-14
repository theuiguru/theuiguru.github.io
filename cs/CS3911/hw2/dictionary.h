#include <iostream>
#include <string>
using namespace std;

class Dictionary
{
	public:
		void addWord(int MAX_WORD_SIZE, int Count, string Word, int Size, int Words);
		void deleteWord();
		void findWord();
		void getWord(string skipWord, char hmWord[], int & letAmount);
		string words;
		Dictionary();
		void loadFile();
};