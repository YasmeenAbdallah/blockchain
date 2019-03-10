package blockChain;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.DatatypeConverter;

public class block {
int index;
String time;
String cur_hash;
String prev_hash;
String message;

	 block(String data,String previousHash,int ndx ,String cur) {

	        message = data;
	        index=ndx;
            cur_hash=cur;
	        prev_hash= previousHash ;

	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	        LocalDateTime now = LocalDateTime.now();  
	       // System.out.println(dtf.format(now));  
	        time= dtf.format(now);
	        
	
}
	 public String collect() {
		  cur_hash=index+time+prev_hash+message;
		 
		 return cur_hash ;
	 }

	 
	    public String sha256(String info) throws UnsupportedEncodingException, NoSuchAlgorithmException {
	    	MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(info.getBytes("UTF-8"));
			String s = DatatypeConverter.printHexBinary(hash);
	        //boolean flag=true;
			int counter=0;
			for(int i=s.length()-1;i>s.length()-4;i--) {
				  
				   if(s.charAt(i)=='0') {
					   counter++;
					 
					   if(counter==3) {
						   
							
							   return s;
				      }
				   
					  
					 
					   
				   }
//				   else{
//					   System.out.println(s);
//				   }
				  
		                    	
			}
			return "-1";
	    }
	    
	    
	    public String toHex(String arg) {
	        return String.format("%040x", new BigInteger(1, arg.getBytes(/*YOUR_CHARSET?*/)));
	    }
	    
	    public String proof_of_work() throws UnsupportedEncodingException, NoSuchAlgorithmException {
	    String proof=collect();
	    String hash_result="";
	  // String hashResult=  sha256(proof);
	    while(true){
	    	proof=proof+"1";
	    hash_result= sha256(proof);
	   if(!hash_result.equals("-1")){
		  // System.out.println("proofed-->"+hash_result);
		   return hash_result;
		  
		  
		   }
	  
	    }}
	
	    
	 }

