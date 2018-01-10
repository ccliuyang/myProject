package arithmetic.tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HuffmanTree {
	public static List<TreeNode> list = new ArrayList<TreeNode>();

	// ð�ݷ�������������򣬼���Ȩֵ��������,����С�����������ͬʱ��װ�ɽڵ㣬װ������У�list�Ǵ�����һ�����ж���
	public void sortValue(int[] array) {
		// ð������Ĺ���
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {// �Ƚϴ�С
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		for(int i=0;i<array.length;i++){
			 //�����ڵ���󣬲�����װ�������   
			  TreeNode node=new TreeNode(array[i]);   
			  list.add(node);   
		}
		
	}

	// ���ɹ��������ķ���
	public void createTree(int[] array) {
		// ����sortValue��������Ҷ�ӽڵ���з�װ
		this.sortValue(array);
		// ���ݹ����������ԭ��������������
		while (list.size() > 1) {// �ڵ�������һʱ���Ž������²���
			TreeNode leftnode = list.remove(0);// �����ڵ�
			TreeNode rightnode = list.remove(0);// ����ҽڵ�
			// �����������ڵ㣬�������ǵĸ��ڵ�
			int value = leftnode.getValue() + rightnode.getValue();
			TreeNode parentnode = new TreeNode(value);
			// ���������ڵ㽨����Ӧ�Ĺ�ϵ
			leftnode.setParent(parentnode);
			rightnode.setParent(parentnode);
			parentnode.setChildLeft(leftnode);
			parentnode.setChildRight(rightnode);
			// ���������ڵ�ĸ��ڵ�װ������У��������ǽ�������
			this.sortAgain(parentnode);
		}
		
	}

	public void sortAgain(TreeNode newnode) {
		// ��Ϊ����Ľڵ��Ѿ��ź����ˣ�����ֻ�ǽ��½ڵ�����Ӧ��λ�þͿ�����
		int size = list.size();
		if (size > 0) {// ����������һ���ڵ���ܽ��бȽ�
			if (newnode.getValue() > list.get(size - 1).getValue()) {// ���Ҫ����Ľڵ��Ȩֵ���ڶ��������һ���ڵ��Ȩֵ����ŵ������
				list.add(newnode);
			} else {// �����ȥ���бȽ�
				for (int i = 0; i < list.size(); i++) {
					TreeNode node = list.get(i);// ��˳��õ��ڵ�
					if (newnode.getValue() <= node.getValue()) {// �Ƚ����ǵ�Ȩֵ
						list.add(i, newnode);// ���½ڵ���ӵ�ָ����λ��
						break;// ����ѭ��
					}
				}
			}
		} else {// ����ֱ�Ӽӽ�ȥ
			list.add(newnode);
		}
	}
	@Test
	public void test1(){
		int[] ARRAY  = {12,20,5,16,15,1,30,45,23,9};
		createTree(ARRAY);
		if(list.size()>0){
			TreeNode root  = list.get(0);
			System.out.println(root);
		}
		
	}
}
