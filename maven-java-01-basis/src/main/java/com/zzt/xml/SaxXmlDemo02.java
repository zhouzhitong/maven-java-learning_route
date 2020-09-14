package com.zzt.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * 描述：<br> SAX 方式
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/14 11:35
 */
public class SaxXmlDemo02 {


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //1.或去SAXParserFactory实例
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.获取SAXparser实例
        SAXParser saxParser = factory.newSAXParser();
        //创建Handel对象
        SAXDemoHandel handel = new SAXDemoHandel();
        saxParser.parse("src/main/resources/demo.xml",handel);
    }

    private static class SAXDemoHandel extends DefaultHandler {
        //遍历xml文件开始标签
        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            System.out.println("sax解析开始");
        }

        //遍历xml文件结束标签
        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
            System.out.println("sax解析结束");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            if ("student".equals(qName)) {
                System.out.println("============开始遍历student=============");
                //System.out.println(attributes.getValue("rollno"));
            } else if (!"class".equals(qName)) {
                System.out.print("节点名称:" + qName + "----");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
            if ("student".equals(qName)) {
                System.out.println(qName + "遍历结束");
                System.out.println("============结束遍历student=============");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);
            String value = new String(ch, start, length).trim();
            if (!"".equals(value)) {
                System.out.println(value);
            }
        }
    }

}
