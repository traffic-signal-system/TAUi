package cn.com.aiton.taui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.FinalDb;
import net.tsz.afinal.annotation.view.ViewInject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.com.aiton.domain.GbtSchedule;
import cn.com.aiton.domain.GbtTimeBase;
import cn.com.aiton.domain.TscNode;
import cn.com.aiton.utils.AndroidTscDefine;


public class BasetimeDayActivity extends FinalActivity {
    List<GbtTimeBase> gbtTimeBases;
    List<GbtSchedule> gbtSchedules;
    private List<String> list = new ArrayList<String>();
    private List<String> schedules = new ArrayList<String>();
    private Spinner mySpinner;
    private ArrayAdapter<String> adapter;
    private Spinner sp_schedule;
    private ArrayAdapter<String> adapter_schedule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.activity_basetime_day);
        TscNode node = AndroidTscDefine.spToTscNode(AndroidTscDefine.getSharedPreferences(this));
        FinalDb db = AndroidTscDefine.getFinalDb(this);
        gbtTimeBases = db.findAllByWhere(GbtTimeBase.class,"deviceId = '"+node.getId()+"'");
        gbtSchedules = db.findAllByWhere(GbtSchedule.class,"deviceId = '"+node.getId()+"'");
        initTimeBaseID();
        initSchedules();


        sp_schedule = (Spinner) findViewById(R.id.sp_day_schedule);
        adapter_schedule = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,schedules);
        adapter_schedule.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_schedule.setAdapter(adapter_schedule);
        sp_schedule.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                /* 将所选mySpinner 的值带入myTextView 中*/
                Toast.makeText(BasetimeDayActivity.this, "您选择的是：" + adapter.getItem(arg2), Toast.LENGTH_LONG).show();
                // myTextView.setText("您选择的是：" + adapter.getItem(arg2));
                /* 将mySpinner 显示*/
                arg0.setVisibility(View.VISIBLE);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                Toast.makeText(BasetimeDayActivity.this, "您选择的是：NONE", Toast.LENGTH_LONG).show();
                arg0.setVisibility(View.VISIBLE);
            }
        });
 /*下拉菜单弹出的内容选项触屏事件处理*/
        sp_schedule.setOnTouchListener(new Spinner.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                /**
                 *
                 */
                return false;
            }
        });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
        sp_schedule.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

            }
        });

        mySpinner = (Spinner)findViewById(R.id.sp_day_basetime_id);
        //第二步：为下拉列表定义一个适配器，这里就用到里前面定义的list。
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        mySpinner.setAdapter(adapter);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                /* 将所选mySpinner 的值带入myTextView 中*/
                Toast.makeText(BasetimeDayActivity.this,"您选择的是：" + adapter.getItem(arg2),Toast.LENGTH_LONG).show();
                // myTextView.setText("您选择的是：" + adapter.getItem(arg2));
                /* 将mySpinner 显示*/
                arg0.setVisibility(View.VISIBLE);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                Toast.makeText(BasetimeDayActivity.this,"您选择的是：NONE",Toast.LENGTH_LONG).show();
                arg0.setVisibility(View.VISIBLE);
            }
        });
        /*下拉菜单弹出的内容选项触屏事件处理*/
        mySpinner.setOnTouchListener(new Spinner.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                /**
                 *
                 */
                return false;
            }
        });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
        mySpinner.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

            }
        });
    }
    public void initTimeBaseID(){
        for(int i=1;i<=40;i++){
            list.add(i+"");
        }
    }
    /**
     * 将数据加载到LIST中，以便Spinner的使用
     */
    public void initSchedules(){
        Iterator<GbtSchedule> gbtScheduleIterator = gbtSchedules.iterator();
        while(gbtScheduleIterator.hasNext()){
            GbtSchedule schedule = gbtScheduleIterator.next();
            if(schedule.getEventId() != 0){
                int scheduleId = schedule.getScheduleId();
                schedules.add(String.valueOf(scheduleId));
            }

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.basetime_day, menu);
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
    public void btDayBtnSubmit(View view){
        Toast.makeText(this,"功能未开发，请联系厂家！",Toast.LENGTH_LONG).show();
    }
    public void btDayBtnRead(View view){
        Toast.makeText(this,"功能未开发，请联系厂家！",Toast.LENGTH_LONG).show();
    }
}
