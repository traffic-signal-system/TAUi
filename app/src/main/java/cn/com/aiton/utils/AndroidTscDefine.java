package cn.com.aiton.utils;

import android.content.Context;
import android.content.SharedPreferences;

import net.tsz.afinal.FinalDb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.com.aiton.domain.GbtSchedule;
import cn.com.aiton.domain.TscNode;

/**
 * Created by Administrator on 2014/11/27.
 */
public class AndroidTscDefine {
    public static final String DBNAME = "tsc.db";
    public static final String TSCNODE = "tscnode";

    public static SharedPreferences getSharedPreferences(Context context){
        return context.getSharedPreferences(AndroidTscDefine.TSCNODE,Context.MODE_PRIVATE);
    }
    public static FinalDb getFinalDb(android.content.Context context){
        return FinalDb.create(context, AndroidTscDefine.DBNAME);
    }

    public static TscNode spToTscNode(SharedPreferences sp){
        TscNode node = new TscNode();
        node.setDeviceName(sp.getString("deviceName", "none"));
        node.setVersion(sp.getString("version","none"));
        node.setIpAddress(sp.getString("ipAddress","none"));
        node.setProtocolType(sp.getInt("protocolType",0));
        node.setPort(sp.getInt("port",5435));
        node.setGroupId(sp.getInt("groupId",0));
        node.setGroupSequence(sp.getInt("groupSequence",0));
        node.setId(sp.getInt("id",0));
        node.setLatitude(sp.getFloat("latitude",0));
        node.setLongitude(sp.getFloat("longitude",0));
        node.setLinkType(sp.getInt("linkType",0));
        return node;
    }
    public static boolean tscNodeToSP(TscNode node,SharedPreferences sp){
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("id", node.getId());
        editor.putString("deviceName", node.getDeviceName());
        editor.putString("ipAddress", node.getIpAddress());
        editor.putString("version", node.getVersion());
        editor.putInt("groupId", node.getGroupId());
        editor.putInt("groupSequence", node.getGroupSequence());
        editor.putInt("linkType", node.getLinkType());
        editor.putInt("port", node.getPort());
        editor.putInt("protocolType", node.getProtocolType());
        editor.putFloat("latitude", (float) node.getLatitude());
        editor.putFloat("longitude", (float) node.getLongitude());
        editor.commit();
        return true;
    }
    public static List<Map<String,String>> listScheduleToListMap(List<GbtSchedule> gbtSchedules){
        List<Map<String,String>> maps  = new ArrayList<Map<String,String>>();
        Iterator<GbtSchedule> gbtScheduleIterator = gbtSchedules.iterator();
        while(gbtScheduleIterator.hasNext()){
            Map<String,String> map = new HashMap<String, String>();
            GbtSchedule gbtSchedule = gbtScheduleIterator.next();
            map.put("auxOut",String.valueOf(gbtSchedule.getAuxOut()));
            map.put("beginHour",String.valueOf(gbtSchedule.getBeginHour()));
            map.put("beginMinute",String.valueOf(gbtSchedule.getBeginMinute()));
            map.put("controlMode",intToDetail(String.valueOf(gbtSchedule.getControlMode())));
            map.put("deviceId",String.valueOf(gbtSchedule.getDeviceId()));
            map.put("eventId",String.valueOf(gbtSchedule.getEventId()));
            map.put("id",String.valueOf(gbtSchedule.getId()));
            map.put("scheduleId",String.valueOf(gbtSchedule.getScheduleId()));
            map.put("specialOut",String.valueOf(gbtSchedule.getSpecialOut()));
            map.put("timePatternId",String.valueOf(gbtSchedule.getTimePatternId()));
            maps.add(map);
        }
        return maps;
    }

    /**
     *
     * @param map
     * @return
     */
    public static GbtSchedule mapToSchedule(Map<String,String> map){
        GbtSchedule gbtSchedule = new GbtSchedule();
        gbtSchedule.setScheduleId(Integer.parseInt((String) map.get("scheduleId")));
        gbtSchedule.setEventId(Integer.parseInt((String)map.get("eventId")));
        gbtSchedule.setBeginHour(Integer.parseInt((String)map.get("beginHour")));
        gbtSchedule.setBeginMinute(Integer.parseInt((String)map.get("beginMinute")));
        gbtSchedule.setAuxOut(Integer.parseInt((String)map.get("auxOut")));
        gbtSchedule.setControlMode((Integer.parseInt(detailToInt((String)map.get("controlMode")))));
        gbtSchedule.setSpecialOut(Integer.parseInt((String)map.get("specialOut")));
        gbtSchedule.setTimePatternId(Integer.parseInt((String)map.get("timePatternId")));
        gbtSchedule.setDeviceId(Integer.parseInt((String)map.get("deviceId")));
        gbtSchedule.setId(Integer.parseInt((String) map.get("id")));
        return gbtSchedule;
    }

    /**
     *
     * @param gbtSchedule
     * @return
     */
    public static Map<String,String> scheduleToMap(GbtSchedule gbtSchedule){
        Map<String,String> map = new HashMap<String, String>();
        map.put("auxOut", String.valueOf(gbtSchedule.getAuxOut()));
        map.put("beginHour", String.valueOf(gbtSchedule.getBeginHour()));
        map.put("beginMinute", String.valueOf(gbtSchedule.getBeginMinute()));
        map.put("controlMode", intToDetail(String.valueOf(gbtSchedule.getControlMode())));
        map.put("deviceId", String.valueOf(gbtSchedule.getDeviceId()));
        map.put("eventId", String.valueOf(gbtSchedule.getEventId()));
        map.put("id", String.valueOf(gbtSchedule.getId()));
        map.put("scheduleId", String.valueOf(gbtSchedule.getScheduleId()));
        map.put("specialOut", String.valueOf(gbtSchedule.getSpecialOut()));
        map.put("timePatternId", String.valueOf(gbtSchedule.getTimePatternId()));
        return map;
    }
    public static List<GbtSchedule> listMapToListSchedule(List<Map<String,String>> maps){
        List<GbtSchedule> gbtSchedules = new ArrayList<GbtSchedule>();
        Iterator<Map<String,String>> mapIterator = maps.iterator();
        while(mapIterator.hasNext()){
            GbtSchedule gbtSchedule = new GbtSchedule();
            Map<String,String> map = mapIterator.next();
            gbtSchedule.setScheduleId(Integer.parseInt((String) map.get("scheduleId")));
            gbtSchedule.setEventId(Integer.parseInt((String)map.get("eventId")));
            gbtSchedule.setBeginHour(Integer.parseInt((String)map.get("beginHour")));
            gbtSchedule.setBeginMinute(Integer.parseInt((String)map.get("beginMinute")));
            gbtSchedule.setAuxOut(Integer.parseInt((String)map.get("auxOut")));
            gbtSchedule.setControlMode((Integer.parseInt(detailToInt((String)map.get("controlMode")))));
            gbtSchedule.setSpecialOut(Integer.parseInt((String)map.get("specialOut")));
            gbtSchedule.setTimePatternId(Integer.parseInt((String)map.get("timePatternId")));
            gbtSchedule.setDeviceId(Integer.parseInt((String)map.get("deviceId")));
            gbtSchedule.setId(Integer.parseInt((String)map.get("id")));
            gbtSchedules.add(gbtSchedule);
        }

        return gbtSchedules;
    }

    public static String intToDetail(String i){
        if(i.equals("0")){
            return "????????????";
        }else if(i.equals("1")){
            return "??????";
        }else if(i.equals("2")){
            return "??????";
        }else if(i.equals("3")){
            return "??????";
        }else if(i.equals("6")){
            return "??????";
        }else if(i.equals("7")){
            return "???????????????";
        }else if(i.equals("8")){
            return "????????????";
        }else if(i.equals("9")){
            return "?????????";
        }else if(i.equals("11")){
            return "????????????";
        }else if(i.equals("12")){
            return "????????????";
        }else if(i.equals("13")){
            return "????????????";
        }else{
            return "????????????";
        }
    }

    public static String timePatternIntToDetail(int i){
        if (i==1){
            return "??????1";
        }else if(i==2){
            return "??????2";
        }else if(i==3){
            return "??????3";
        }else if(i==4){
            return "??????4";
        }else if(i==5){
            return "??????5";
        }else if(i==6){
            return "??????6";
        }else if(i==7){
            return "??????7";
        }else if(i==8){
            return "??????8";
        }else if(i==9){
            return "??????9";
        }else if(i==10){
            return "??????10";
        }else if(i==11){
            return "??????11";
        }else if(i==12){
            return "??????12";
        }else if(i==13){
            return "??????13";
        }else if(i==14){
            return "??????14";
        }else if(i==15){
            return "??????15";
        }else if(i==16){
            return "??????16";
        }else if(i==17){
            return "??????17";
        }else if(i==18){
            return "??????18";
        }else if(i==19){
            return "??????19";
        }else if(i==20){
            return "??????20";
        }else if(i==21){
            return "??????21";
        }else if(i==22){
            return "??????22";
        }else if(i==23){
            return "??????23";
        }else if(i==24){
            return "??????24";
        }else if(i==25){
            return "??????25";
        }else if(i==26){
            return "??????26";
        }else if(i==27){
            return "??????27";
        }else if(i==28){
            return "??????28";
        }else if(i==29){
            return "??????29";
        }else if(i==30){
            return "??????30";
        }else if(i==31){
            return "??????31";
        }else if(i==32){
            return "??????32";
        }else{
            return "??????0";
        }
    }

    public static int timePatternDetailToInt(String string){
        if (string.equals("??????1")){
            return 1;
        }else if(string.equals("??????2")){
            return 2;
        }else if(string.equals("??????3")){
            return 3;
        }else if(string.equals("??????4")){
            return 4;
        }else if(string.equals("??????5")){
            return 5;
        }else if(string.equals("??????6")){
            return 6;
        }else if(string.equals("??????7")){
            return 7;
        }else if(string.equals("??????8")){
            return 8;
        }else if(string.equals("??????9")){
            return 9;
        }else if(string.equals("??????10")){
            return 10;
        }else if(string.equals("??????11")){
            return 11;
        }else if(string.equals("??????12")){
            return 12;
        }else if(string.equals("??????13")){
            return 13;
        }else if(string.equals("??????14")){
            return 14;
        }else if(string.equals("??????15")){
            return 15;
        }else if(string.equals("??????16")){
            return 16;
        }else if(string.equals("??????17")){
            return 17;
        }else if(string.equals("??????18")){
            return 18;
        }else if(string.equals("??????19")){
            return 19;
        }else if(string.equals("??????20")){
            return 20;
        }else if(string.equals("??????21")){
            return 21;
        }else if(string.equals("??????22")){
            return 22;
        }else if(string.equals("??????23")){
            return 23;
        }else if(string.equals("??????24")){
            return 24;
        }else if(string.equals("??????25")){
            return 25;
        }else if(string.equals("??????26")){
            return 26;
        }else if(string.equals("??????27")){
            return 27;
        }else if(string.equals("??????28")){
            return 28;
        }else if(string.equals("??????29")){
            return 29;
        }else if(string.equals("??????30")){
            return 30;
        }else if(string.equals("??????31")){
            return 31;
        }else if(string.equals("??????32")){
            return 32;
        }else{
            return 0;
        }
    }

    public static String detailToInt(String str){

        if(str.equals("????????????")){
            return "0";
        }else if(str.equals("??????")){
            return "1";
        }else if(str.equals("??????")){
            return "2";
        }else if(str.equals("??????")){
            return "3";
        }else if(str.equals("??????")){
            return "6";
        }else if(str.equals("?????????")){
            return "9";
        }else if(str.equals("???????????????")){
            return "7";
        }else if(str.equals("????????????")){
            return "11";
        }else if(str.equals("????????????")){
            return "8";
        }else if(str.equals("????????????")){
            return "12";
        }else if(str.equals("????????????")){
            return "13";
        }else{
            return "0";
        }
    }
}
