package cn.com.aiton.taui;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;


public class PhaseActivity extends ActivityGroup {
    protected Button btn_leftTop, btn_rightTop;
    protected TextView tv_head;

    private static LocalActivityManager manager;
    private RadioGroup radioGroup;
    private LinearLayout container;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_phase);
        context = this;
        manager = getLocalActivityManager();
        container = (LinearLayout) findViewById(R.id.container);
        radioGroup = (RadioGroup) this.findViewById(R.id.add_tab_group);

        container.removeAllViews();
        container.addView(manager.startActivity(
                "PAGE_1",
                new Intent(context, ManaulActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                .getDecorView());

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.main_tab_basetime://添加考试
                        container.removeAllViews();
                        container.addView(manager.startActivity(
                                "PAGE_0",
                                new Intent(context, BasetimeActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                                .getDecorView());
                        break;
                    case R.id.main_tab_manual://我的考试
                        container.removeAllViews();
                        container.addView(manager.startActivity(
                                "PAGE_1",
                                new Intent(context, ManaulActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                                .getDecorView());
                        break;
                    case R.id.main_tab_phase://我的考试
                        container.removeAllViews();
                        container.addView(manager.startActivity(
                                "PAGE_2",
                                new Intent(context, PhaseConfigActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                                .getDecorView());
                        break;
                    case R.id.main_tab_collision://我的通知
                        container.removeAllViews();
                        container.addView(manager.startActivity(
                                "PAGE_3",
                                new Intent(context, CollisionActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                                .getDecorView());
                        break;
                    case R.id.main_tab_stage://测试
                        container.removeAllViews();
                        container.addView(manager.startActivity(
                                "PAGE_4",
                                new Intent(context, StageActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                                .getDecorView());
                        break;
                    case R.id.main_tab_detector://设置
                        container.removeAllViews();
                        container.addView(manager.startActivity(
                                "PAGE_5",
                                new Intent(context, DetectorActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                                .getDecorView());
                        break;
                    case R.id.main_tab_checklight://设置
                        container.removeAllViews();
                        container.addView(manager.startActivity(
                                "PAGE_6",
                                new Intent(context, LampCheckActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                                .getDecorView());
                        break;
                    default:
                        //tabHost.setCurrentTabByTag("我的考试");
                        break;
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phase, menu);
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
