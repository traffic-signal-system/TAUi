package cn.com.aiton.services.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.aiton.domain.GbtLampCheck;
import cn.com.aiton.domain.Message;
import cn.com.aiton.domain.TscNode;
import cn.com.aiton.services.LampCheckService;
import cn.com.aiton.utils.ByteUtils;
import cn.com.aiton.utils.CheckGbt;
import cn.com.aiton.utils.GbtDefine;
import cn.com.aiton.utils.UdpClientSocket;

/**
 * Created by Administrator on 14-2-14.
 */

public class LampCheckServiceImpl implements LampCheckService {
    /**
     * 关闭灯控板1的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public Message setLampCheckCloseOne(TscNode node) {
        Message msg = new Message();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.SET_LAMP_BLOCK_CHECK_COLLISION_ONE_NO_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            System.out.println("服务端回应数据：" + info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }

    /**
     * 关闭灯控板2的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public Message setLampCheckCloseTwo(TscNode node) {
        Message msg = new Message();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.SET_LAMP_BLOCK_CHECK_COLLISION_TWO_NO_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            System.out.println("服务端回应数据：" + info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }

    /**
     * 关闭灯控板3的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public Message setLampCheckCloseThree(TscNode node) {
        Message msg = new Message();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.SET_LAMP_BLOCK_CHECK_COLLISION_THREE_NO_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            System.out.println("服务端回应数据：" + info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }

    /**
     * 关闭灯控板1的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public Message setLampCheckCloseFour(TscNode node) {
        Message msg = new Message();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.SET_LAMP_BLOCK_CHECK_COLLISION_FOUR_NO_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            System.out.println("服务端回应数据：" + info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }

    /**
     * 关闭灯控板1的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public Message setLampCheckCloseFive(TscNode node) {
        Message msg = new Message();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.SET_LAMP_BLOCK_CHECK_COLLISION_FIVE_NO_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            System.out.println("服务端回应数据：" + info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }

    /**
     * 关闭灯控板1的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public Message setLampCheckCloseSix(TscNode node) {
        Message msg = new Message();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.SET_LAMP_BLOCK_CHECK_COLLISION_SIX_NO_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            System.out.println("服务端回应数据：" + info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }

    /**
     * 关闭灯控板1的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public Message setLampCheckCloseSeven(TscNode node) {
        Message msg = new Message();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.SET_LAMP_BLOCK_CHECK_COLLISION_SEVEN_NO_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            System.out.println("服务端回应数据：" + info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }

    /**
     * 关闭灯控板1的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public Message setLampCheckCloseEight(TscNode node) {
        Message msg = new Message();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.SET_LAMP_BLOCK_CHECK_COLLISION_EIGHT_NO_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            System.out.println("服务端回应数据：" + info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }

    /**
     * 关闭灯控板1的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public List<Message> setLampCheckCloseALL(TscNode node) {
        List<Message> messages = new ArrayList<Message>();
        messages.add(this.setLampCheckCloseOne(node));
        messages.add(this.setLampCheckCloseTwo(node));
        messages.add(this.setLampCheckCloseThree(node));
        messages.add(this.setLampCheckCloseFour(node));
        messages.add(this.setLampCheckCloseFive(node));
        messages.add(this.setLampCheckCloseSix(node));
        messages.add(this.setLampCheckCloseSeven(node));
        messages.add(this.setLampCheckCloseEight(node));
        return messages;
    }

    /**
     * 打开灯控板1的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public Message setLampCheckOpenOne(TscNode node) {
        Message msg = new Message();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.SET_LAMP_BLOCK_CHECK_COLLISION_ONE_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            System.out.println("服务端回应数据：" + info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }

    /**
     * 打开灯控板1的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public Message setLampCheckOpenTwo(TscNode node) {
        Message msg = new Message();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.SET_LAMP_BLOCK_CHECK_COLLISION_TWO_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            System.out.println("服务端回应数据：" + info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }

    /**
     * 打开灯控板1的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public Message setLampCheckOpenThree(TscNode node) {
        Message msg = new Message();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.SET_LAMP_BLOCK_CHECK_COLLISION_THREE_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            System.out.println("服务端回应数据：" + info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }

    /**
     * 打开灯控板1的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public Message setLampCheckOpenFour(TscNode node) {
        Message msg = new Message();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.SET_LAMP_BLOCK_CHECK_COLLISION_FOUR_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            System.out.println("服务端回应数据：" + info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }

    /**
     * 打开灯控板1的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public Message setLampCheckOpenFive(TscNode node) {
        Message msg = new Message();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.SET_LAMP_BLOCK_CHECK_COLLISION_FIVE_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            System.out.println("服务端回应数据：" + info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }

    /**
     * 打开灯控板1的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public Message setLampCheckOpenSix(TscNode node) {
        Message msg = new Message();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.SET_LAMP_BLOCK_CHECK_COLLISION_SIX_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            System.out.println("服务端回应数据：" + info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }

    /**
     * 打开灯控板1的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public Message setLampCheckOpenSeven(TscNode node) {
        Message msg = new Message();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.SET_LAMP_BLOCK_CHECK_COLLISION_SEVEN_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            System.out.println("服务端回应数据：" + info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }

    /**
     * 打开灯控板1的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public Message setLampCheckOpenEight(TscNode node) {
        Message msg = new Message();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.SET_LAMP_BLOCK_CHECK_COLLISION_EIGHT_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            System.out.println("服务端回应数据：" + info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }

    /**
     * 打开灯控板1的绿冲突检测
     *
     * @param node
     * @return
     */
    @Override
    public List<Message> setLampCheckOpenALL(TscNode node) {
        List<Message> messages = new ArrayList<Message>();
        messages.add(this.setLampCheckOpenOne(node));
        messages.add(this.setLampCheckOpenTwo(node));
        messages.add(this.setLampCheckOpenThree(node));
        messages.add(this.setLampCheckOpenFour(node));
        messages.add(this.setLampCheckOpenFive(node));
        messages.add(this.setLampCheckOpenSix(node));
        messages.add(this.setLampCheckOpenSeven(node));
        messages.add(this.setLampCheckOpenEight(node));
        return messages;
    }

    /**
     * 得到灯控板1的绿冲突检测数据
     *
     * @param node
     * @return
     */
    @Override
    public List<GbtLampCheck> getLampCheck(TscNode node) {
        List<GbtLampCheck> gbtLampChecks = new ArrayList<GbtLampCheck>();
        try{
            UdpClientSocket client = new UdpClientSocket();
            client.send(node.getIpAddress(), node.getPort(), GbtDefine.GET_LAMP_CHECK);
            String info = client.receive(node.getIpAddress(), node.getPort());
            byte[] bytes = ByteUtils.stringToByteArrayByISO(info);
            if(!CheckGbt.check(bytes).isBoo()){
                return null;
            }
            byte[] objectArray = new byte[bytes[3] * GbtDefine.LAMP_CHECK_BYTE_SIZE];
            System.arraycopy(bytes,4,objectArray,0,objectArray.length);
            byte[][] lampCheckResult = ByteUtils.oneArrayToTwoArray(objectArray,(int)bytes[3],GbtDefine.LAMP_CHECK_BYTE_SIZE);
            GbtLampCheck gbtLampCheck = new GbtLampCheck();
            for(int i=0; i<bytes[3];i++){
                gbtLampCheck.setDeviceId(node.getId());
                gbtLampCheck.setLampId(lampCheckResult[i][0]);
                gbtLampCheck.setLampFlag(lampCheckResult[i][1]);
                gbtLampChecks.add(gbtLampCheck);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return gbtLampChecks;
    }
}
