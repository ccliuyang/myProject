package extension.pdf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
public class JxlExcelUtil {
	/**
	 * ����EXCEL�б�
	 * @param templateFileName
	 * @param excelPath
	 * @param beanParams
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public String exportFile(String templateFileName, String excelPath, Map<String, Object> beanParams)throws InvalidFormatException, IOException {
		HSSFWorkbook workBook = createExcel(templateFileName,
				beanParams);
		OutputStream ouputStream = new  FileOutputStream(excelPath);
		workBook.write(ouputStream);
		ouputStream.flush();
		ouputStream.close();
		return excelPath;
	}
	
	/**
	 * ����ģ������Excel�ļ�.
	 * @param templateFileName ģ���ļ�.
	 * @param list ģ���д�ŵ�����.
	 * @param resultFileName ���ɵ��ļ�.
	 * @throws InvalidFormatException 
	 */
	public HSSFWorkbook createExcel(String templateFileName, Map<String,Object> beanParams) throws InvalidFormatException{
		//����XLSTransformer����
		XLSTransformer transformer = new XLSTransformer();
		//�õ�ģ���ļ�·��
		String srcFilePath =  templateFileName;
		try {
			//����Excel�ļ�
			InputStream in = new FileInputStream(srcFilePath);
			HSSFWorkbook workBook = null;
			workBook = (HSSFWorkbook) transformer.transformXLS(in, beanParams);
			return workBook;
		} catch (ParsePropertyException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
