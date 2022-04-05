package modernmjukvara;
import java.io.*;
import java.util.Scanner;

public class program{
	public static int[] data;
	public static void main(String[] args){
		data = new int[3];
		Scanner in = new Scanner(System.in);
		getData();
		boolean loop = true;
		while(loop){
			System.out.println("\n\nHur nöjd är du med din upplevelse?\nSkriv in en siffra:\n1 = inte nöjd\t2 = helt okej\t3 = nöjd\n");
			switch (in.nextLine()) {
				case "1":
					data[0] ++;
					System.out.println("Tack för din respons!");
					break;
				case "2":
					data[1] ++;
					System.out.println("Tack för din respons!");
					break;
				case "3":
					data[2] ++;
					System.out.println("Tack för din respons!");
					break;
				case "med":
					avrage();
					break;
				case "quit":
					loop = false;
					break;
				default:
					System.out.println("Ogiltigt command");
					break;
			}
		}
		putData();
		in.close();
	}
	public static void avrage(){
		double med = Double.valueOf(data[0] + data[1] * 2 + data[2] * 3)/Double.valueOf(data[0] + data[1] + data[2]);
		System.out.println("Resultat för medelvärdet av undersökningen: " + Math.round(med * 100.0) / 100.0);
	}
	public static int[] getData(){
		try {
			int i = 0;
			File myObj = new File("data.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
			  data[i++] = Integer.parseInt(myReader.nextLine());
			  System.out.println(data);
			}
			myReader.close();
		  } catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }
		return data;
	}
	public static void putData(){
		try {
			FileWriter myWriter = new FileWriter("data.txt");
			myWriter.write(data[0] + "\n" + data[1] + "\n" + data[2]);
			myWriter.close();
			System.out.println("Hejdå");
		  } catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }
	}
}
