package se.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * �û����ĵ���ʵ����
 *
 */
public class Area implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4914455689760380387L;
	/**
	 * ����id
	 */
	private String id;
	/**
	 * ��������
	 */
	private String areaName;
	/**
	 * ����ʵ��λ��
	 */
	private String areaLocation;
	/**
	 * ��ע
	 */
	private String remark;
	/**
	 * ��������ID
	 */
	private String parentId;
	/**
	 * ���Ӽ���ϵ�ṹ�����磺ȫ��id_�Ϻ�id_���id��
	 */
	private String levelCode;
	/**
	 * �õ�������к�
	 */
	private int sno = 0;
	/**
	 * user����
	 */
	private List<User> userList = new ArrayList<User>();
	/**
	 * ��һ�����򣨹���Ƶ��Ŀʹ�ã�
	 */
	private List<Area> childAreaList = new ArrayList<Area>();

	/** default constructor */
	public Area(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaLocation() {
		return areaLocation;
	}

	public void setAreaLocation(String areaLocation) {
		this.areaLocation = areaLocation;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	/**
	 * @return the childAreaList
	 */
	public List<Area> getChildAreaList() {
		return childAreaList;
	}

	/**
	 * @param childAreaList the childAreaList to set
	 */
	public void setChildAreaList(List<Area> childAreaList) {
		this.childAreaList = childAreaList;
	}
}