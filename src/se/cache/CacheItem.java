package se.cache;

import java.util.Date;

/**
 * ����ʵ��
 * 
 */
public class CacheItem {
	// ��������ʱ��
	private Date createTime = new Date();
	// ��������ʱ��
	private long expireTime = 1;
	// ����ʵ��
	private Object entity;

	public CacheItem(Object obj, long expires) {
		this.entity = obj;
		this.expireTime = expires;
	}

	// �жϻ����Ƿ�ʱ
	public boolean isExpired() {
		return (expireTime != -1 && new Date().getTime() - createTime.getTime() > expireTime);
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(long expireTime) {
		this.expireTime = expireTime;
	}
}
