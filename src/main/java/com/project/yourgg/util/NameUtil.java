package com.project.yourgg.util;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Component;

@Component
public class NameUtil {

	// Name Encoding
	public String NameEncode(String name) {
		String enName = "";
		try {
			// UTF-8 인코딩 처리
			enName = URLEncoder.encode(name, StandardCharsets.UTF_8);
			// '+'를 '%20'으로 변환
			enName = enName.replace("+", "%20");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enName;
	}

}
