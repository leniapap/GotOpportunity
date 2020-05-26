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
		
		//�������� ���������
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
		
		//������� ���������
		try {
			FileOutputStream fouts = new FileOutputStream(f);
			ObjectOutputStream douts = new ObjectOutputStream(fouts);
			douts.writeObject(data);
			fouts.close();
			douts.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
