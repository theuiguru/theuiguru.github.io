// CS3911 Assignment 1 | Created by Chris Thomas
//#include "file.h" is located below.
#include <iostream>
using namespace std;
void quickSort(int arr[], int left, int right);

int main()
{
	Account_Info.name;
	Account_Info.amount;
	Account_Info an_account;
	Account_Info accounts[5];

	cout << an_account.name = "Mr. Smith";
	cout << an_account.amount = 4000.00;
	cout << accounts[0] = an_account <<endl;

	cout << an_account.name = "Mrs. Jones";
	cout << an_account.amount = 1000.00;
	cout << accounts[1] = an_account <<endl;

	cout << an_account.name = "Mr. Axe";
	cout << an_account.amount = 6000.00;
	cout << accounts[2] = an_account <<endl;

	cout << an_account.name = "Mr. and Mrs. Builder";
	cout << an_account.amount = 800.00;
	cout << accounts[3] = an_account <<endl;

	cout << an_account.name = "Ms. Doe";
	cout << an_account.amount = 5500.00;
	cout << accounts[4] = an_account <<endl;

	return 0;
}

struct Account_Info {
	float amount;
	char name[30];
};

void quickSort(int arr[], int left, int right)
{
      int i = left, j = right;
      int temp;
      int pivot = arr[(left + right) / 2].amount;

      /* Partition */
      while(i <= j)
      {
		  while(arr[i].amount < pivot)
		  		i++;
          while(arr[j].amount > pivot)
          		j--;
          if(i <= j) {
                  temp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = temp;
                  i++;
                  j--;
          }
      };
      if(left < j)
            quickSort(arr, left, j);
      if(i < right)
            quickSort(arr, i, right);
}