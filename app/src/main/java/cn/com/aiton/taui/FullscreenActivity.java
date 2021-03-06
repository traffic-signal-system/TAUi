package cn.com.aiton.taui;


import cn.com.aiton.domain.ExtReportState;
import cn.com.aiton.domain.GbtChannel;
import cn.com.aiton.domain.GbtCollision;
import cn.com.aiton.domain.GbtDetector;
import cn.com.aiton.domain.GbtDirec;
import cn.com.aiton.domain.GbtEventLog;
import cn.com.aiton.domain.GbtLampCheck;
import cn.com.aiton.domain.GbtModule;
import cn.com.aiton.domain.GbtOverlap;
import cn.com.aiton.domain.GbtPhase;
import cn.com.aiton.domain.GbtSchedule;
import cn.com.aiton.domain.GbtStagePattern;
import cn.com.aiton.domain.GbtTimeBase;
import cn.com.aiton.domain.GbtTimePattern;
import cn.com.aiton.domain.TscNode;
import cn.com.aiton.services.ChannelService;
import cn.com.aiton.services.CollisionService;
import cn.com.aiton.services.DetectorService;
import cn.com.aiton.services.LampCheckService;
import cn.com.aiton.services.LogEventService;
import cn.com.aiton.services.ModuleService;
import cn.com.aiton.services.OverlapPhaseService;
import cn.com.aiton.services.PatternService;
import cn.com.aiton.services.PhaseService;
import cn.com.aiton.services.PhaseToDirecService;
import cn.com.aiton.services.ScheduleService;
import cn.com.aiton.services.StagePatternService;
import cn.com.aiton.services.TimeBaseService;
import cn.com.aiton.services.impl.ChannelServiceImpl;
import cn.com.aiton.services.impl.CollisionServiceImpl;
import cn.com.aiton.services.impl.DetectorServiceImpl;
import cn.com.aiton.services.impl.LampCheckServiceImpl;
import cn.com.aiton.services.impl.LogEventServiceImpl;
import cn.com.aiton.services.impl.ModuleServiceImpl;
import cn.com.aiton.services.impl.OverlapPhaseServiceImpl;
import cn.com.aiton.services.impl.PatternServiceImpl;
import cn.com.aiton.services.impl.PhaseServiceImpl;
import cn.com.aiton.services.impl.PhaseToDirecServiceImpl;
import cn.com.aiton.services.impl.ScheduleServiceImpl;
import cn.com.aiton.services.impl.StagePatternServiceImpl;
import cn.com.aiton.services.impl.TimeBaseServiceImpl;
import cn.com.aiton.taui.util.SystemUiHider;
import cn.com.aiton.utils.AndroidTscDefine;
import cn.com.aiton.utils.ExtReportUtils;
import cn.com.aiton.utils.GbtDefine;
import cn.com.aiton.utils.SearchTscUtil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.FinalDb;
import net.tsz.afinal.annotation.view.ViewInject;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class FullscreenActivity extends FinalActivity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = false;
    public final static int SUCCESS = 1;
    public final static int FAILURE = 0;
    private Thread thread;
    ListView listView;
    @ViewInject(id=R.id.gv_tsc)
    GridView gridView;
    ArrayList<HashMap<String, String>> arraylistTsc = new ArrayList<HashMap<String, String>>();

    Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SUCCESS:
                    Bundle bundle = msg.getData();
                    TscNode node = (TscNode)bundle.getSerializable("node");
                    String ipadress = node.getIpAddress();
                    int iport = node.getPort();
                    HashMap<String, Integer> map = new HashMap<String, Integer>();
                    map.put(ipadress,iport);


                    break;
                case FAILURE:

                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    Runnable runnableSend = new Runnable() {
        @Override
        public void run() {
            try{
                DatagramSocket dgSocket=new DatagramSocket();
                byte b[]="123456".getBytes();
                DatagramPacket dgPacket=new DatagramPacket(b,b.length, InetAddress.getByName("255.255.255.255"), GbtDefine.BROADCAST_PORT);
                dgSocket.send(dgPacket);
                dgSocket.close();
                System.out.println("send message is ok.");
            }catch(Exception exce){
                exce.printStackTrace();
            }
        }
    };

    Runnable runnable = new Runnable() {

        byte[] by=new byte[1024];
        @Override
        public void run() {
            while (true) {
                try {
                    Message msg = new Message();
                    msg.what = SUCCESS;
                    DatagramSocket dgSocket=new DatagramSocket(0);
                    DatagramPacket packet=new DatagramPacket(by,by.length);
                    dgSocket.receive(packet);

                    byte[] bytes = packet.getData();
                    if (bytes.length > 6){
                        Bundle bundle = new Bundle();
                        TscNode node = SearchTscUtil.bytesToTscNode(bytes);
                        bundle.putSerializable("node", node);
                        msg.setData(bundle);

                        //???????????????Handler
                        mhandler.sendMessage(msg);
                    }

                    //Thread.sleep(1000);
                    dgSocket.close();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    };
    Handler displayHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SUCCESS:
                    SimpleAdapter simpleAdapter = new SimpleAdapter(FullscreenActivity.this,arraylistTsc,R.layout.lv_tsc,new String[]{"devicename","ipaddress"},new int[]{R.id.itemTitle,R.id.itemIPAddress});
                    gridView.setAdapter(simpleAdapter);

                    break;
                case FAILURE:
                    Toast.makeText(FullscreenActivity.this,"?????????????????????",Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };
    Runnable runnableDisplayTscByDb = new Runnable() {
        @Override
        public void run() {
            try{
                FinalDb db = FinalDb.create(FullscreenActivity.this,AndroidTscDefine.DBNAME);
                List<TscNode> nodes = db.findAll(TscNode.class);
                Iterator<TscNode> tscNodeIterator = nodes.iterator();
                while (tscNodeIterator.hasNext()){
                    HashMap<String,String> map = new HashMap<String, String>();
                    TscNode node = tscNodeIterator.next();
                    map.put("ipaddress", node.getIpAddress());
                    map.put("devicename",node.getDeviceName());
                    arraylistTsc.add(map);
                }
                Message msg = new Message();
                msg.what = SUCCESS;
                displayHandler.dispatchMessage(msg);
            }catch(Exception exce){
                exce.printStackTrace();
            }
        }
    };

    private class AnotherTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPostExecute(String result) {
            //???UI?????????????????????
            SimpleAdapter simpleAdapter = new SimpleAdapter(FullscreenActivity.this,arraylistTsc,R.layout.lv_tsc,new String[]{"devicename","ipaddress"},new int[]{R.id.itemTitle,R.id.itemIPAddress});
            gridView.setAdapter(simpleAdapter);
        }
        @Override
        protected String doInBackground(String... params) {
            //???????????????
            HashMap<String,String> map = new HashMap<String, String>();
            arraylistTsc.clear();
            FinalDb db = FinalDb.create(FullscreenActivity.this,AndroidTscDefine.DBNAME);
            List<TscNode> nodes = db.findAll(TscNode.class);
            Iterator<TscNode> tscNodeIterator = nodes.iterator();
            while (tscNodeIterator.hasNext()){

                TscNode node = tscNodeIterator.next();
                map.put("ipaddress", node.getIpAddress());
                map.put("devicename",node.getDeviceName());
                arraylistTsc.add(map);
            }
            return params[0];
        }
    }
    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 30000;

    /**
     * If set, will toggle the system UI visibility upon interaction. Otherwise,
     * will show the system UI visibility upon interaction.
     */
    private static final boolean TOGGLE_ON_CLICK = true;

    /**
     * The flags to pass to {@link SystemUiHider#getInstance}.
     */
    private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

    /**
     * The instance of the {@link SystemUiHider} for this activity.
     */
    private SystemUiHider mSystemUiHider;

    /**
     *
     * @param view
     */
    public void broadCastIp(View view){
//        thread = new Thread(runnable);
//        thread.start();
//
//        Thread thread1 = new Thread(runnableSend);
//        thread1.start();
        new Thread(){
            public void run(){
                new AnotherTask().execute("JSON");
            }
        }.start();
    }
    //???AdapterView?????????(?????????????????????)???????????????Item????????????
      class  ItemClickListener implements AdapterView.OnItemClickListener
     {
       public void onItemClick(AdapterView<?> arg0,//The AdapterView where the click happened
                                               View arg1,//The view within the AdapterView that was clicked
                                     int arg2,//The position of the view in the adapter
                                  long arg3//The row id of the item that was clicked
                                   ) {
           //????????????arg2=arg3
            HashMap<String, String> item=(HashMap<String, String>) arg0.getItemAtPosition(arg2);
             //????????????Item???ItemText

           String ipaddress = item.get("ipaddress");
           FinalDb db = FinalDb.create(FullscreenActivity.this,AndroidTscDefine.DBNAME);
           List<TscNode> tscNodes = db.findAllByWhere(TscNode.class,"ipAddress ='"+ipaddress+"'");
           TscNode node = tscNodes.get(0);
           Context ctx = FullscreenActivity.this;
           SharedPreferences sp = ctx.getSharedPreferences(AndroidTscDefine.TSCNODE, MODE_PRIVATE);
           AndroidTscDefine.tscNodeToSP(node,sp);
       }

      }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//???????????????
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_fullscreen);
        final View controlsView = findViewById(R.id.fullscreen_content_controls);
        final View contentView = findViewById(R.id.fullscreen_content);
        //??????XML??????ListView?????????Item?????????

        gridView.setOnItemClickListener(new ItemClickListener());
        Thread t2 = new Thread(runnableDisplayTscByDb);
        t2.start();

        // Set up an instance of SystemUiHider to control the system UI for
        // this activity.
        mSystemUiHider = SystemUiHider.getInstance(this, contentView, HIDER_FLAGS);
//        mSystemUiHider.setup();
//        mSystemUiHider
//                .setOnVisibilityChangeListener(new SystemUiHider.OnVisibilityChangeListener() {
//                    // Cached values.
//                    int mControlsHeight;
//                    int mShortAnimTime;
//
//                    @Override
//                    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
//                    public void onVisibilityChange(boolean visible) {
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
//                            // If the ViewPropertyAnimator API is available
//                            // (Honeycomb MR2 and later), use it to animate the
//                            // in-layout UI controls at the bottom of the
//                            // screen.
//                            if (mControlsHeight == 0) {
//                                mControlsHeight = controlsView.getHeight();
//                            }
//                            if (mShortAnimTime == 0) {
//                                mShortAnimTime = getResources().getInteger(
//                                        android.R.integer.config_shortAnimTime);
//                            }
//                            controlsView.animate()
//                                    .translationY(visible ? 0 : mControlsHeight)
//                                    .setDuration(mShortAnimTime);
//                        } else {
//                            // If the ViewPropertyAnimator APIs aren't
//                            // available, simply show or hide the in-layout UI
//                            // controls.
//                            controlsView.setVisibility(visible ? View.VISIBLE : View.GONE);
//                        }
//
//                        if (visible && AUTO_HIDE) {
//                            // Schedule a hide().
//                            delayedHide(AUTO_HIDE_DELAY_MILLIS);
//                        }
//                    }
//                });

        // Set up the user interaction to manually show or hide the system UI.
//        contentView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (TOGGLE_ON_CLICK) {
//                    mSystemUiHider.toggle();
//                } else {
//                    mSystemUiHider.show();
//                }
//            }
//        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);



    }

    public void loadTsc(View view){
        Intent intent = new Intent();
        intent.setClass(this,LoadActivity.class);
        startActivity(intent);
    }

    public void btnTsc(View view){
       // Toast.makeText(this,"btn tsc",Toast.LENGTH_LONG).show();
        Intent intent = new Intent();
        intent.setClass(this,PhaseActivity.class);
        Bundle bundle = new Bundle();
        TscNode tn = new TscNode();
        bundle.putSerializable("tn",tn);
        startActivity(intent);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }


    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    Handler mHideHandler = new Handler();
    Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            mSystemUiHider.hide();
        }
    };

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }


}
