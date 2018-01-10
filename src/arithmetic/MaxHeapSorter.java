package arithmetic;

import org.junit.Test;

public class MaxHeapSorter {
	static final int SIZE=10;
	/*
	 * ������������ɸ��ɸѡ�����ڵ�ǰ�ڵ�·����С��ֵ����ȥ�����ֵ����ȥ
	 *1  ����������ȫ��������
	 *2  ���ڵ�Ϊi����ô������ ������ 2*i+1��������Ϊ��2*i+2 --> 2*(i+1)
	 *3  ����������������     
	 *4  ���һ�����鳤����n ��ô���һ���ڵ�������a[n-1] 
	 *5  ͨ�����һ���ڵ㣬�õ����ĸ��ڵ�  ͨ��2��4���㣺 ���ڵ�������    n-1=2*i+1  -->   i = n/2-1;
	 * 
	 */
	static void heapSort(int[] a,int n){
		int i,j,h,k;
		int t;
		for(i=n/2-1;i>=0;i--){  //ÿ��ѭ�� a[i],��a[i]���湹��ѽṹ   n/2-1 ����ָ�����һ���ڵ�ĸ��ڵ�
			while(2*i+1<n){   //���a[i] ��������     
				j=2*i+1;   //�ж�Ŀ���Ƶ�������
				if(j+1<n){   //���a[i] ��������
					if(a[j]<a[j+1]){  //���������С��������
						j++;  //Ŀ���Ƶ�������
					}
				}
				if(a[i]<a[j]){    //����������ڸ��ڵ��Լ�   ��������
					t=a[i];
					a[i]=a[j]; 
					a[j]=t;
					i=j;  //�Ѹ��ı��ˣ� Ҫ�жϽ����� ���������Ƿ��Ƕѽṹ
				}else {
					break; //��������ѽṹ    ��Ϊ�����Ľڵ���ģ����Ե��½ڵ�����ѽṹ���������Ѿ��ź���
				}
			}//ѭ�������󣬵�ǰ�ڵ��µ������Ƕѽṹ ����i��ȥ1 ������ǰ��Ľڵ�ȥ����
		}
		
		System.out.println("���ԭ���ݹ���Ķ�");
		/* for(h=0;h<n;h++){
			 System.out.print(a[h]+" ");
		 }*/
		printCompleteBinaryTree(a,1);
		 System.out.println();
		 
		//�����i �Ƕѽṹ�����ݳ��� ÿѭ��һ�Σ����ֵ��i���������ֵ���õ�����i��λ�ã�i-- ,��ʾ�������ų�i
		for(i=n-1;i>0;i--){
			t=a[0];
			a[0] =a[i];
			a[i] = t;//����ֵ����Ϊ  ÿѭ��һ��֮ǰ���Ƕѽṹ 
			k=0;//���϶���  ���� ���Լ���ʱ�䣬��Ϊ�������Ƕѽṹ
			//����������ƻ��˶ѽṹ��Ҫ���¶� ��������ݽ����ѽṹ
			while(2*k+1<i){ 
				j=2*k+1;
				if(j+1<i){
					if(a[j]<a[j+1]){
						j++;
					}
				}
				if(a[k]<a[j]){
					t = a[k];
					a[k]=a[j];
					a[j]=t;
					k=j;
				}else {
					break;
				}
			}
			
			System.out.print("\n��"+(n-i)+"�����");
			 for(h=0;h<n;h++){
				 System.out.print(a[h]+" ");
			 }
			/*System.out.println();
			printCompleteBinaryTree(a,1);*/
			 System.out.println();
		}
	}
	@Test
	public void testHeapSort(){
		int[] ARRAY  = {12,20,5,16,15,1,30,45,23,9};
		System.out.print("\nԭ���ݣ�");
		 for(int h=0;h<ARRAY.length;h++){
			 System.out.print(ARRAY[h]+" ");
		 }
		 System.out.println();
		 printCompleteBinaryTree(ARRAY,1);
		 System.out.println();
		heapSort(ARRAY, ARRAY.length);
	}
	
	
	public static void printCompleteBinaryTree(int[] a,int marginNum){
		int level = (int)Math.floor(Math.log(a.length)/Math.log(2))+1;
		int margin = 1;//���
		if(marginNum>-1&& marginNum<5){
			margin = marginNum;
		}
		int width = (int)Math.pow(2, level+margin)+1;//����
		for(int i=1;i<=level;i++){
			System.out.println();     //ת��
			int c = (int)Math.pow(2, i-1);//������    c-1 �ǵ�һ�������±�
			int space = width/c;//���ڼ��
			int head = (int)Math.pow(2, level-i+margin); //��һ�����ռ�λ��
			for(int offset=0;offset<head;offset++){
			 	System.out.print(" ");
			}
			for(int j=0;j<c;j++){
				int t=0;
				if(c-1+j<a.length){
					t = a[c-1+j]; //��Ҫ�����ֵ
					System.out.print(t); //��Ϊ���ֿ����Ƕ�λ�ģ����Ժ���ļ��Ҫ��ȥλ��
				}
				int bit = (int)Math.floor(Math.log(t)/Math.log(10))+1;
				for(int offset=0;offset<space-bit;offset++){ //���ƿո����
					System.out.print(" ");
				}
			}
		}
	}
	public static void printCBTSimple(int[] a){
		int level = (int)Math.floor(Math.log(a.length)/Math.log(2))+1;
		for(int i=1;i<=level;i++){
			System.out.println();     //ת��
			int c = (int)Math.pow(2, i-1);//������    c-1 �ǵ�һ�������±�
			for(int j=0;j<c&&c-1+j<a.length;j++){
				System.out.print(a[c-1+j]+" ");  
			}
		}
	}
	@Test
	public void testTree(){
		int[] ARRAY  = {12,20,5,16,15,1,30,45,23,9};
		int[] ARRAY4  = {12,20,5345,164,15,1,30,45,23,9,12,320,5,16,15,1,3430,45,253,9};
		int[] ARRAY1  = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		int[] ARRAY3  = {1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,3,8,1,3,9,5,7 };
		int[] ARRAY2  = {1,2,3,4,5,6,7,8,9};
		printCompleteBinaryTree(ARRAY1,0);
	}
	
}
