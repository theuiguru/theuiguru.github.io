#include <iostream>
#include <string>
using namespace std;
using std::string;

struct node
{
	char *data;
	node *next;
};

class Linked_List
{
	private:
		// this is a pointer and it WILL point to something
		node *first;
		node *get_last();
	public:
		Linked_List();
		void add_item(char *str);
		void display();
};