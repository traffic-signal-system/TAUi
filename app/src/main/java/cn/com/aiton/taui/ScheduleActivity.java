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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import net.tsz.afinal.FinalDb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import cn.com.aiton.domain.GbtSchedule;
import cn.com.aiton.domain.TscNode;
import cn.com.aiton.utils.AndroidTscDefine;


public class ScheduleActivity extends Activity {
    private List<Map<String, Object>> mData;
    private ListView listView;
    public final static int SUCCESS = 1;
    public final static int FAILURE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        listView = (ListView)findViewById(R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("MyListView4-click", (String) mData.get(position).get("title"));

            }
        });


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
    private List<Map<String, Object>> getData() {
        Context ctx = ScheduleActivity.this;
        SharedPreferences sp = ctx.getSharedPreferences(AndroidTscDefine.TSCNODE, MODE_PRIVATE);
        TscNode node = AndroidTscDefine.spToTscNode(sp);
        FinalDb db = FinalDb.create(this,AndroidTscDefine.DBNAME);
        List<GbtSchedule> gbtSchedules = db.findAllByWhere(GbtSchedule.class,"deviceId = '"+node.getId()+"'");
        List<Map<String,Object>> maps = AndroidTscDefine.listScheduleToListMap(gbtSchedules);
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
        new AlertDialog.Builder(this)
                .setTitle("我的listview")
                .setMessage("介绍...")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();

    }



    public final class ViewHolder{
        public ImageView img;
        public TextView eventId;
        public TextView beginHour;
        public TextView beginMinute;
        public TextView controlMode;
        public TextView timePatternId;
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
                holder.img = (ImageView)convertView.findViewById(R.id.img);
                holder.eventId = (TextView)convertView.findViewById(R.id.eventId);
                holder.beginHour = (TextView)convertView.findViewById(R.id.beginHour);
                holder.beginMinute = (TextView)convertView.findViewById(R.id.beginMinute);
                holder.controlMode = (TextView)convertView.findViewById(R.id.controlMode);
                holder.timePatternId = (TextView)convertView.findViewById(R.id.timePatternId);
                holder.viewBtn = (Button)convertView.findViewById(R.id.view_btn);
                convertView.setTag(holder);

            }else {

                holder = (ViewHolder)convertView.getTag();
            }


           // holder.img.setBackgroundResource((Integer)mData.get(position).get("img"));
            holder.eventId.setText((String)mData.get(position).get("eventId"));
            holder.beginHour.setText((String)mData.get(position).get("beginHour"));
            holder.beginMinute.setText((String)mData.get(position).get("beginMinute"));
            holder.controlMode.setText((String)mData.get(position).get("controlMode"));
            holder.timePatternId.setText((String)mData.get(position).get("timePatternId"));

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
