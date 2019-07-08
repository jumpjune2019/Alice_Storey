import java.io.*;

public class compare {
	private static final String FILENAME1 = "apples.txt", FILENAME2 = "oranges.txt";

	public static void main(String[] args) {
		FileInputStream file1, file2;
		int size1=0, size2=0;
		boolean filesmatch = true;
		// TODO Auto-generated method stub
		try {
			file1=new FileInputStream(FILENAME1);
			file2=new FileInputStream(FILENAME2);
			
			int ch1=0, ch2=0;
	        while(ch1 != -1 || ch2 != -1) {
	        	if (ch1 != -1) {
	        		size1++;
	        		ch1=file1.read();
	        	}
	        	if (ch2 != -1) {
	        		size2++;
	        		ch2=file2.read();
	        	}
	        	if (filesmatch && ch1 != ch2) {
	        		filesmatch = false;
	        	}
	        	
	        }
	        
	        file1.close();
	        file2.close();
		}
		catch (FileNotFoundException e) {
			System.out.printf("File Not Found Exception: %s\nProgram terminating.\n", e); 
			return;
		}
		catch (IOException e) {
			System.out.printf("IO Error: %s\nProgram terminating.\n", e); 
			return;
		}
		
		System.out.printf("%s and %s:\n",FILENAME1, FILENAME2);
		if (filesmatch) {
			System.out.printf("identical content\ncharacter length for both: %d\n", size1);
		}
		else {
			System.out.printf("different content\ncharacter length for %s: %d\ncharacter length for %s: %d\n", FILENAME1, size1, FILENAME2, size2);
		}

	}

}
