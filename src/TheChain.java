package blockChain;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TheChain {
    static int counter=0;
    static int index_begin_from;//this the index hich start from when write on file to not repeat the data
    
    //int counter=0;
	ArrayList<block>chain=new ArrayList<block>();
	Scanner in=new Scanner(System.in);
	
	public void read_from_file(File read) throws FileNotFoundException{
		Scanner in=new Scanner(read);
		//in.useDelimiter("|");
		String prev = null,message=null,cur=null;
		int index=0;
		while(in.hasNext()){
	    index=in.nextInt();
	    prev=in.next();
	    message=in.next();
	    cur=in.next();
	 //   System.out.println(index+"  "+prev+"  "+message+" "+cur);
	  
	    	chain.add(new block(message,prev,index,cur));
	    	

	    	
	    	
	    }
	    
	    
		
	    
			 }
		
			 

	public void write_on_file(File write) throws IOException{
		
		for(int i=index_begin_from+1;i<chain.size();i++){
			//System.out.println("the chain-->"+chain.get(i).prev_hash);
			BufferedWriter out = new BufferedWriter(new FileWriter(write,true));
			PrintWriter print=new PrintWriter(out);
			print.println(chain.get(i).index+" "+chain.get(i).prev_hash+" "+chain.get(i).message+" "+chain.get(i).cur_hash);
		print.close();
		}
		
	}
		 
		
	
	
	
	
	
	public void add(File write) throws NoSuchAlgorithmException, IOException{
		
		
		read_from_file(write); 
		
		
		 block obj;
		 String cur = null;
		 String prev;
		 index_begin_from=chain.size()-1;
		 counter=chain.get(chain.size()-1).index;
			
		while (true){
		System.out.println("enter the info and 0 for stop entering");
		System.out.println("enter the message");
		String message="";
		message+=in.nextLine();
		if(message.equals("0")){
			break;
		}
		
		prev=chain.get(chain.size()-1).cur_hash;
	
		 System.out.println(index_begin_from);
		 obj=new block(message,prev,counter,"0");
		 cur=obj.proof_of_work();
		 for(int i=0;i<chain.size();i++){
			 if(cur.equals(chain.get(i).cur_hash)){
				 System.out.println("there is aprobleme we couldn't add thos block");
			     break;
			 }
			 }
		 counter++;
		// index_begin_from++;
		// System.out.println(index_begin_from);
	 	 chain.add(new block(message,prev,counter,cur));
	 	
	 	
		
		 }
		write_on_file(write);
		
	

		
	
	

}
}