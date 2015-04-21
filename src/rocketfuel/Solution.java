package rocketfuel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * This class has main implementation of unix tail command.
 * We have just focused on -n and -f arguments.
 * Input arguments could be one of the following formats:
 * -n[number] -f <FilePath>
 * -n is an optional argument, when provided it over writes the default tail value(10).
 * We can just provide number too.
 * -f argument specifies that we are following the changes in the file. Default value of it is false.
 * <FilePath> is required argument @throws IOException,FileNotFoundException exception
 * when incorrect.
 *  
 * @author Monish
 *
 */

/*
 * Implementation detail
 * We use two pointers(BufferedReaders) to reach to the point where we want to start displaying.
 * We read until the end of file is reached.
 * If (-f) follow argument is specified then we sleep the current thread for 1 sec on reaching end of 
 * file. The thread runs until killed explicitly.  
 */

public class Solution {
	static long sleepTime = 1000;

	public static void main(String[] args) {
		boolean isFollow = false;
		int numberOfLines = 10;
		String inputFile = null;
		BufferedReader br1, br2;
		String currentLine = null;

		if (args.length == 0 || args.length > 4) {
			System.err.println("Usage: Tail [-n] [-f] <file path>");
			System.exit(-1);
		}

		for (int indexArgs = args.length - 1; indexArgs >= 0; indexArgs--) {
			if (args[indexArgs].equals("-f"))
				isFollow = true;
			else if (args[indexArgs].equals("-n")
					&& args[indexArgs + 1].matches("^[0-9]+$")) {
				numberOfLines = Integer.parseInt(args[indexArgs + 1]);
			} else if (args[indexArgs].matches("^-n[0-9]+$")) {
				numberOfLines = Integer
						.parseInt(args[indexArgs].split("-n")[1]);
			} else if (args[indexArgs].matches("^-[0-9]+$")) {
				numberOfLines = Integer.parseInt(args[indexArgs]) * (-1);
			} else
				inputFile = args[indexArgs];

		}
		try {
			br1 = new BufferedReader(new FileReader(inputFile));
			br2 = new BufferedReader(new FileReader(inputFile));
			for (int nLines = 0; nLines < numberOfLines; nLines++) {
				if (br1.readLine() == null) {
					break;
				}
			}
			currentLine = br1.readLine();
			while (currentLine != null) {
				currentLine = br1.readLine();
				br2.readLine();
			}
			br1.close();

			int readIndex = 0;
			while (readIndex++ < numberOfLines || isFollow) {

				if ((currentLine = br2.readLine()) != null) {
					System.out.println(currentLine);
					continue;
				}
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					break;
				}
			}
			br2.close();

		} catch (FileNotFoundException e1) {
			System.err.println("File not found");
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
}
