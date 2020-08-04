import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Text {
  public static void main(String[] args) {
	  
	  try {
	  File file = new File("TestarApa3.txt");
      
		  if (!file.exists()) {
			  file.createNewFile();
		  }
		  
		  PrintWriter pw = new PrintWriter(file);
		  pw.println("This is a test");
		  pw.close();
		  System.out.println("done");
	  }
	  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error");
	  }
  }
}