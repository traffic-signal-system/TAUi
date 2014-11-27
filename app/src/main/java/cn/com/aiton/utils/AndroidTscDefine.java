package cn.com.aiton.utils;

import android.content.SharedPreferences;

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
}
