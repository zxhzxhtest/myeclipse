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
	public void paint(Graphics g) {  //g相当于画笔，自动调用
		super.paint(g);
//		Font f = g.getFont();
//    //从坐标点(100,50)到(400,400)画出直线
//    g.drawLine(100, 50, 400, 400); 
//    //画出矩形。矩形左上角顶点坐标(100,50)，宽度300，高度300
//    g.drawRect(100, 50, 300, 300);  
//    //画出椭圆。椭圆外切矩形为：左上角顶点(100,50),宽度300，高度300
//    g.drawOval(100, 50, 300, 300); 
//    g.setFont(new Font("宋体", Font.BOLD, 50));
//    g.drawString("no one", 200, 200);
    
    g.drawImage(bg, 0, 0, null);
    g.drawImage(ball, x, y, null);
    x++;y++;
}
	/**
	 * 反复重画窗口
	 * @author Administrator
	 *
	 */
	class PaintThread extends Thread {
        public void run(){
            while(true){
                repaint();
                System.out.println("重画1次");
                try {
                    Thread.sleep(200); //1s = 1000ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }   
            }
        }
    }  	
	
    public void launchFrame(){
        //在游戏窗口打印标题
        this.setTitle("窗口测试");
        //窗口默认不可见，设为可见
        this.setVisible(true);
        //窗口大小：宽度500，高度500
        this.setSize(600, 375);
        //窗口左上角顶点的坐标位置
        this.setLocation(300, 300);
         
        //增加关闭窗口监听，这样用户点击右上角关闭图标，可以关闭游戏程序
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