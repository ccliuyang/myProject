package se.po;

import java.io.Serializable;
import java.util.List;

/**
 * ��ɫ
 *
 */
public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4720423624865528649L;
	/**
	 * ��ɫID
	 */
	private String roleId;
	/**
	 * ��ɫ����
	 */
	private String roleName;
	/**
	 * Ȩ���б�
	 */
	private List<AbilityResource> abilityResources;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<AbilityResource> getAbilityResources() {
		return abilityResources;
	}
	public void setAbilityResources(List<AbilityResource> abilityResources) {
		this.abilityResources = abilityResources;
	}
	
}
