import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Exercise5 {
	public static void processCLArguments(String[] args){
		if (args.length < 2)
			System.out.println("Usage: java Exercise5 inputFile outputFile");
		else{
			System.out.println("Input will be read from: " + args[0]);
			System.out.println("Output will be written into: " + args[1]);
		}
	}
	public static void processInputOutputFiles(String[] args){
		String inputFileName = args[0];
		String outputFileName = args[1];
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		String line;
		String [] splitedLine;
		try { 
			// create stream buffer
//			System.out.println(inputFileName);
			bufferedReader = new BufferedReader(new FileReader(inputFileName));
			bufferedWriter = new BufferedWriter(new FileWriter(outputFileName));
			PrintWriter textPrintStream = new PrintWriter(bufferedWriter);
			int lineNum = 1; // line number = student number
			while ((line=bufferedReader.readLine()) != null) {
				splitedLine = line.split(",");
				System.out.printf("Student #: %d %s\n", lineNum, line);
				textPrintStream.printf("Student #%d is: \" %s \" whose raw scores are: ", lineNum++, splitedLine[0]);
				for(int i=1;i<splitedLine.length;i++)
					textPrintStream.print(splitedLine[i] + ':');
				textPrintStream.println();
			}
			bufferedReader.close();
			textPrintStream.close();
		}
		catch (Exception e) {
		System.out.println("The file input_file.txt is not available in default folder\n");
		//e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		processCLArguments(args);
		if (args.length >= 2)
			processInputOutputFiles(args);
	}

}
