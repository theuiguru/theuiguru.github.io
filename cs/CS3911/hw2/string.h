#include <iostream>
#include <string>
#include <cstring>
using namespace std;

class String
{
	public:
		String(); // default constructor
		String(const char*);
		String(const String&); // copy constructor
		virtual ~String(); // Destructor
		String& operator=(const String&);
		int length() const;
		void print() const;
		void setChar(int, char);
		static String concat(const String&, const String&);
	private:
		char* data;
};