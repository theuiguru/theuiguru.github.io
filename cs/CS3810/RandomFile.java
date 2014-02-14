/* [Prepared by the instructor]
 This is a demo program to show the following operations of a random access file
 1) Creates a random-access file
 2) write one record to the file
 3) read one record from the file
*/
import java.io.*;
import java.io.RandomAccessFile;
public class RandomFile
{
	public static void main( String args[] )
	{
		Record rec = new Record("Lili Hai", "0002");
		Record rec1 = new Record();
		RandomAccessFile f = null;
		try
		{
			f = new RandomAccessFile("newfile.txt", "rw");
			f.seek(0);
			rec.write(f);
		}
		catch (IOException e)
		{
			System.out.println("cannot write\n" + e);
		}
		try
		{
			if (f != null)
			{
				f.seek(0);
				rec1.read(f);
				f.close();
			}
		}
		catch (EOFException ee)
		{
			System.out.println("end of file");
		}
		catch (IOException e)
		{
			System.out.println("cannot read\n" + e);
		}
		System.out.println(rec1);
	} // end main
} // end class RandomFile