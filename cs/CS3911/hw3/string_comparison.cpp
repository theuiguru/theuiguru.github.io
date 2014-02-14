#include <iostream>
#include <string>
using namespace std;

void Linked_List<T>::Linked_List();

bool compare(string_comparison *s1, string_comparison *s2)
{
	*s1 = name;
	*s2 = networth;

	if(s1>s2)
	{
		return true;
	}
	else
	{
		return false;
	}
}