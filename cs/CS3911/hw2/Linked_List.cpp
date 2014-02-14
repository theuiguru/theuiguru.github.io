#include <iostream>
#include <string>
#include "Linked_List.h"
using namespace std;

Linked_List::Linked_List()
{
	first = NULL;
}

node* Linked_List::get_last()
{
	node *current = first;
	while (current->next != NULL)
	{
		current = current->next;
	}
	return current;
}

void Linked_List::add_item(String *str)
{
	node *new_node = new node;
	new_node->data = new char[strlen(str)+1];
	strcpy(new_node->data, str);
	new_node->next = NULL;

	if (first == NULL)
	{
		first = new_node;
	}
	else
	{
		node *last = get_last();
		last->next = new_node;
	}
	// class => new class()
	// struct => no methods, no parentheses
	node *new_node = new node;
	new_node->data = int n;
	new_node->next = first;
	first = new_node;
}

void Linked_List::display()
{
	node *current = first;
	while (current != NULL)
	{
		cout<<current->data<<endl;
		current = current->next;
	}
}