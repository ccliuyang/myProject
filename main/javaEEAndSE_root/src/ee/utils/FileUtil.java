package ee.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import ee.model.ResultMsgModel;

/**
 * �ļ�������
 * @author CLWang
 *
 * @date2017-7-14����4:44:18
 */
public class FileUtil {
	  /** 
     * �½�Ŀ¼ 
     * @param folderPath String �� c:/fqf 
     * @return boolean 
     */ 
   public static void newFolder(String folderPath) { 
       try { 
           String filePath = folderPath; 
           filePath = filePath.toString(); 
           java.io.File myFilePath = new java.io.File(filePath); 
           if (!myFilePath.exists()) { 
               myFilePath.mkdir(); 
           } 
       } 
       catch (Exception e) { 
           e.printStackTrace(); 
       } 
   } 
   // ����Ŀ¼
	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {// �ж�Ŀ¼�Ƿ����
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {// ��β�Ƿ���"/"����
			destDirName = destDirName + File.separator;
			dir = new File(destDirName);
		}
		if (dir.mkdirs()) {// ����Ŀ��Ŀ¼
			return true;
		} else {
			return false;
		}
	}

   /** 
     * �½��ļ� 
     * @param filePathAndName String �ļ�·�������� ��c:/fqf.txt 
     * @param fileContent String �ļ����� 
     * @return boolean 
     */ 
   public static boolean newFile(String filePathAndName, String fileContent) { 
	   boolean flag =false;
       try { 
           String filePath = filePathAndName; 
           filePath = filePath.toString(); 
           File myFilePath = new File(filePath); 
           if (!myFilePath.exists()) { 
               myFilePath.createNewFile(); 
           } 
           FileWriter resultFile = new FileWriter(myFilePath); 
           PrintWriter myFile = new PrintWriter(resultFile); 
           String strContent = fileContent; 
           myFile.println(strContent); 
           resultFile.close(); 
           flag = true;
       } 
       catch (Exception e) { 
           e.printStackTrace(); 
       } 
       return flag;
   } 

   /** 
     * ɾ���ļ� 
     * @param filePathAndName String �ļ�·�������� ��c:/fqf.txt 
     * @param fileContent String 
     * @return boolean 
     */ 
   public static boolean delFile(String filePathAndName) { 
	   boolean flag = false;
       try { 
           String filePath = filePathAndName; 
           filePath = filePath.toString(); 
           java.io.File myDelFile = new java.io.File(filePath); 
           myDelFile.delete(); 
            flag = true;
       } 
       catch (Exception e) { 
           e.printStackTrace(); 
       } 
       return flag;
   } 

   /** 
     * ɾ���ļ��� 
     * @param filePathAndName String �ļ���·�������� ��c:/fqf 
     * @param fileContent String 
     * @return boolean 
     */ 
   public static void delFolder(String folderPath) { 
       try { 
           delAllFile(folderPath); //ɾ���������������� 
           String filePath = folderPath; 
           filePath = filePath.toString(); 
           java.io.File myFilePath = new java.io.File(filePath); 
           myFilePath.delete(); //ɾ�����ļ��� 

       } 
       catch (Exception e) { 
           e.printStackTrace(); 
       } 
   } 

   /** 
     * ɾ���ļ�������������ļ� 
     * @param path String �ļ���·�� �� c:/fqf 
     */ 
   public static void delAllFile(String path) { 
       File file = new File(path); 
       if (!file.exists()) { 
           return; 
       } 
       if (!file.isDirectory()) { 
           return; 
       } 
       String[] tempList = file.list(); 
       File temp = null; 
       for (int i = 0; i < tempList.length; i++) { 
           if (path.endsWith(File.separator)) { 
               temp = new File(path + tempList[i]); 
           } 
           else { 
               temp = new File(path + File.separator + tempList[i]); 
           } 
           if (temp.isFile()) { 
               temp.delete(); 
           } 
           if (temp.isDirectory()) { 
               delAllFile(path+"/"+ tempList[i]);//��ɾ���ļ���������ļ� 
               delFolder(path+"/"+ tempList[i]);//��ɾ�����ļ��� 
           } 
       } 
   } 

   /** 
     * ���Ƶ����ļ� 
     * @param oldPath String ԭ�ļ�·�� �磺c:/fqf.txt 
     * @param newPath String ���ƺ�·�� �磺f:/fqf.txt 
     * @return boolean 
     */ 
   public static void copyFile(String oldPath, String newPath) { 
       try { 
           int byteread = 0; 
           File oldfile = new File(oldPath); 
           if (oldfile.exists()) { //�ļ�����ʱ 
               InputStream inStream = new FileInputStream(oldPath); //����ԭ�ļ� 
               FileOutputStream fs = new FileOutputStream(newPath); 
               byte[] buffer = new byte[1444]; 
               while ( (byteread = inStream.read(buffer)) != -1) { 
                   fs.write(buffer, 0, byteread); 
               } 
               inStream.close(); 
               fs.close();
           } 
       } 
       catch (Exception e) { 
           e.printStackTrace(); 
       } 
   } 

   /** 
     * ���������ļ������� 
     * @param oldPath String ԭ�ļ�·�� �磺c:/fqf 
     * @param newPath String ���ƺ�·�� �磺f:/fqf/ff 
     * @return boolean 
     */ 
   public static void copyFolder(String oldPath, String newPath) { 

       try { 
           (new File(newPath)).mkdirs(); //����ļ��в����� �������ļ��� 
           File a=new File(oldPath); 
           String[] file=a.list(); 
           File temp=null; 
           for (int i = 0; i < file.length; i++) { 
               if(oldPath.endsWith(File.separator)){ 
                   temp=new File(oldPath+file[i]); 
               } 
               else{ 
                   temp=new File(oldPath+File.separator+file[i]); 
               } 

               if(temp.isFile()){ 
                   FileInputStream input = new FileInputStream(temp); 
                   FileOutputStream output = new FileOutputStream(newPath + "/" + 
                           (temp.getName()).toString()); 
                   byte[] b = new byte[1024 * 5]; 
                   int len; 
                   while ( (len = input.read(b)) != -1) { 
                       output.write(b, 0, len); 
                   } 
                   output.flush(); 
                   output.close(); 
                   input.close(); 
               } 
               if(temp.isDirectory()){//��������ļ��� 
                   copyFolder(oldPath+"/"+file[i],newPath+"/"+file[i]); 
               } 
           } 
       } 
       catch (Exception e) { 
           e.printStackTrace(); 
       } 
   } 

   /** 
     * �ƶ��ļ���ָ��Ŀ¼ 
     * @param oldPath String �磺c:/fqf.txt 
     * @param newPath String �磺d:/fqf.txt 
     */ 
   public static void moveFile(String oldPath, String newPath) { 
       copyFile(oldPath, newPath); 
       delFile(oldPath); 
   } 
   /**
    * �ļ��ϴ�
    */
   public void saveAreaLocationBG(){
	    HttpServletRequest request = null;
		request = ServletActionContext.getRequest();
		ResultMsgModel result = new ResultMsgModel();
		try {
			if(ServletFileUpload.isMultipartContent(request)){
			        FileItemFactory fileItemFactory = new DiskFileItemFactory();
					ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
			       try { 
					@SuppressWarnings("unchecked")
					List<FileItem> list = fileUpload.parseRequest(request);
					for (FileItem item : list) {
						// ���fileitem�з�װ������ͨ�����������
						if (item.isFormField()) {		
						} else {
							String fileName = item.getName();
							if(fileName != null && !fileName.trim().equals("")){
								File file = new File(fileName);
								String picName = file.getName();
								String stuffix = picName.substring(picName.lastIndexOf('.')+1);
								if(stuffix.toLowerCase().equals("jpg")  || stuffix.toLowerCase().equals("png")){
									    String filePath ="";
									    String name = filePath  + fileName;  
									    File fileDir = new File(filePath);
										if  (!fileDir .exists()  && !fileDir .isDirectory())      
										{       
										    fileDir .mkdir();    
										}  
										File fileTo = new File(name);
										if(!fileTo.exists())    
										{    
										   fileTo.createNewFile();    
										}  
										item.write(fileTo);
										//д��ɹ�
										result.setObj( filePath+fileName);
										result.setSuccess(true);
										result.setMsg("�ϴ��ɹ���");
									   //����ҵ��� 
								}
							}
						}
					}
				} catch (Exception e) {
					System.out.println("����"+e.toString());
					result.setSuccess(false);
					result.setMsg("�ϴ�ʧ�ܣ�");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		putJson(result);
	}
}

