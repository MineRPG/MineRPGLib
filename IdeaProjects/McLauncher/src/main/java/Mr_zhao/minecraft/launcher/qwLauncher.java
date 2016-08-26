package Mr_zhao.minecraft.launcher;

import Mr_zhao.minecraft.launcher.minecraft.ServerConnect;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;

import static java.awt.Desktop.getDesktop;
import static java.lang.System.out;
/**
 * Created by yzh on 16-8-21.
 */

public class qwLauncher extends JFrame{
  static  double radioW;
    //系统分辨率宽度
   static double radioH;
    //系统分辨率高度
    public   static int width;
    public  static  int height;
    private static String realm="https://qwzd.club/";
    private static String vip="https://www.58fk.com/link/u/9OJT0Ju.html";
    public static ServerConnect server;
    public static  String ip="117.21.226.161";
    private String getIp(String s) throws UnknownHostException {
        return InetAddress.getByName(s).getHostAddress();
    }
    private Image getImg(InputStream path){
        Image img= null;
        try {

            img = ImageIO.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;

    }
    private Image getImg(URL path){
        Image img= null;
        try {

            img = ImageIO.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;

    }
    public qwLauncher(){
        this.setResizable(false);
        this.setLayout(null);
        try {
            ip=getIp(realm);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("域名解析错误 使用默认ip");
        }
       width= (int) (radioW*0.618);
         height= (int) (radioH*0.618);
        this.setSize(width,height);
        this.setTitle("青蛙启动器");
        this.add(new ILabel(1,0,"服务器延迟: %delay","服务器连接失败"));
        this.add(new ILabel(250,350,"当前在线人数: %online","服务器连接失败"));
        this.add(new ILabel("服务器公告列表",1,30));
            this.setIconImage(getImg(getFileAsSteam("icon.png")));
        List l=new List();
        java.util.List<String> list=server.getAnnounce();
        if(list!=null){
            for(String s:list){
                l.add(s);
            }
        }else{
            l.add("无法获取到公告");
        }
        l.setFont((new Font("宋体",Font.ITALIC,25)));
        l.setBounds(1,70,230,300);
        this.add(l);
    ILabel name_label=new ILabel("您的游戏名:",50, 400,25);
        this.add(name_label);
        final JTextArea name_area=new JTextArea();
        name_area.setText("请在此输入您的大名");
        name_area.setBounds(190,408,130,22);
        this.add(name_area);
        JButton random_button=new JButton("点击我随机取名");
        random_button.setBounds(330,409,130,20);
        random_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String str="abcdefghijklmnopqrstuvwxyz";
                StringBuilder sb=new StringBuilder();
                 for(int j=0;j<5;j++){
                     sb.append(str.charAt((int)(Math.random()*10)));
                }
                name_area.setText(sb.toString());
            }
        });
        this.add(random_button);
        JButton websitebutton=new JButton("点击我访问服务器官网");
        websitebutton.setBounds(290,25,180,40);
        websitebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {

                    getDesktop().browse(new URI(realm));
                } catch ( Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "请手动访问官网，地址:"+realm, "无法打开官网", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.add(websitebutton);
        JButton websitebutton2=new JButton("点击我访问赞助链接");
        websitebutton2.setBounds(290,80-25+80,180,40);
        websitebutton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {

                    getDesktop().browse(new URI(vip));
                } catch ( Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "请手动访问赞助地址，地址:"+vip, "无法打开赞助地址", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.add(websitebutton2);
        JButton startgame=new JButton("点击我启动游戏");
        startgame.setBounds(290,80,180,40);
        startgame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                /*




                do some thing






                 */
            }
        });
        this.add(startgame);
    }
    /*

          int delay=new ServerPInger(ip,3535).getDelay();
      JLabel delay_label;
        //延迟的标签
        if(delay==0){
            delay_label=new JLabel("无法连接到服务器 延迟获取失败");
        }else {
            delay_label=new JLabel("当前延迟: "+delay);
        }
        delay_label.setSize((int)(width*0.0618),(int)(height*0.0618));

        add(delay_label);
     */
    public static InputStream getFileAsSteam(String s){
        return  qwLauncher.class.getClassLoader().getResourceAsStream(s);
    }
    public static void main(String args[]){
         radioH=getScreenSize().getHeight();
        radioW= getScreenSize().getWidth();

        server=new ServerConnect(ip,25500);

        out.println("开始创建窗口");
        new qwLauncher().setVisible(true);
    }
    public  static Dimension getScreenSize(){
        return java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    }
}
