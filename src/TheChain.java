import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class TheChain {
    static int counter=0;
    //int counter=0;
	ArrayList<block>chain=new ArrayList<block>();
	Scanner in=new Scanner(System.in);
	
	public void add() throws UnsupportedEncodingException, NoSuchAlgorithmException{
	 block obj=new block("hayyam","E5DAE2223B00361A396177A9CB410FF61F20015AD",counter);
	counter++;
	String prev=obj.proof_of_work();
	while(true){
		System.out.println("enter the info and 0 for stop entering");
		System.out.println("enter the message");
		String message="";
		message+=in.nextLine();
		if(message.equals("0")){
			break;
		}
		 obj=new block(message,prev,counter);
		 prev=obj.proof_of_work();
		 for(int i=0;i<chain.size();i++){
			 if(prev.equals(chain.get(i).prev_hash)){
				 System.out.println("there is aprobleme we couldn't add thos block");
			     break;
			 }
			 }
		 chain.add(new block(message,prev,counter));
		 counter++;
		
	
		
		
	}
	for(int i=0;i<chain.size();i++){
		System.out.println("the chain-->"+chain.get(i).prev_hash);
	}
    

}
}