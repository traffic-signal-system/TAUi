package cn.com.aiton.taui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.tsz.afinal.FinalDb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import cn.com.aiton.domain.GbtControlModel;
import cn.com.aiton.domain.GbtSchedule;
import cn.com.aiton.domain.GbtTimePattern;
import cn.com.aiton.domain.TscNode;
import cn.com.aiton.utils.AndroidTscDefine;


public class ScheduleActivity extends Activity {
    private List<Map<String, String>> mData;
    private ListView listView;
    public final static int SUCCESS = 1;
    public final static int FAILURE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.activity_schedule);

        SharedPreferences sp = this.getSharedPreferences(AndroidTscDefine.TSCNODE, MODE_PRIVATE);
        TscNode node = AndroidTscDefine.spToTscNode(sp);
        FinalDb db = FinalDb.create(this, AndroidTscDefine.DBNAME);
        List<GbtTimePattern> gbtTimePatterns = db.findAllByWhere(GbtTimePattern.class,"deviceId = '"+node.getId()+"'");

        listView = (ListView)findViewById(R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("MyListView4-click", (String) mData.get(position).get("eventId")+"    --    "+ (String) mData.get(position).get("scheduleId"));
               // Toast.makeText(this,"fff",Toast.LENGTH_LONG).show();
            }
        });
        Thread t2 = new Thread(runnable);
        t2.start();

    }
android.os.Handler handler = new android.os.Handler(){
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SUCCESS:
                MyAdapter myAdapter = new MyAdapter(ScheduleActivity.this);
                listView.setAdapter(myAdapter);

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
        @Override
        public void run() {
            Message msg = new Message();
            msg.what = SUCCESS;
            mData = getData();
            handler.sendMessage(msg);
        }
    };

    public List<String> getTimePatternData(){
        List<String> list = new ArrayList<String>();
        Context ctx = ScheduleActivity.this;
        SharedPreferences sp = ctx.getSharedPreferences(AndroidTscDefine.TSCNODE, MODE_PRIVATE);
        TscNode node = AndroidTscDefine.spToTscNode(sp);
        FinalDb db = FinalDb.create(this,AndroidTscDefine.DBNAME);
        List<GbtTimePattern> gbtTimePatterns = db.findAllByWhere(GbtTimePattern.class,"deviceId = '"+node.getId()+"'");
        Iterator<GbtTimePattern> gbtTimePatternIterator = gbtTimePatterns.iterator();
        while(gbtTimePatternIterator.hasNext()){
            list.add(gbtTimePatternIterator.next().getTimePatternId()+"");
        }
        return list;
    }
    private List<Map<String, String>> getData() {
        Context ctx = ScheduleActivity.this;
        SharedPreferences sp = ctx.getSharedPreferences(AndroidTscDefine.TSCNODE, MODE_PRIVATE);
        TscNode node = AndroidTscDefine.spToTscNode(sp);
        FinalDb db = FinalDb.create(this,AndroidTscDefine.DBNAME);
        List<GbtSchedule> gbtSchedules = db.findAllByWhere(GbtSchedule.class,"deviceId = '"+node.getId()+"'");
        List<Map<String,String>> maps = AndroidTscDefine.listScheduleToListMap(gbtSchedules);
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("title", "G1");
//        map.put("info", "google 1");
//        map.put("img", R.drawable.ic_launcher);
//
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("title", "G2");
//        map.put("info", "google 2");
//        map.put("img", R.drawable.ic_launcher);
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("title", "G3");
//        map.put("info", "google 3");
//        map.put("img", R.drawable.ic_launcher);
//        list.add(map);

        return maps;
    }

    // ListView 中某项被选中后的逻辑


    /**
     * listview中点击按键弹出对话框
     */
    public void showInfo(){
        new AlertDialog.Builder(this.getParent())
                .setTitle("提示")
                .setMessage("功能未开放，请联系厂家！")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();

    }



    public final class ViewHolder{
        public ImageView img;
        public EditText scheduleId;
        public EditText eventId;
        public EditText beginHour;
        public EditText beginMinute;
        public Spinner controlMode;
        public Spinner timePatternId;
        public Button viewBtn;
    }


    public class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;


        public MyAdapter(Context context){
            this.mInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mData.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            if (convertView == null) {

                holder=new ViewHolder();

                convertView = mInflater.inflate(R.layout.lv_schedule, null);
                holder.img = (ImageView)convertView.findViewById(R.id.lvs_img);
                holder.scheduleId = (EditText)convertView.findViewById(R.id.lvs_scheduleId);
                holder.eventId = (EditText)convertView.findViewById(R.id.lvs_eventId);
                holder.beginHour = (EditText)convertView.findViewById(R.id.lvs_beginHour);
                holder.beginMinute = (EditText)convertView.findViewById(R.id.lvs_beginMinute);
                holder.controlMode = (Spinner)convertView.findViewById(R.id.lvs_controlMode);
                holder.timePatternId = (Spinner)convertView.findViewById(R.id.lvs_timePatternId);
                holder.viewBtn = (Button)convertView.findViewById(R.id.lvs_btn);
                convertView.setTag(holder);

            }else {

                holder = (ViewHolder)convertView.getTag();
            }


            holder.scheduleId.setText((String)mData.get(position).get("scheduleId"));
            holder.eventId.setText((String)mData.get(position).get("eventId"));
            holder.beginHour.setText((String) mData.get(position).get("beginHour"));
            holder.beginMinute.setText((String) mData.get(position).get("beginMinute"));
            //List<String> list = SpinnerControlModeAdapter.getData();
            //ArrayAdapter<String> adapter = new ArrayAdapter<String>(ScheduleActivity.this,android.R.layout.simple_spinner_item,list);
            List<GbtControlModel> gbtControlModels = new ArrayList<GbtControlModel>();
            gbtControlModels.add(new GbtControlModel("自主控制",0));
            gbtControlModels.add(new GbtControlModel("关灯控制",1));
            gbtControlModels.add(new GbtControlModel("黄闪控制",2));
            gbtControlModels.add(new GbtControlModel("全红控制",3));
            gbtControlModels.add(new GbtControlModel("感应控制",6));
            gbtControlModels.add(new GbtControlModel("无电缆协调",7));
            gbtControlModels.add(new GbtControlModel("单点优化",8));
            gbtControlModels.add(new GbtControlModel("主从控制", 11));
            gbtControlModels.add(new GbtControlModel("联网控制", 12));
            gbtControlModels.add(new GbtControlModel("手动控制", 13));

            SpinnerControlModeAdapter spinnerControlModeAdapter = new SpinnerControlModeAdapter(gbtControlModels,ScheduleActivity.this);
            holder.controlMode.setAdapter(spinnerControlModeAdapter);
            List<String> timePatternData = getTimePatternData();
            ArrayAdapter<String> timepatternAdapter = new ArrayAdapter<String>(ScheduleActivity.this,android.R.layout.simple_spinner_item,timePatternData);
            holder.timePatternId.setAdapter(timepatternAdapter);
           // holder.controlMode.setText((String) mData.get(position).get("controlMode"));
            //holder.timePatternId.setText((String)mData.get(position).get("timePatternId"));

            holder.viewBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    showInfo();
                }
            });


            return convertView;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.schedule, menu);
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
