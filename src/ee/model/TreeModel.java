package ee.model;

import java.util.List;
import java.util.Map;

public class TreeModel {
	/*
	 * �ڵ�� id�������ڼ���Զ�����ݺ���Ҫ��
	 */
	private String id;
	/*
	 * Ҫ��ʾ�Ľڵ��ı���
	 */
	private String text;
	/*
	 * �ڵ�״̬��'open' �� 'closed'��Ĭ���� 'open'��������Ϊ 'closed' ʱ���ýڵ����ӽڵ㣬���ҽ���Զ��վ��������ǡ�
	 */
	private String state;
	/*
	 * ָʾ�ڵ��Ƿ�ѡ�С�
	 */
	private boolean checked;
	/*
	 * ��һ���ڵ���ӵ��Զ������ԡ�
	 */
	private Map<String, Object> attributes;
	/*
	 * ������һЩ�ӽڵ�Ľڵ����顣
	 */
	private List<TreeModel> children;
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}
	/**
	 * @param checked the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	/**
	 * @return the attributes 
	 */
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	/**
	 * @return the children
	 */
	public List<TreeModel> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(List<TreeModel> children) {
		this.children = children;
	}
	
	
}
