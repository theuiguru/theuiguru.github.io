#include <iostream>
#include <string>
#include <cstring>
#include "string.h"
using namespace std;

char get_string()
{
	return data;
}

char get_prefix()
{
	return data = 0;
}

char String()
{
	cout<<"Deleting str\n";
	delete[] str;
}

void display()
{
	cout<<str;
}

int main()
{
	String *s1 = new String("Hello World!");
	cout<<"String object contains \"";
	s1->display();
	cout<<"\"\n";
	return 0;
}