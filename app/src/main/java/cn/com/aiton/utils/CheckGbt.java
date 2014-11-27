package cn.com.aiton.utils;

/**
 * Created by Administrator on 14-2-14.
 */
public class CheckGbt {
    public static boolean check(byte[] bytes,String fun)
    {
        if (bytes[0] == 0x86)
        {
            if (bytes[1] == 0x05)
            {
              //  MessageBox.Show(fun+":国标通信协议错误类型中的其它错误原因！");
                return false;
            }
            else if (bytes[1] == 0x01)
            {
               // MessageBox.Show(fun + ":国标通信协议错误类型中的消息长度太长！");
                return false;
            }
            else if (bytes[1] == 0x02)
            {
               // MessageBox.Show(fun + ":国标通信协议错误类型中的消息类型错误！");
                return false;
            }
            else if (bytes[1] == 0x03)
            {
               /// MessageBox.Show(fun + ":国标通信协议错误类型中的消息设置对象值超出规定的范围！");
                return false;
            }
            else if (bytes[1] == 0x04)
            {
              //  MessageBox.Show(fun + ":国标通信协议错误类型中的消息长度太短！");
                return false;
            }
            else
            {
               // MessageBox.Show(fun + ":未知原因！");
                return false;
            }
        }
        return true;
    }
}
