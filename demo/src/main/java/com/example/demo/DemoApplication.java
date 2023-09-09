package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

		Map aa = new HashMap();
		aa.put("aa",1);

		Map<String, String> map = new LinkedHashMap<>(10,1,true);
		map.put("apple", "苹果");
		map.put("watermelon", "西瓜");
		map.put("banana", "香蕉");
		map.put("peach", "桃子");

		map.put("apple", "苹果2");

		map.get("banana");
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}

}
