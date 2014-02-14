/*Implementation file for Money.
// In addition to member functions, definitions of regular and friend functions
// are placed in this file.
// Also notice:
//  - Operator<= is defined in terms of operator< and operator==
//  - Operator!= is similarlyo defined in terms of operator==.  Note the use of *this in the code.*/
#ifndef MONEY_H
#define MONEY_H
#include <iostream> //should include this too because this file contains 'ostream' and 'istream'
#include <string>
#include <cmath>
using namespace std;

Money::Money(int d, int c)
{
	dollar = d;
	cent = c;
}

void Money::addCents(int centsToBeAdded)
{
	int totalcents = calcCents(dollar, cent) + centsToBeAdded;
	dollar = totalcents / 100;
	cent = totalcents % 100;
}

// static method, so no 'const' at the end. [In fact, instance members can NOT be accessed from static members.]
int Money::calcCents(int d, int c)
{
	int abAmount = (abs(d) * 100) + abs(c);
	return (d < 0 || c < 0) ? -abAmount : abAmount;
}

int Money::toAllCents() const
{
	return calcCents(dollar, cent);
}

// Overloaded operators (by member function)
Money Money::operator+(const Money & m2) const
{
	int total = (dollar * 100) + cent + (m2.dollar * 100) + m2.cent;
	int newd = total / 100;
	int newc = total % 100;
	Money local(newd, newc);
	return local;
}

Money Money::operator-(const Money & m2) const
{
	int total = ((dollar * 100) + cent) - ((m2.dollar * 100) + m2.cent);
	int newd = total / 100;
	int newc = total % 100;
	Money local(newd, newc);
	return local;
}

Money Money::operator-() const
{
	return Money(-dollar, cent);
}

Money Money::operator*(double r) const
{
	int newtotal = static_cast<int>(calcCents(dollar, cent) * r);
	return Money(newtotal / 100, newtotal % 100);
}

bool Money::operator==(const Money & m2) const
{
	return (calcCents(dollar, cent) == calcCents(m2.dollar, m2.cent));
}

bool Money::operator!=(const Money & m2) const
{
	// *this gives _this_ object; calls operator==; then negate it
	return !(*this == m2);
}

//Definitions of friend functions
ostream& operator<<(ostream & o, const Money & m)
{
	if (m.dollar < 0 || m.cent < 0)
	o << '-';
	o << '$' << abs(m.dollar) << '.';
	int acent = abs(m.cent);
	if (acent < 10)
	o << '0';
	o << acent;
	return o;
}

istream& operator>>(istream & in, Money & m)
{
	char dollarSign, dot;
	int d, c;
	// Assume a Money is entered as "$xx.yy"
	in >> dollarSign >> d >> dot >> c;
	m.dollar = d;
	m.cent = c;
	return in;
}

//Definitions of regular functions
bool operator<(const Money & m1, const Money & m2)
{
	int thistotal = m1.getDollar() * 100 + m1.getCent();
	int m2total = m2.getDollar() * 100 + m2.getCent();
	return (thistotal < m2total);
}

bool operator<=(const Money & m1, const Money & m2)
{
	// <= can be defined in terms of < and ==
	return (m1 < m2 || m1 == m2); // operator< and operator== are written already
}

Money operator*(double r, const Money & m)
{
	return (m * r); // call the other operator* (member function)
}

void Money::to_string() const
{
	if (dollar < 0 || cent < 0)
		cout << '-';
	cout << '$' << abs(dollar) << '.';
	float acent = abs(cent);
	if (acent < 10)
		cout << '0';
	cout << acent;
}

bool compare(Money *m1, Money *m2)
{
	if(m1>m2)
	{
		return true;
	}
	else
	{
		return false;
	}
}