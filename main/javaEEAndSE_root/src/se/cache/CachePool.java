package se.cache;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * �����
 * 
 * @author Administrator
 */
public class CachePool implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3907455255499625136L;
	// �����Ψһʵ��
	private static CachePool instance;
	// ����Map
	private static Map<String, Object> cacheItems;

	private CachePool() {
		cacheItems = new HashMap<String, Object>();
	}

	/**
	 * ��ȡΨһ��ʵ��
	 * 
	 * @return instance
	 */
	public synchronized static CachePool getInstance() {
		if (instance == null) {
			instance = new CachePool();
		}
		return instance;
	}

	/**
	 * ������е�Item����
	 */
	public synchronized void clearAllItems() {
		cacheItems.clear();
	}

	/**
	 * ��ȡ����ʵ��
	 * 
	 * @param name
	 *            ��������
	 * @return ����ʵ��
	 */
	public synchronized Object getCacheItem(String name) {
		if (!cacheItems.containsKey(name)) {
			return null;
		}
		CacheItem cacheItem = (CacheItem) cacheItems.get(name);
		if (cacheItem.isExpired()) {
			return null;
		}
		return cacheItem.getEntity();
	}

	/**
	 * ��Ż�����Ϣ
	 * 
	 * @param name
	 *            ����
	 * @param obj
	 *            ʵ������
	 * @param expires
	 *            ��ʱʱ��
	 */
	public synchronized void putCacheItem(String name, Object obj, long expires) {
		// �жϸö����Ƿ����ڻ���أ�����ֱ��put
		if (!cacheItems.containsKey(name)) {
			cacheItems.put(name, new CacheItem(obj, expires));
		}
		// ��ȡ������ж��󣬸��¶�����Ϣ
		CacheItem cacheItem = (CacheItem) cacheItems.get(name);
		cacheItem.setCreateTime(new Date());
		cacheItem.setEntity(obj);
		cacheItem.setExpireTime(expires);
	}

	/**
	 * �Ƴ���������
	 * 
	 * @param name
	 */
	public synchronized void removeCacheItem(String name) {
		if (!cacheItems.containsKey(name)) {
			return;
		}
		cacheItems.remove(name);
	}

	/**
	 * ��ȡ�������ݵ�����
	 * 
	 * @return
	 */
	public int getSize() {
		return cacheItems.size();
	}
}
