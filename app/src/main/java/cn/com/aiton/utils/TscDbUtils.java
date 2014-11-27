package cn.com.aiton.utils;

import net.tsz.afinal.FinalDb;

import java.util.ArrayList;
import java.util.List;

import cn.com.aiton.domain.GbtChannel;
import cn.com.aiton.domain.GbtDirec;
import cn.com.aiton.domain.TscNode;

/**
 * Created by Administrator on 2014/11/27.
 */
public class TscDbUtils {
    public static List<GbtDirec> getGbtDirecsByNode(FinalDb db,TscNode node){
        List<GbtDirec> gbtDirecs = new ArrayList<GbtDirec>();
        gbtDirecs = db.findAllByWhere(GbtDirec.class,"deviceId = '"+node.getId()+"'");
        return gbtDirecs;
    }
    public static List<GbtChannel> getGbtChannelsByNode(FinalDb db,TscNode node){
        List<GbtChannel> gbtChannels = new ArrayList<GbtChannel>();

        gbtChannels = db.findAllByWhere(GbtChannel.class,"deviceId = '"+node.getId()+"'");
        return gbtChannels;
    }
    public static List<TscNode> getTscNodeByIPAddress(FinalDb db,String ipaddress){
        List<TscNode> tscNodes = db.findAllByWhere(TscNode.class,"ipAddress = '"+ipaddress+"'");
        return  tscNodes;
    }
}
