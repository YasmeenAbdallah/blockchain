package blockChain;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

public class Main {
	 
	 
		
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		File data=new File("data.txt");
		File com=new File("com.txt");
		File decom=new File("decom.txt");
		TheChain obj=new TheChain();
		 //com.delete();
		
		if(data.exists()){
			System.out.println("exists");
			//obj.read_from_file(data);
	
			obj.add(data);
		}
		else{
			System.out.println("error");
		}
		
		

	}

}
