package cn.sxt.game;
 
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
public class MyGameFrame extends JFrame {
	int x=0,y=0;
	Image ball = GameUtil.getImage("images/0002.png");
	Image bg = GameUtil.getImage("images/hong.jpg");
	public void paint(Graphics g) {  //g�൱�ڻ��ʣ��Զ�����
		super.paint(g);
//		Font f = g.getFont();
//    //�������(100,50)��(400,400)����ֱ��
//    g.drawLine(100, 50, 400, 400); 
//    //�������Ρ��������ϽǶ�������(100,50)�����300���߶�300
//    g.drawRect(100, 50, 300, 300);  
//    //������Բ����Բ���о���Ϊ�����ϽǶ���(100,50),���300���߶�300
//    g.drawOval(100, 50, 300, 300); 
//    g.setFont(new Font("����", Font.BOLD, 50));
//    g.drawString("no one", 200, 200);
    
    g.drawImage(bg, 0, 0, null);
    g.drawImage(ball, x, y, null);
    x++;y++;
}
	/**
	 * �����ػ�����
	 * @author Administrator
	 *
	 */
	class PaintThread extends Thread {
        public void run(){
            while(true){
                repaint();
                System.out.println("�ػ�1��");
                try {
                    Thread.sleep(200); //1s = 1000ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }   
            }
        }
    }  	
	
    public void launchFrame(){
        //����Ϸ���ڴ�ӡ����
        this.setTitle("���ڲ���");
        //����Ĭ�ϲ��ɼ�����Ϊ�ɼ�
        this.setVisible(true);
        //���ڴ�С�����500���߶�500
        this.setSize(600, 375);
        //�������ϽǶ��������λ��
        this.setLocation(300, 300);
         
        //���ӹرմ��ڼ����������û�������Ͻǹر�ͼ�꣬���Թر���Ϸ����
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        new PaintThread().start();
    }
     
    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}