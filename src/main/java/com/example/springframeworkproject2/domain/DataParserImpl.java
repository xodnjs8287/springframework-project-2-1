package com.example.springframeworkproject2.domain;

import java.util.List;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class DataParserImpl implements DataParser {

	private final CsvDataParser csvDataParser;
	private final JsonDataParser jsonDataParser;

	public DataParserImpl(CsvDataParser csvDataParser, JsonDataParser jsonDataParser) {
		this.csvDataParser = csvDataParser;
		this.jsonDataParser = jsonDataParser;
	}

	@Override
	public List<FileLoad> parse(String filePath) {
		if (filePath.endsWith(".csv")) {
			return csvDataParser.parse(filePath);
		} else if (filePath.endsWith(".json")) {
			return jsonDataParser.parse(filePath);
		} else {
			throw new IllegalArgumentException();
		}
	}
}
