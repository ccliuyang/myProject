package ee.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import ee.model.ResultMsgModel;

public class DataWrapper {
	/**
	 * ת����json��ʽ
	 * 
	 * @param obj
	 */
	public static void putJson(Object obj, HttpServletResponse resp) {
		String json = JSON.toJSONString(obj,
				SerializerFeature.DisableCircularReferenceDetect);
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter out = null;
		try {
			out = resp.getWriter();
			out.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testJsonDate() {
		ResultMsgModel msg = new ResultMsgModel();
		msg.setMsg("hello,���");
		msg.setSuccess(true);
		msg.setObj(new Date());
		// �������ֵ
		System.out.println(JSON.toJSONString(msg));
		// Ĭ�ϸ�ʽΪyyyy-MM-dd HH:mm:ss
		System.out.println(JSON.toJSONString(msg,
				SerializerFeature.WriteDateUseDateFormat));
		// �����Զ����ʽ�������
		System.out.println(JSON.toJSONStringWithDateFormat(msg, "yyyy-MM-dd",
				SerializerFeature.WriteDateUseDateFormat));
	}
}
