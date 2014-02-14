#include <iostream>
#include <string>
using namespace std;

bool compare(string_comparison *s1, string_comparison *s2);
void Linked_List<T>::Linked_List();

void quicksort(float arr[], float left, float right)
{
      float i=left, j=right;
      float temp;
      float pivot = arr[(left + right) / 2];

      /* Partition */
      while(i <= j)
      {
          while(arr[i] < pivot)
              i++;
          while(arr[j] > pivot)
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
            quicksort(arr, left, j);
      if(i < right)
            quicksort(arr, i, right);
}