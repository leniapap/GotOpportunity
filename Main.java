import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static Administrator data = new Administrator();
	public static File f=new File("file.c");
	
	public static void main(String[] args) {
		
		//anaktisi dedomenon
		try {
			FileInputStream fins = new FileInputStream(f);
			ObjectInputStream dins = new ObjectInputStream(fins);
			 data = (Administrator)dins.readObject();
			 dins.close();
			 fins.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		new MainFrame();
	
	}
}
