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
    private byte[] data = null;	//������(stream)
    
    /**
     * Ĭ��constructor������ɾ��
     */
    public ProtocolTest()
    {
    }
    
    /**
     * 
     * @param data: ������(stream)
     */
    public void setData(byte[] data)
    {
        this.data = data;
    }
    
    /**
     * TODO ʵ�ָ÷���
     * @return boolean: ��������(stream)�Ƿ�����Ч��Ϣ(message)
     */
    public boolean isValid() 
    {		
        /*
		  Write your code here...
		*/


        return false;	//���޸Ĵ���
    }

    /**
     * @TODO ʵ�ָ÷���
     * @return int: ���һ����Ч���ݵĿ�ʼindex
     */
    public int getSTX() 
    {
		/*
		  Write your code here...
		*/

		
		return -1;	//���޸Ĵ���
    }

    /**
     * @TODO ʵ�ָ÷���
     * @return int: ���һ����Ч���ݵĽ���index
     */
    public int getETX() 
    {
        /*
		  Write your code here...
		*/
		
		return -1;	//���޸Ĵ���
    }
}


