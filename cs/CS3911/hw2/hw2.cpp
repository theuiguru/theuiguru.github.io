#include "string.h"
#include "dictionary.h"
#include "Linked_List.h"
#include <iostream>
#include <string>
using namespace std;
using std::string;

void add_item(char *str);
void display();

int main()
{
	Linked_List *list = new Linked_List();
	node* = NULL;
	int option;
	do {
	  display();
	  cout << endl;
	  cout << "Please select an option : " << endl;
	  cout << "0. Exit the program" << endl;
	  cout << "1. Add" << endl;
	  cout << "2. Delete" << endl;
	  cout << "3. Search" << endl;
	  cin >> option;

	  switch (option)
	  {
	      case 1: break;
	      case 2: break;
	      case 3: break;
	      case 4: break;
	      case 5: break;
	  }
	} while (option != 0);

	return 0;
}