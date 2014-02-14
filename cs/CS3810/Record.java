/* [Prepared by the instructor]
 * Record class
This class defines a record which is specifically for storing in
a Java random access file. See API of RandomAccessFile class in Java.

Attributes:
	name - String, the max length is 16 chars
	id - String, the number of digits in id is 4.
 *
*/
import java.util.*;
import java.io.*;
public class Record
{
	private String name;
	private String id;
	private int NAMELENGTH=16;
	private int IDLENGTH=4;
	public Record()
	{
		name = " ";
		id = " ";
	}

	public Record(String newName, String newId)
	{
		name = newName;
		id = newId;
	}

	//Read a 'name' and the related 'id' from the current position of the given file
	public void read(RandomAccessFile file) throws IOException
	{
		name = readString(file, NAMELENGTH);
		id = readString(file, IDLENGTH);
	}

	//Write the value of 'this' object to the given file
	public void write(RandomAccessFile file) throws IOException
	{
		writeStr(file, name, NAMELENGTH);
		writeStr(file, id, IDLENGTH);
	}

	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	//Help method: Read a string with length of strLength from the file. Return the string to the caller
	private String readString (RandomAccessFile file, int strLength) throws IOException
	{
		char[] chs = new char[strLength];

		for (int i = 0; i < chs.length; i++)
		{
			chs[i] = file.readChar();
		}
		String theStr = new String(chs).replace('\0', ' ');

		return theStr;
	}

	//Help method: write a string with length of strLength to the file
	private void writeStr( RandomAccessFile file, String str, int strLength ) throws IOException
	{
		StringBuffer buffer = null;

		if ( str != null )
			buffer = new StringBuffer( str );
		else
			buffer = new StringBuffer( strLength );

		buffer.setLength( strLength );
		file.writeChars( buffer.toString() );
	} // end method writeName

	public String toString()
	{
		return "\nName: " + name + "\nID: " + id;
	}
}