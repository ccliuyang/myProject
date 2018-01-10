package ee.path;

import java.io.File;
import java.net.URL;

/**
 * 
 * 
 * ���ܣ���������
 * 
 */
public final class PathConstant {

	/**
	 * ����Ŀ¼
	 */
	public final static String PROJECT_DIR = PathConstant.getProjectDir();
	/**
	 * ·��Ŀ¼
	 */
	public final static String PATH_DIR = PROJECT_DIR + "path/";
	/**
	 * ·��ID
	 */
	public final static String PATH_ID = "pathid";
	/**
	 * �ؼ���
	 */
	public final static String KEYWORD = "keyword";
	/**
	 * DWR ��ʼ��¼��
	 */
	public static final String DWR_START = "start";
	/**
	 * DWR ÿҳ��¼��
	 */
	public static final String DWR_LIMIT = "limit";
	/**
	 * �û��ϴ��ļ����-Ŀ¼
	 */
	public final static String XLS_PATH = PATH_DIR + "uploadFile/";
	/**
	 * TOMCAT �¼�������·��
	 */
	public final static String TOMCAT_XLS_PATH = "path/uploadFile/";
	/**
	 * ���ݱ���-Ŀ¼
	 */
	public final static String DATABACKUP_DIR = PROJECT_DIR + "dataBackup/";
	/**
	 * ���ݻ�ԭ�ļ��ϴ���ʱĿ¼
	 */
	public static final String DATA_RESTORE_TMP_PATH = PROJECT_DIR
			+ "dataRestoreTmp/";

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
	 * ���ܣ��õ�����Ŀ¼
	 * 
	 * @return String ����Ŀ¼
	 */
	public static String getProjectDir() {
		String filePath = PathConstant.class.getProtectionDomain()
				.getCodeSource().getLocation().getPath();
		if (filePath.indexOf("WEB-INF") > 0) {
			int index = isWinSys() ? 1 : 0;
			filePath = filePath.substring(index,
					filePath.indexOf("WEB-INF/classes"));
		}
		return filePath;
	}

	/**
	 * �ж�webapps �����޸�Ŀ¼
	 * 
	 * @param directory
	 * @return boolean
	 */
	public static boolean isDirectory(String directory) {
		boolean isDirectory = false;
		String headpath = new PathConstant().getClass().getResource("")
				.toString();
		if (headpath.indexOf("webapps") > 0) {
			headpath = headpath.substring(headpath.indexOf("/"),
					headpath.indexOf("webapps"));
			String path = headpath + "webapps/" + directory;
			File file = new File(path);
			if (!file.exists()) {
				isDirectory = false;
			} else {
				File[] files = file.listFiles();
				if (files != null && files.length > 0) {
					isDirectory = true;
				} else {
					isDirectory = false;
				}
			}
		}

		return isDirectory;
	}
	//��ȡ����·��
	public static String getRootPath() {
		 
		ClassLoader  cl = PathConstant.class.getClassLoader();
		URL url = cl.getResource("/");
		String classPath = url.getPath();
		String rootPath = "";
		// windows��
		if ("\\".equals(File.separator)) {
			rootPath = classPath.substring(1,
					classPath.indexOf("/WEB-INF/classes"));
			rootPath = rootPath.replace("/", "\\");
		}
		// linux��
		if ("/".equals(File.separator)) {
			rootPath = classPath.substring(0,
					classPath.indexOf("/WEB-INF/classes"));
			rootPath = rootPath.replace("\\", "/");
		}
		return rootPath;
	}
}
