package se.po;

import java.io.Serializable;

/**
 * Ȩ��
 *
 */
public class AbilityResource implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8993694707449397789L;
	/**
	 * Ȩ��ID
	 */
	private String resourceId;
	/**
	 * Ȩ������
	 */
	private String resourceName;
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
}
