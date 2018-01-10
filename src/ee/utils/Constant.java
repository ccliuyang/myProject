package ee.utils;

import java.io.File;
import java.net.URL;


/**
 * 
 * @author Administrator
 * 
 */
public class Constant {

	/**
	 * ����Ŀ¼
	 */
	public final static String PROJECT_DIR = Constant.getProjectDir();
	
	
	/**
	 * ���ܣ��õ�����Ŀ¼
	 * 
	 * @return String ����Ŀ¼
	 */
	public static String getProjectDir() {
		String filePath = Constant.class.getProtectionDomain().getCodeSource()
				.getLocation().getPath();
		if (filePath.indexOf("WEB-INF") > 0) {
			int index = isWinSys() ? 1 : 0;
			filePath = filePath.substring(index,
					filePath.indexOf("WEB-INF/classes"));
		}
		return filePath;
	}

	/**
	 * �Ƿ�ΪWinϵͳ
	 * 
	 * @return boolean
	 */
	public static boolean isWinSys() {
		boolean isWin = false;
		if (System.getProperty("os.name").toUpperCase().startsWith("WINDOWS")) {
			isWin = true;
		}
		return isWin;
	}

	/**
	 * ��ȡ����ǰ��Ŀ��lib
	 * 
	 * @return String
	 */
	public static String getLibPath() {
		String classPath = new Constant().getClass().getResource("").toString();
		int n = classPath.indexOf("classes");
		String webInfPath = classPath.substring(classPath.indexOf("/"), n);
		return webInfPath.substring(1, webInfPath.length()) + "lib\\HK";
	}

	/**
	 * ��ȡ����ǰ��Ŀ��Ŀ¼
	 */
	public static String getPicturePath() {
		 ClassLoader classLoader = Thread.currentThread()  
			        .getContextClassLoader();  
			if (classLoader == null) {  
			    classLoader = ClassLoader.getSystemClassLoader();  
			}
		URL url = classLoader.getResource("");
		String classPath = url.getPath() + "/";
		File rootFile = new File(classPath);
		String webRoot_path = rootFile.getParent() +"/";
		File webInfoDir = new File(webRoot_path);
		return webInfoDir.getParent() + "/";
	}
}
