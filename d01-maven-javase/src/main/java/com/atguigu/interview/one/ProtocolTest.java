package com.atguigu.interview.one;/*
 * com.atguigu.interview.one.ProtocolTest.java
 *
 * Author: Dr. Ho
 * 
 * YXSmart - Java test for SE
 *
 */

public class ProtocolTest
{
    private byte[] data = null;	//数据流(stream)
    
    /**
     * 默认constructor，请勿删除
     */
    public ProtocolTest()
    {
    }
    
    /**
     * 
     * @param data: 数据流(stream)
     */
    public void setData(byte[] data)
    {
        this.data = data;
    }
    
    /**
     * TODO 实现该方法
     * @return boolean: 该数据流(stream)是否含有有效消息(message)
     */
    public boolean isValid() 
    {		
        /*
		  Write your code here...
		*/


        return false;	//可修改此行
    }

    /**
     * @TODO 实现该方法
     * @return int: 最后一个有效数据的开始index
     */
    public int getSTX() 
    {
		/*
		  Write your code here...
		*/

		
		return -1;	//可修改此行
    }

    /**
     * @TODO 实现该方法
     * @return int: 最后一个有效数据的结束index
     */
    public int getETX() 
    {
        /*
		  Write your code here...
		*/
		
		return -1;	//可修改此行
    }
}


