package cn.com.aiton.taui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import org.apache.http.conn.util.InetAddressUtils;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import cn.com.aiton.gbt20999.domain.ExtReportState;
import cn.com.aiton.gbt20999.domain.GbtDirec;
import cn.com.aiton.gbt20999.utils.ExtReportUtils;
import cn.com.aiton.gbt20999.utils.GbtDefine;
import cn.com.aiton.gbt20999.utils.UdpClientSocket;


public class ManaulActivity extends Activity {
    public final static int SUCCESS = 1;
    public final static int FAILURE = 0;

    ImageView northLeft ;
    ImageView northStriaght;
    ImageView northRight;
    ImageView northOther;

    ImageView eastLeft;
    ImageView eastStriaght;
    ImageView eastRight;
    ImageView eastOther;

    ImageView southLeft;
    ImageView southStriaght;
    ImageView southRight ;
    ImageView southOther;

    ImageView westLeft ;
    ImageView westStriaght;
    ImageView westRight;
    ImageView westOther;
    private Thread thread;

    public void updateRed(GbtDirec gbtDirec){
        if (gbtDirec.getDirecId() == GbtDefine.NORTH_LEFT){
            northLeft.setImageResource(R.drawable.redone);
        }
        if (gbtDirec.getDirecId() == GbtDefine.NORTH_STRAIGHT){
            northStriaght.setImageResource(R.drawable.redone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.NORTH_RIGHT){
            northRight.setImageResource(R.drawable.redone);
        }
        if (gbtDirec.getDirecId() == GbtDefine.NORTH_OTHER){
            northOther.setImageResource(R.drawable.redone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.EAST_LEFT){
            eastLeft.setImageResource(R.drawable.redone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.EAST_STRAIGHT){
            eastStriaght.setImageResource(R.drawable.redone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.EAST_RIGHT){
            eastRight.setImageResource(R.drawable.redone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.EAST_OTHER){
            eastOther.setImageResource(R.drawable.redone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.SOUTH_LEFT){
            southLeft.setImageResource(R.drawable.redone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.SOUTH_STRAIGHT){
            southStriaght.setImageResource(R.drawable.redone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.SOUTH_RIGHT){
            southRight.setImageResource(R.drawable.redone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.SOUTH_OTHER){
            southOther.setImageResource(R.drawable.redone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.WEST_LEFT){
            westLeft.setImageResource(R.drawable.redone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.WEST_STRAIGHT){
            westStriaght.setImageResource(R.drawable.redone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.WEST_RIGHT){
            westRight.setImageResource(R.drawable.redone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.WEST_OTHER){
            westOther.setImageResource(R.drawable.redone);
        }
    }

    public void upateGreen(GbtDirec gbtDirec){
        if (gbtDirec.getDirecId() == GbtDefine.NORTH_LEFT){
            northLeft.setImageResource(R.drawable.greenone);
        }
        if (gbtDirec.getDirecId() == GbtDefine.NORTH_STRAIGHT){
            northStriaght.setImageResource(R.drawable.greenone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.NORTH_RIGHT){
            northRight.setImageResource(R.drawable.greenone);
        }
        if (gbtDirec.getDirecId() == GbtDefine.NORTH_OTHER){
            northOther.setImageResource(R.drawable.greenone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.EAST_LEFT){
            eastLeft.setImageResource(R.drawable.greenone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.EAST_STRAIGHT){
            eastStriaght.setImageResource(R.drawable.greenone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.EAST_RIGHT){
            eastRight.setImageResource(R.drawable.greenone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.EAST_OTHER){
            eastOther.setImageResource(R.drawable.greenone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.SOUTH_LEFT){
            southLeft.setImageResource(R.drawable.greenone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.SOUTH_STRAIGHT){
            southStriaght.setImageResource(R.drawable.greenone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.SOUTH_RIGHT){
            southRight.setImageResource(R.drawable.greenone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.SOUTH_OTHER){
            southOther.setImageResource(R.drawable.greenone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.WEST_LEFT){
            westLeft.setImageResource(R.drawable.greenone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.WEST_STRAIGHT){
            westStriaght.setImageResource(R.drawable.greenone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.WEST_RIGHT){
            westRight.setImageResource(R.drawable.greenone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.WEST_OTHER){
            westOther.setImageResource(R.drawable.greenone);
        }
    }

    public void updateYellow(GbtDirec gbtDirec){
        if (gbtDirec.getDirecId() == GbtDefine.NORTH_LEFT){
            northLeft.setImageResource(R.drawable.yellowone);
        }
        if (gbtDirec.getDirecId() == GbtDefine.NORTH_STRAIGHT){
            northStriaght.setImageResource(R.drawable.yellowone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.NORTH_RIGHT){
            northRight.setImageResource(R.drawable.yellowone);
        }
        if (gbtDirec.getDirecId() == GbtDefine.NORTH_OTHER){
            northOther.setImageResource(R.drawable.yellowone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.EAST_LEFT){
            eastLeft.setImageResource(R.drawable.yellowone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.EAST_STRAIGHT){
            eastStriaght.setImageResource(R.drawable.yellowone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.EAST_RIGHT){
            eastRight.setImageResource(R.drawable.yellowone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.EAST_OTHER){
            eastOther.setImageResource(R.drawable.yellowone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.SOUTH_LEFT){
            southLeft.setImageResource(R.drawable.yellowone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.SOUTH_STRAIGHT){
            southStriaght.setImageResource(R.drawable.yellowone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.SOUTH_RIGHT){
            southRight.setImageResource(R.drawable.yellowone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.SOUTH_OTHER){
            southOther.setImageResource(R.drawable.yellowone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.WEST_LEFT){
            westLeft.setImageResource(R.drawable.yellowone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.WEST_STRAIGHT){
            westStriaght.setImageResource(R.drawable.yellowone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.WEST_RIGHT){
            westRight.setImageResource(R.drawable.yellowone);
        }
        if(gbtDirec.getDirecId() == GbtDefine.WEST_OTHER){
            westOther.setImageResource(R.drawable.yellowone);
        }
    }
    Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SUCCESS:
                    Bundle bundle = msg.getData();
                    ExtReportState ers = (ExtReportState)bundle.getSerializable("ers");
                    List<Integer> listChannelGreen = ers.getListChannelGreenStatus();
                    Iterator<Integer> iteratorGreen = listChannelGreen.iterator();
                    for(int i=0;i<32;i++){
                        if (listChannelGreen.get(i)==1){
                            upateGreen(new GbtDirec());

                        }
                    }

                    break;
                case FAILURE:

                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };
    Runnable runnable = new Runnable() {
        private Random random = new Random();
        private String uuid = UUID.randomUUID().toString();
        DatagramPacket packet;
        private DatagramSocket datagramSocket = null; // 连接对象
        byte[] buffer=new byte[1024];
        DatagramSocket udpClientSocket;
        DatagramPacket udpSendPacket;
        DatagramPacket udpReceivePacket;
        InetAddress hostAddress;
        UdpClientSocket ucs ;
        @Override
        public void run() {
            // TODO Auto-generated method stub
            ArrayList list = new ArrayList();
            try {
                //init();

                ucs = new UdpClientSocket();
                ucs.send("192.168.1.136",5435,GbtDefine.REPORT_TSC_STATUS);

                System.out.println("客户端发送连接请求");
            } catch (Exception exce) {
                exce.printStackTrace();
            }
            while (true) {
                try {
                    Message msg = new Message();
                    msg.what = SUCCESS;

                    byte[] bytes = ucs.receiveByte("192.168.1.136",5435);
                    System.out.println("bytes : "+bytes[0]+" "+bytes[1]+" "+bytes[2]+" "+bytes[3]+" "+bytes[4]+" "+bytes[5]+" "+bytes[6]+" "+bytes[7]+" "+bytes[8]);
                    Bundle bundle = new Bundle();
                    ExtReportState ers = cn.com.aiton.taui.util.ExtReportUtils.byte2ReportState(bytes);

                    bundle.putSerializable("ers", ers);
                    msg.setData(bundle);
                    //发送消息到Handler
                    mhandler.sendMessage(msg);
                    //Thread.sleep(1000);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        /**
         * 接收数据包，该方法会造成线程阻塞
         * @return
         * @throws java.io.IOException
         */
        public void receive(DatagramPacket packet) throws Exception {
            try {
                datagramSocket.receive(packet);
            } catch (Exception e) {
                throw e;
            }
        }

        /**
         * 发送数据包到指定地点
         * @param packet
         * @throws java.io.IOException
         */
        public void sendDate(DatagramPacket packet) {
            try {
                datagramSocket.send(packet);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * 初始化客户端连接
         * @throws SocketException
         */
        public void init() throws SocketException {
            try {
                datagramSocket = new DatagramSocket(random.nextInt(9999));
                datagramSocket.setSoTimeout(10 * 1000);
                System.out.println("客户端启动成功");
            } catch (Exception e) {
                datagramSocket = null;
                System.out.println("客户端启动失败");
                e.printStackTrace();
            }
        }


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_manaul);
        northLeft = (ImageView)findViewById(R.id.northLeft);
        northStriaght = (ImageView)findViewById(R.id.northStriaght);
        northRight = (ImageView)findViewById(R.id.northRight);
        northOther = (ImageView)findViewById(R.id.northOther);

        eastLeft = (ImageView)findViewById(R.id.eastLeft);
        eastStriaght = (ImageView)findViewById(R.id.eastStriaght);
        eastRight = (ImageView)findViewById(R.id.eastRight);
        eastOther = (ImageView)findViewById(R.id.eastOther);

        southLeft = (ImageView)findViewById(R.id.southLeft);
        southStriaght = (ImageView)findViewById(R.id.southStriaght);
        southRight = (ImageView)findViewById(R.id.southRight);
        southOther = (ImageView)findViewById(R.id.southOther);

        westLeft = (ImageView)findViewById(R.id.westLeft);
        westStriaght = (ImageView)findViewById(R.id.westStriaght);
        westRight = (ImageView)findViewById(R.id.westRight);
        westOther = (ImageView)findViewById(R.id.westOther);
        thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.manaul, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
