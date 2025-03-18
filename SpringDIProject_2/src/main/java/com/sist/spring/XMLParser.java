package com.sist.spring;
import java.lang.reflect.Method;
import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 *   XML 파싱 
 *     = DOM 
 *       속도가 늦다 => 메모리 트리 형태로 저장 / CRUD 
 *     = SAX : MyBatis / Spring 
 *       속도가 빠르다 => 태그의 값/속성 값만 읽기 
 *       이벤트 
 *       
 *          <?xml version="1.0" encoding="UTF-8"?> startDocument()
			<beans> startElement()
			  <bean id="sa" class="com.sist.spring.Sawon"> startElement()
			    <property name="name" value="홍길동"/>
			    startElement()               endElement()
			    <property name="sex" value="남자"/>
			    startElement()               endElement()
			    <property name="age" value="25"/>
			    startElement()               endElement()
			  </bean> endElement()
			</beans> endElement()
			endDocument()
 */
public class XMLParser extends DefaultHandler{
    Map clsMap=new HashMap();
    Object obj;
    Class clsName;
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try
		{
			if(qName.equals("bean"))
			{
				String id=attributes.getValue("id");
				String cls=attributes.getValue("class");
				clsName=Class.forName(cls);
				obj=clsName.getDeclaredConstructor().newInstance();
				// 클래스이름으로 제어 (변수주입 , 객체 생성 / 메소즈 호출)
				clsMap.put(id, obj); // 사용시에는 형변환 
			}
			// DI => setter DI
			if(qName.equals("property"))
			{
				String name=attributes.getValue("name");
				String value=attributes.getValue("value");
				// Method 호출 => setName setSex setAge
				Method[] methods=clsName.getDeclaredMethods();
				for(Method m:methods)
				{
					if(m.getName().equalsIgnoreCase("set"+name))
					{
						if(name.equals("age"))
						{
							m.invoke(obj, Integer.parseInt(value));
						}
						else
						{
							m.invoke(obj,value);
							// sa.setName("홍길동")
						}
					}
				}
			}
		}catch(Exception ex) {}
	}
    
    
}
