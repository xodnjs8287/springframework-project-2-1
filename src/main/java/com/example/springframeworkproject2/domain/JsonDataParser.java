package com.example.springframeworkproject2.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class JsonDataParser implements DataParser {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public List<FileLoad> parse(String filePath) {
		if (!filePath.endsWith(".json")) {
			throw new IllegalArgumentException("json 파일만 읽을 수 있습니다.");
		}
		try {
			return List.of(objectMapper.readValue(new File(filePath), FileLoad[].class));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}
