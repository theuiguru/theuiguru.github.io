#ifndef MONEY_H
#define MONEY_H
#include <iostream> //should include this too because this file contains 'ostream' and 'istream'
#include <string>
#include <cmath>
using namespace std;

class Money
{
public:
  Money(int d = 0, int c = 0);

  double getAmount() const { return dollar + ((double) cent / 100); }
  int toAllCents() const;
  void to_string() const;  // print "$ddd.cc" to cout
  void addCents(int centsToBeAdded);

  // Additional getter & setter methods
  int getDollar() const { return dollar; }
  int getCent() const { return cent; }
  void setDollar(int d) { dollar = d; }
  void setCent(int c) { cent = c; }

  // (*) Overloaded operators implemented as a member function
  Money operator+(const Money & m2) const;
  Money operator-(const Money & m2) const;
  Money operator-() const;
  Money operator*(double r) const;  // for Money * double

  bool operator==(const Money & m2) const;
  bool operator!=(const Money & m2) const;

  // (*) Friend functions(' prototypes)
  friend ostream& operator<<(ostream & out, const Money & m);
  friend istream& operator>>(istream & in, Money & m);

  // (**) static methods
  static int calcCents(int d, int c);

private:
  int dollar;
  int cent;
};

// Prototypes of regular functions associated with Money
bool operator<(const Money & m1, const Money & m2);
bool operator<=(const Money & m1, const Money & m2);
Money operator*(double r, const Money & m); // for double * Money
#endif