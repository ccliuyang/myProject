package extension.rmi;

import java.rmi.Naming;

public class HelloClient {
	 /**  
	    * ����Զ�̶��󲢵���Զ�̷���  
	    */  
	   public static void main(String[] argv)   
	   {   
	      try  
	      {   
	          
	          HelloInterface he = (HelloInterface)Naming.lookup("Hello"); 
	         //���Ҫ����һ̨������RMIע�����Ļ����ϲ���helloʵ��   
	         //HelloInterface hello = (HelloInterface)Naming.lookup("//192.168.1.105:1099/Hello");   
	            
	         //����Զ�̷���   
	         System.out.println(he.say());   
	      }   
	      catch (Exception e)   
	      {   
	         System.out.println("HelloClient exception: " + e);   
	      }   
	   }   
}
