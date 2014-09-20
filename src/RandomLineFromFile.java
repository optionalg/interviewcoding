import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class RandomLineFromFile
{
	public static String pick(String fileName) throws IOException
	{
		Scanner scanner = new Scanner(new File(fileName));
		int lineNumber = 0;
		String line = new String();
		String buffer = new String();
		Random rand = new Random();
		while (scanner.hasNextLine())
		{
			line = scanner.nextLine();
			lineNumber++;
			if (rand.nextInt(lineNumber) == 0)
				buffer = line;
		}
		scanner.close();
		return buffer;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(pick("BigFile.txt"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
