/*
 * 文件名称：MessageUtil.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180412 08:17
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180412-01         Rushing0711     M201804120817 新建文件
 ********************************************************************************/
package com.coding.sell.utils;

import com.coding.sell.DO.TextMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 消息格式转换工具.
 *
 * <p>创建时间: <font style="color:#00FFFF">20180412 08:18</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
public class MessageUtil {

    /**
     * xml转换为Map集合.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180412 08:25</font><br>
     * [请在此输入功能详述]
     *
     * @param request -
     * @return java.util.Map<java.lang.String,java.lang.String>
     * @throws IOException -
     * @throws DocumentException -
     * @author Rushing0711
     * @since 1.0.0
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request)
            throws IOException, DocumentException {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();

        InputStream ins = request.getInputStream();
        Document doc = reader.read(ins);

        Element root = doc.getRootElement();
        List<Element> list = root.elements();

        for (Element e : list) {
            map.put(e.getName(), e.getText());
        }
        ins.close();
        return map;
    }

    /**
     * 将文本消息对象转换为xml.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180412 08:35</font><br>
     * [请在此输入功能详述]
     *
     * @param textMessage -
     * @return java.lang.String
     * @author Rushing0711
     * @since 1.0.0
     */
    public static String textMessageToXml(TextMessage textMessage) {
        XStream xStream = new XStream();
        xStream.toXML(textMessage);
        return null;
    }
}
