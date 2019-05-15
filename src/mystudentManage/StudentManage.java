package mystudentManage;
 
import java.util.ArrayList;
import java.util.Scanner;
 
public class StudentManage {
	public static void main(String[] args) {
		ArrayList<Student> arry = new ArrayList<>();
		while(true) {
			//���ǳɼ�����ϵͳ��������
			System.out.println("------ѧ������ϵͳ------");
			System.out.println(" 1.�鿴����ѧ��");
			System.out.println(" 2.����ѧ��");
			System.out.println(" 3.ɾ��ѧ��");
			System.out.println(" 4.�޸�ѧ��");
			System.out.println(" 5.�˳�");
			Scanner sc =new Scanner(System.in);
			System.out.println("���������ѡ����Ӧ�Ĺ��ܣ�");
			String stufunction = sc.nextLine();
			switch (stufunction) {
			case "1":
				//�鿴����ѧ��
				findstudent(arry);
				break;
			case "2":
				//����ѧ��
				addstudent(arry);
				break;
			case "3":
				//ɾ��ѧ��
				deletestudent(arry);
				break;
			case "4":
				//�޸�ѧ��
				changestudent(arry);
				break;
			case "5":
				//�˳�
			default:
				System.out.println("лл���ʹ��.");
				System.exit(0);//�˳�JVM
				break;
			}
		}
	}
	//������
	public static void findstudent(ArrayList<Student> arry) {
		if(arry.size()==0) {
			System.out.println("������˼��Ŀǰ��û��ѧ������Ϣ�ɹ���ѯ���뷵�����²�����");
			return;
		}
		System.out.println("ѧ��\t����\t����\t��ס��");
		for(int i=0;i<arry.size();i++) {
			Student s = arry.get(i);
			System.out.println(s.getStdId()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getPlace());
		}
	}
	//�����
	public static void addstudent(ArrayList<Student> arry) {
		//��������¼�����
		Scanner sc= new Scanner(System.in);
		String stuId;
		while(true) {
			System.out.println("������ѧ�ţ�");
			stuId = sc.nextLine();
			boolean flag = false;
			for(int i=0;i<arry.size();i++) {
				Student s = arry.get(i);
				if(s.getStdId().equals(stuId)) {		
					flag = true;			
					break;
				}
			}
			if(flag) {
				System.out.println("��������˺ű�ռ�ã�����");
			}else {
				break;
			}
		}
		System.out.println("������������");
		String name = sc.nextLine();
		System.out.println("���������䣺");
		String age = sc.nextLine();
		System.out.println("�������ס�أ�");
		String place = sc.nextLine();
		//����ѧ������
		Student s = new Student();
		s.setStdId(stuId);
		s.setName(name);
		s.setAge(age);
		s.setPlace(place);
		//��ѧ��������ӵ�����
		arry.add(s);
		System.out.println("���ѧ���ɹ���");
	}
	//ɾ����
	public static void deletestudent(ArrayList<Student> arry) {
		Scanner sc= new Scanner(System.in);
		System.out.print("������Ҫɾ����ѧ�ţ�");
		String deleId = sc.nextLine();
		int index = -1;
		for(int i=0;i<arry.size();i++) {
			Student s = arry.get(i);
			if(s.getStdId().equals(deleId)) {		
				index=i;					
			}			
			if (index == -1) {
				System.out.println("��Ҫɾ����ѧ�������ڣ�������ѡ��");
			} else {
				arry.remove(index);
				System.out.println("ɾ��ѧ���ɹ�����");
			}
		} 
	}
	//�޸���
	public static void changestudent(ArrayList<Student> arry) {
		Scanner sc= new Scanner(System.in);
		System.out.print("������Ҫ�ı��ѧ�ţ�");
		String changeId = sc.nextLine();
		int index = -1;
		for(int i=0;i<arry.size();i++) {
			Student s = arry.get(i);
			if(s.getStdId().equals(changeId)) {		
				index = i;				
			}
		}
		if (index == -1) {
			System.out.println("��Ҫ�ı��ѧ�������ڣ������²�����");
		} else {
			System.out.println("��������������");
			String name = sc.nextLine();
			System.out.println("�����������䣺");
			String age = sc.nextLine();
			System.out.println("�������¾�ס�أ�");
			String place = sc.nextLine();
			//����ѧ������
			Student s = new Student();
			s.setStdId(changeId);
			s.setName(name);
			s.setAge(age);
			s.setPlace(place);
			//�޸�ѧ������
			arry.set(index,s);
			System.out.println("�޸�ѧ���ɹ�������");
		}
	}
}
