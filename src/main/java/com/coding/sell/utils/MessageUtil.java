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
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Date;
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
@Slf4j
public class MessageUtil {

    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_IMAGE = "image";
    public static final String MESSAGE_VOICE = "voice";
    public static final String MESSAGE_VIDEO = "video";
    public static final String MESSAGE_LINK = "link";
    public static final String MESSAGE_LOCATION = "location";
    public static final String MESSAGE_EVENT = "event";
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    public static final String MESSAGE_unsubscribe = "unsubscribe";
    public static final String MESSAGE_CLICK = "CLICK";
    public static final String MESSAGE_VIEW = "VIEW";

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
        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();

        InputStream ins = request.getInputStream();
        Document doc = reader.read(ins);

        Element root = doc.getRootElement();
        // 格式化输出
        OutputFormat formater = OutputFormat.createPrettyPrint();
        formater.setEncoding("UTF-8");
        StringWriter out = new StringWriter();
        XMLWriter writer = new XMLWriter(out, formater);
        writer.write(doc);
        writer.close();
        log.info("【微信接收消息】请求消息={}", out.toString());

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
        xStream.alias("xml", textMessage.getClass());
        String result = xStream.toXML(textMessage);
        log.info("【微信接收消息】应答消息={}", result);
        return result;
    }

    /**
     * 菜单.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180416 08:32</font><br>
     * [请在此输入功能详述]
     *
     * @param
     * @return java.lang.String
     * @author Rushing0711
     * @since 1.0.0
     */
    public static String menuText() {
        StringBuffer sb = new StringBuffer();
        sb.append("欢迎您的关注，请按照菜单提示进行操作：\n\n");
        sb.append("1、课程介绍\n");
        sb.append("2、慕课网介绍\n");
        sb.append("回复？调出此菜单。\n");
        return sb.toString();
    }

    public static String initText(String toUserName, String fromUserName, String content) {
        TextMessage textMessage = new TextMessage();
        textMessage.setFromUserName(toUserName);
        textMessage.setToUserName(fromUserName);
        textMessage.setMsgType(MessageUtil.MESSAGE_TEXT);
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setContent("您发送的消息是：" + content);
        return MessageUtil.textMessageToXml(textMessage);
    }
}
