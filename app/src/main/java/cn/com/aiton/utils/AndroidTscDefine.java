package cn.com.aiton.utils;

import android.content.SharedPreferences;

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
        editor.putString("deviceName",node.getDeviceName());
        editor.putString("ipAddress",node.getIpAddress());
        editor.putString("version",node.getVersion());
        editor.putInt("groupId",node.getGroupId());
        editor.putInt("groupSequence",node.getGroupSequence());
        editor.putInt("linkType",node.getLinkType());
        editor.putInt("port",node.getPort());
        editor.putInt("protocolType",node.getProtocolType());
        editor.putFloat("latitude",(float)node.getLatitude());
        editor.putFloat("longitude",(float)node.getLongitude());
        editor.commit();
        return true;
    }
    public static List<Map<String,Object>> listScheduleToListMap(List<GbtSchedule> gbtSchedules){
        List<Map<String,Object>> maps  = new ArrayList<Map<String,Object>>();
        Iterator<GbtSchedule> gbtScheduleIterator = gbtSchedules.iterator();
        while(gbtScheduleIterator.hasNext()){
            Map<String,Object> map = new HashMap<String, Object>();
            GbtSchedule gbtSchedule = gbtScheduleIterator.next();
            map.put("auxOut",gbtSchedule.getAuxOut());
            map.put("beginHour",gbtSchedule.getBeginHour());
            map.put("beginMinute",gbtSchedule.getBeginMinute());
            map.put("controlMode",gbtSchedule.getControlMode());
            map.put("deviceId",gbtSchedule.getDeviceId());
            map.put("eventId",gbtSchedule.getEventId());
            map.put("id",gbtSchedule.getId());
            map.put("scheduleId",gbtSchedule.getScheduleId());
            map.put("specialOut",gbtSchedule.getSpecialOut());
            map.put("timePatternId",gbtSchedule.getTimePatternId());
            maps.add(map);
        }
        return maps;
    }
    public static List<GbtSchedule> listMapToListSchedule(List<Map<String,Object>> maps){
        List<GbtSchedule> gbtSchedules = new ArrayList<GbtSchedule>();
        Iterator<Map<String,Object>> mapIterator = maps.iterator();
        while(mapIterator.hasNext()){
            GbtSchedule gbtSchedule = new GbtSchedule();
            Map<String,Object> map = mapIterator.next();
            gbtSchedule.setScheduleId(Integer.parseInt((String) map.get("scheduleId")));
            gbtSchedule.setEventId(Integer.parseInt((String)map.get("eventId")));
            gbtSchedule.setBeginHour(Integer.parseInt((String)map.get("beginHour")));
            gbtSchedule.setBeginMinute(Integer.parseInt((String)map.get("beginMinute")));
            gbtSchedule.setAuxOut(Integer.parseInt((String)map.get("auxOut")));
            gbtSchedule.setControlMode((Integer.parseInt((String)map.get("controlMode"))));
            gbtSchedule.setSpecialOut(Integer.parseInt((String)map.get("specialOut")));
            gbtSchedule.setTimePatternId(Integer.parseInt((String)map.get("timePatternId")));
            gbtSchedule.setDeviceId(Integer.parseInt((String)map.get("deviceId")));
            gbtSchedule.setId(Integer.parseInt((String)map.get("id")));
            gbtSchedules.add(gbtSchedule);
        }

        return gbtSchedules;
    }
}
