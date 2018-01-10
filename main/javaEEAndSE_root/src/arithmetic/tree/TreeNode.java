package arithmetic.tree;

public class TreeNode {
	// ����ڵ�����ԣ������Ǳ����еģ���Ҳ���Ը�����ѽ�������
	private TreeNode parent; // ��һ���ڵ㣨���ڵ㣩
	private TreeNode childLeft; // �ӽڵ�Ϊ��ڵ�
	private TreeNode childRight; // �ӽڵ��Ϊ�ҽڵ�
	private int value;// �ýڵ��Ȩֵ����Ҫ�Ǹ�������������

	// ���ع��췽�����ڴ�������ʱ���봫��value����
	public TreeNode(int value) {
		this.value = value;
	}

	// ������һ�����ڵ�ķ���(����һ���ڵ㣩
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	// /�����һ���ڵ�ķ���
	public TreeNode getParent() {
		return parent;
	}

	// �����ӽڵ㣨��ڵ㣩�ķ���
	public void setChildLeft(TreeNode childLeft) {
		this.childLeft = childLeft;
	}

	// ����ӽڵ㣨��ڵ㣩�ķ���
	public TreeNode getChildLeft() {
		return childLeft;
	}

	// �����ӽڵ㣨��ڵ㣩�ķ���
	public void setChildRight(TreeNode childRight) {
		this.childRight = childRight;
	}

	// ����ӽڵ㣨��ڵ㣩�ķ���
	public TreeNode getChildRight() {
		return childRight;
	}

	// ����Ȩֵ�ķ���
	public void setValue(int value) {
		this.value = value;
	}

	// ���Ȩֵ�ķ���
	public int getValue() {
		return value;
	}
}
