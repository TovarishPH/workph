package alura.java.tres.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Scanner;

public class TesteIO {

	public static void main(String[] args) throws IOException {
	
//		InputStream is = new FileInputStream("arquivo.txt");
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(isr);
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("arquivo.txt")));
		
//		String message = br.readLine();
//		
//		while(message !=  null){
//			System.out.println(message);
//			message = br.readLine();
//		}
//		
//		br.close();
		
//		InputStream is = new FileInputStream("arquivo.txt");
//		Scanner sc = new Scanner(System.in);
//		
//		OutputStream os = new FileOutputStream("saida.txt");
//		OutputStreamWriter osw = new OutputStreamWriter(os);
//		BufferedWriter bw = new BufferedWriter(osw);
//		
//		while(sc.hasNextLine()){
//			String frase = sc.nextLine();
//			bw.write(frase);
//			bw.newLine();
//			bw.flush();
//		}
//		
//		bw.close();
//		sc.close();
		
		//Maneira dois
		InputStream is = new FileInputStream("arquivo.txt");
		Scanner sc = new Scanner(is).useDelimiter("/");
		PrintStream ps = new PrintStream(new FileOutputStream("saida2.txt"));
		
		while (sc.hasNextLine()) {
			ps.println(sc.nextLine());
		}
		
		ps.close();
		sc.close();
	}
}
