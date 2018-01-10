package extension.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.junit.Test;

import se.util.StringUtil;

/**
 * func:PDF������صĹ�����. desc:���Խ�jrxml�ļ�ת��jasper����pdf�ļ�. depend JAR:
 * itext-2.1.7.jar; groovy-all-1.5.5.jar; iTextAsian-2.1.jar;
 * commons-digester-2.1.jar jarperreports-3.5.0.jar;
 * commons-collections-3.2.1.jar jaxen-1.1-beta-4.jar; jxl-2.6.jar ...
 * ������ٶȣ�����Ҳ�ٶȻ����ǰ汾�����ݲŻ����. ireport��5.6.0
 * ������jrxml�ļ������ݣ���Ҫ����uuid��splittype,�����ҽ�ֱ�������������ʵ��ת��. ��������ɾ������ָ����groovy ɾ��uuid
 * ����splittype. author:weifeng date:2017-08-16
 */
public class JasperUtil {
	public static final String JRXML_SUFFIX = ".jrxml";
	public static final String JASPER_SUFFIX = ".jasper";
	public static final String PDF_SUFFIX = ".pdf";

	/**
	 * ��jsxmlת���� jasper
	 * 
	 * @param jrxmlSourcePath
	 * @param jrxmlDestSourcePath
	 */
	public static boolean jsxmlToJasper(String jrxmlSourcePath,
			String jrxmlDestSourcePath) {
		boolean flag = false;
		if (jrxmlSourcePath == null
				|| !jrxmlSourcePath.endsWith(JasperUtil.JRXML_SUFFIX)) {
			return flag;
		}
		if (jrxmlDestSourcePath == null) {
			jrxmlDestSourcePath = jrxmlSourcePath.substring(0,
					jrxmlSourcePath.length() - 6)
					+ JasperUtil.JASPER_SUFFIX;
		}
		try {
			JasperCompileManager.compileReportToFile(jrxmlSourcePath,
					jrxmlDestSourcePath);
			flag = true;
		} catch (JRException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * ��ȡ����ģ�����
	 * 
	 * @param templateFileName
	 *            ����ģ���ļ���
	 * @return jasperReport
	 * @throws Exception
	 *             Exception
	 */
	private static JasperReport getReport(String templateFileName) {
		String suffixName = templateFileName.substring(templateFileName
				.lastIndexOf('.'));
		JasperReport report = null;
		try {
			if (".jrxml".equalsIgnoreCase(suffixName)) {
				report = JasperCompileManager.compileReport(templateFileName);
			} else if (".jasper".equalsIgnoreCase(suffixName)) {
				report = (JasperReport) JRLoader.loadObject(templateFileName);
			} else {
				throw new Exception("wrong report template file type exception");
			}
		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return report;
	}

	/**
	 * ȥ��������������ҵı߾ಢ�����ñ���ֻ��һҳ
	 * 
	 * @param report
	 *            jasperReport
	 * @throws Exception
	 *             exception
	 */
	private static void clearReportMarginAndPage(JasperReport report)
			throws Exception {
		Field margin = JRBaseReport.class.getDeclaredField("leftMargin");
		margin.setAccessible(true);
		margin.setInt(report, 0);

		margin = JRBaseReport.class.getDeclaredField("rightMargin");
		margin.setAccessible(true);
		margin.setInt(report, 0);

		margin = JRBaseReport.class.getDeclaredField("bottomMargin");
		margin.setAccessible(true);
		margin.setInt(report, 0);

		margin = JRBaseReport.class.getDeclaredField("topMargin");
		margin.setAccessible(true);
		margin.setInt(report, 0);

		Field pageHeight = JRBaseReport.class.getDeclaredField("pageHeight");
		pageHeight.setAccessible(true);
		pageHeight.setInt(report, Integer.MAX_VALUE);
	}

	/**
	 * ��ȡJasperPrint����
	 * 
	 * @param templateFileName
	 *            ģ���ļ���
	 * @param params
	 *            ��ӡ����
	 * @param dataSource
	 *            ��������Դ
	 * @param isClearMargin
	 *            �Ƿ�����߾�
	 * @return JasperPrint
	 * @throws Exception
	 *             Exception
	 */
	private static JasperPrint getJasperPrint(String templateFileName,
			Map<String, Object> params, JRDataSource dataSource,
			boolean isClearMargin) throws Exception {
		JasperReport report = getReport(templateFileName);
		if (isClearMargin) {
			clearReportMarginAndPage(report);
		}
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, params,
				dataSource);
		return jasperPrint;
	}

	/**
	 * ��ȡJasperPrint����
	 * 
	 * @param templateFileName
	 *            ģ���ļ���
	 * @param params
	 *            ��ӡ����
	 * @param dataSource
	 *            ��������Դ
	 * @param isClearMargin
	 *            �Ƿ�����߾�
	 * @return JasperPrint
	 * @throws Exception
	 *             Exception
	 */
	private static JasperPrint getJasperPrint(String templateFileName,
			Map<String, Object> params, Connection conn, boolean isClearMargin)
			throws Exception {
		JasperReport report = getReport(templateFileName);
		if (isClearMargin) {
			clearReportMarginAndPage(report);
		}
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, params,
				conn);
		return jasperPrint;
	}

	/**
	 * ��ӡPDF�ļ��������
	 * 
	 * @param templateFileName
	 *            ģ���ļ���
	 * @param params
	 *            ��ӡ����
	 * @param dataSource
	 *            ��������Դ
	 * @param out
	 *            OutputStream
	 * @throws Exception
	 *             Exception
	 */
	public static void printPdfToStream(String templateFileName,
			Map<String, Object> params, JRDataSource dataSource,
			OutputStream out) throws Exception {
		JasperPrint print = getJasperPrint(templateFileName, params,
				dataSource, Boolean.FALSE);
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
		exporter.exportReport();
		out.flush();
	}

	/**
	 * ��ӡPDF�ļ�������� // ʹ��JRPdfExproter����������pdf
	 * 
	 * @param templateFileName
	 *            ģ���ļ���
	 * @param params
	 *            ��ӡ����
	 * @param dataSource
	 *            ��������Դ
	 * @param out
	 *            OutputStream
	 * @throws Exception
	 *             Exception
	 */
	public static void printPdfToStream(JasperPrint print, OutputStream out)
			throws Exception {
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
		exporter.exportReport();
		out.flush();
	}

	/***
	 * ��ӡEXCEL�ļ��������
	 * 
	 * @param templateFileName
	 *            ģ���ļ���
	 * @param params
	 *            ��ӡ����
	 * @param dataSource
	 *            ��������Դ
	 * @param out
	 *            OutputStream
	 * @throws Exception
	 *             Exception
	 */
	public static void printExcelToStream(JasperPrint print, OutputStream out)
			throws Exception {
		JRXlsExporter exporter = new JRXlsExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
				Boolean.FALSE);
		exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
				Boolean.TRUE);
		exporter.setParameter(
				JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, true);
		exporter.exportReport();
		out.flush();
	}

	@Test
	public void createJasper() {
		String  filePath="resource/report/patrolreport.jrxml";
		//���jrxml�ļ�������
	 //  	StringUtil.replaceFile(filePath,"(splitType=\"[a-zA-Z]{1,50}\")|(language=\"[a-zA-Z]{1,20}\")|(uuid=\"[0-9a-zA-Z\\-]{1,60}\")","");
		jsxmlToJasper(filePath, null);
	}
	@Test
	public void encodingJrxml(){
		String  filePath="resource/report/patrolreport.jrxml";
		//���jrxml�ļ�������
	   	StringUtil.replaceFile(filePath,"(splitType=\"[a-zA-Z]{1,50}\")|(language=\"[a-zA-Z]{1,20}\")|(uuid=\"[0-9a-zA-Z\\-]{1,60}\")","");
	}
	/**
	 * ����jasper�Ƿ����
	 */
	@Test
	public void testJasper() {
		String jasperPath = "resource/report/report1.jasper";
		JasperUtil.getReport(jasperPath);
	}

	/**
	 * demo���� ��jrxml�ļ�ת����pdf
	 */
	@Test
	public void createPdf() {
		createJasper();
		Connection conn = null;
		try {
			File file = new File("resource/report/report1.jrxml");// ���ת�����ˣ�������groovy
			if (file.exists()) {
				// �����Ҫ����JasperReport�Ĳ���
				HashMap<String, Object> parameter = new HashMap<String, Object>();
				HashMap<String, Object> basicinfo = new HashMap<String, Object>();
				basicinfo.put("name", "hello,κ��");
				parameter.put("basicinfo", basicinfo);
				// ��ȡ��������
				conn = DbUtil.getConnection();
				// �����ݺͲ�����䵽JasperReport�� ��conn��Ϊ����Դ
				JasperPrint jp = JasperUtil.getJasperPrint(
						file.getAbsolutePath(), parameter, conn, false);
				// ���·��
				String pdfFilePath = file.getAbsolutePath().substring(0,
						file.getAbsolutePath().lastIndexOf("."))
						+ JasperUtil.PDF_SUFFIX;
				// ����Ϊpdf�ļ�
				JasperExportManager.exportReportToPdfFile(jp, pdfFilePath);
			//	 JasperUtil.printExcelToStream(jp, new FileOutputStream("resource/report/1.xls"));//��Ч
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
