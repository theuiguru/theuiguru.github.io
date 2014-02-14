#include <iostream>
#include <fstream>
#include "Dictionary.h"
using namespace std;

void Dictionary::addWord(int MAX_WORD_SIZE, int Count, string Word, int Size, int Words)
{
	{
	void Dictionary::loadFile("words.txt");
	//open.inData("words.txt");
	try
	{
	cout << "\tEnter a new word, keep it below " << MAX_WORD_SIZE << " characters: ";
	cin >> Word;
		 Size  = strlen(Word);
	if(Size == 0 || Size > MAX_WORD_SIZE)
		throw Word;
		strcpy_s(Words[Count++],MAX_WORD_SIZE,Word);
		for (int i = 0; i < Count; ++i)
			inData << Words[i] << endl;
	}
	catch (int word)
	{
		cout << "An error was found incorrect key entered\n";
	}
	}
}

void Dictionary::deleteWord()
{
	//
}

void Dictionary::findWord()
{
	//
}

void Dictionary::getWord(string skipWord, char hmWord[], int & letAmount)
{
	ifstream inData;
	int randNum;  // used to randomize which word gets pick.
	randNum = rand()%11; // assigns "randNum" to a random number 0 - 11
	while( (randNum < 1) || (randNum > 10) ) // This loop makes sure that "randNuM"
		randNum = rand()%11;				 // stay's between 1 - 10
	inData.open("words.txt"); // open's up "words.txt"
	for(int i = 0; i < randNum; i++) // a for loop that reads through the words list
	{								 // and skips over the words that aren't in the location of
		outData >> skipWord;			 // where are "randNum" stops at.
	}
	outData >> hmWord; // reads in the random word and stores in "hmWord[]"
	outData.close("Words.txt"); // closes file
	letAmount = strlen(hmWord);
}

int main ()
{
	string word;
	char inChar;
	//Controller myController;
	void Start();
	return 0;
}