package arithmetic;

import org.junit.Test;

public class SortUtile {
	 public static int[] ARRAY  = {12,20,5,16,15,1,30,45,23,9};
	 public static final int SIZE = 10;
	 private static int step=0;
	
	 public void quickSort(int[] a,int left,int right){
         int ltemp = left;
         int rtemp = right;
         int key = a[(left+right)/2];//�ֽ�ֵ
         int t;
         
         while(ltemp<rtemp){
             //��ǰ����Ƚ�
             while( a[ltemp]<key)//���û�бȹؼ�ֵ��ģ��Ƚ���һ����ֱ���бȹؼ�ֵ��Ľ���λ��
                ltemp++;
             //�Ӻ���ǰ�Ƚ�
             while( a[rtemp]>key)  //���û�бȹؼ�ֵС�ģ��Ƚ���һ����ֱ���бȹؼ�ֵС�Ľ���λ�ã�Ȼ���ִ�ǰ����Ƚ�
                 rtemp--;
             if(ltemp<rtemp){
                   t = a[ltemp];
                 a[ltemp] = a[rtemp];
                 a[rtemp] = t;
                 
                 ltemp++;
                 rtemp--;
             }
       //  ��ʱ��һ��ѭ���ȽϽ������ؼ�ֵ��λ���Ѿ�ȷ���ˡ���ߵ�ֵ���ȹؼ�ֵС���ұߵ�ֵ���ȹؼ�ֵ�󣬵������ߵ�˳���п����ǲ�һ���ģ���������ĵݹ����
             System.out.print("\n��"+(++step)+"����������");
             for(int i = 0; i<a.length; i++){
                 System.out.print( a[i]+" ");
             }
             System.out.println("  ������"+key);
         }
         if(ltemp==rtemp) ltemp++;
         //�ݹ�
         if(left<rtemp) quickSort(a,left,ltemp-1);//������С���һ������λ�õ��ؼ�ֵ����-1
         if(ltemp<right) quickSort(a,rtemp+1,right);//�ұ����С��ӹؼ�ֵ����+1�����һ��
     }
	 //�ӵڶ���������������ǰ�Ƚϣ����뵽����λ��
	 //�ڶ���������ڵ�һ����ִ�е������Ƚϣ���ʱǰ�����Ѿ��ź���
	 //�����������������������С�ڵڶ��������ڶ��������Ƶ�������λ�ã�
	 //��������������ǰ�Ƚϣ�ǰ����������������������һλ��
	 //����ǰλ�ú�һλΪ��������
	 public static void insertSort(int[] a){
		 int i,j,insertNum;
		 // t ��ҪҪ�������
		 for(i=1;i<a.length;i++){
			 insertNum = a[i];
			 j=i-1;
			 while(j>=0&& insertNum<a[j]){
				 a[j+1] =a[j];
				 j--;
			 }
			 a[j+1] =insertNum;
			 System.out.print("\n��"+i+"����������");
			 for(int h=0;h<a.length;h++){
				 System.out.print(a[h]+" ");
			 }
		 }
	 }
	 public static void shellSort(int[] a){
		 int i,j,h;
		 int r,temp;//r ����������temp,�м佻������
		 int x=0;
		 for(r=a.length/2;r>=1;r/=2){//�ֶ�
			 for(i=r;i<a.length;i++){
				 temp = a[i];
				 j=i-r;
				 while(j>=0&&temp<a[j]){//�����ǲ��������߼�
					 a[j+r] = a[j];
					 j-=r;//�������
				 }
				 a[j+r]=temp;
			 }
			 x++;
			 System.out.print("��"+x+"�������ǣ�");
			 for( h = 0; h<a.length; h++){
		            System.out.print( a[h]+" ");
		     }
			 System.out.println();
		 }
		 
	 }
	 @Test
     public void test1( ){
        int[] a = ARRAY;
        int start = 0;
        int end = a.length-1;
        System.out.print("����ǰ�� " );
        for(int i = 0; i<a.length; i++){
            System.out.print( a[i]+" ");
        }
        System.out.println( );
        quickSort(a,start,end);
        System.out.println("\n����� ");
        for(int i = 0; i<a.length; i++){
        	System.out.print( a[i]+" ");
         }
        System.out.println();
     }
	 @Test
	 public void test2( ){
		 int[] a = ARRAY;
		 System.out.print("����ǰ�� " );
		 for(int i = 0; i<a.length; i++){
			 System.out.print( a[i]+" ");
		 }
		 System.out.println( );
		 insertSort(a);
		 System.out.println("\n����� ");
		 for(int i = 0; i<a.length; i++){
			 System.out.print( a[i]+" ");
		 }
		 System.out.println();
	 }
	 @Test
	 public void test3( ){
		 int[] a = ARRAY;
		 System.out.print("����ǰ�� " );
		 for(int i = 0; i<a.length; i++){
			 System.out.print( a[i]+" ");
		 }
		 System.out.println( );
		 shellSort(a);
		 System.out.println("\n����� ");
		 for(int i = 0; i<a.length; i++){
			 System.out.print( a[i]+" ");
		 }
		 System.out.println();
	 }
	 @Test
	 public void test4( ){
		 int[] a = ARRAY;
		 System.out.print("����ǰ�� " );
		 for(int i = 0; i<a.length; i++){
			 System.out.print( a[i]+" ");
		 }
		 System.out.println( );
		 quickSort(a, 0, a.length-1);
		 System.out.println("\n����� ");
		 for(int i = 0; i<a.length; i++){
			 System.out.print( a[i]+" ");
		 }
		 System.out.println();
	 }


}
