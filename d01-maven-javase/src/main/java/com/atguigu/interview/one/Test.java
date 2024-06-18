package com.atguigu.interview.one;

/***
 * @author : chen wei
 * @date   : 2024/5/9 0:35
 * @Version: 1.0
 * @Description   : 
 *
 */
public class Test {
    byte[] data = {0x02, // STX
            0x31,0x32,0x10,0x02,0x33, // Data 31 32 02 33
            0x03, // ETX
            0x31^0x32^0x02^0x33^0x03}; // LRC calculated from the data (with the DLE removed) plus the ETX

    public boolean isValid() {
        int stxIndex = getSTX();
        if (stxIndex == -1) {
            return false; // 没有找到STX，数据流无效
        }
        int etxIndex = getETX();
        if (etxIndex == -1 || etxIndex <= stxIndex) {
            return false; // 没有找到ETX或ETX在STX之前，数据流无效
        }
        // 假设有效消息至少包含STX和ETX，所以长度至少为3
        if (etxIndex - stxIndex < 2) {
            return false; // 消息长度不足，数据流无效
        }
        return true; // 数据流有效
    }

    public int getSTX() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == (byte) 0x02){
                return i;
            }
        }
        return -1;	//可修改此行
    }

    public int getETX() {
        for (int i = data.length - 1; i >= 0; i--) {
            if (data[i] == (byte) 0x03) {
                return i; // 返回最近的有效消息的结束位置
            }
        }
        return -1;	//可修改此行
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("STX at:"+test.getSTX()+" ETX at:"+test.getETX()+" is Message Valid:"+(((test.isValid())?"Y":"N")));

    }
}
