import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class MassEdit {

	public static String dir = "C:\\Users\\jstnm\\Documents\\Paradox Interactive\\Europa Universalis IV\\mod\\the-sqwad-mod\\sqwad_mod\\history\\provinces";

	public static void main(String[] args) throws IOException {
		
		File directoryPath = new File(dir);
		File[] files = directoryPath.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			String newFileName = file.getName();
			newFileName = newFileName.replaceAll(" Addition", "");
			File temp = new File(dir + "\\" + newFileName);
			
			System.out.println(file + " -> " + temp);
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
			
			String line = reader.readLine();
			while (line != null) {
				
				System.out.println("[BEFORE] " + line);
				
				line = line.replaceAll("1444.11.11", "1444.11.10");
				line = line.replaceAll("1444.11.12", "1444.11.11");
				
				writer.write(line);
				writer.newLine();
				
				System.out.println("[AFTER ] " + line);
				System.out.println();
				
				line = reader.readLine();
			}
			
			reader.close();
			writer.close();
		}
	}

}