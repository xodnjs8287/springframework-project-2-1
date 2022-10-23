package com.example.springframeworkproject2.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DataParserImplTest {

	private DataParserImpl dataParser;

	@Mock
	private CsvDataParser csvDataParser;

	@Mock
	private JsonDataParser jsonDataParser;

	@Test
	@DisplayName("파일 확장자가 csv로 끝나면 csvDataParser가 호출된다.")
	void csvDataParserCalled() {
		dataParser = new DataParserImpl(csvDataParser, jsonDataParser);
		dataParser.parse("test.csv");

		verify(csvDataParser, times(1)).parse(eq("test.csv"));
		verify(jsonDataParser, times(0)).parse(eq("test.csv"));
	}

	@Test
	@DisplayName("파일 확장자가 json로 끝나면 csvDataParser가 호출된다.")
	void jsonDataParserCalled() {
		dataParser = new DataParserImpl(csvDataParser, jsonDataParser);
		dataParser.parse("test.json");

		verify(csvDataParser, times(0)).parse(eq("test.json"));
		verify(jsonDataParser, times(1)).parse(eq("test.json"));
	}

	@Test
	@DisplayName("파일 확장자가 csv, json 둘다 아니면 에러가 발생한다.")
	void throwExceptionWhenDataFileIsError() {
		dataParser = new DataParserImpl(csvDataParser, jsonDataParser);
		assertThrows(IllegalArgumentException.class, () -> dataParser.parse("test.text"));
	}
}
