package com.example.springframeworkproject2.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CsvDataParserTest {

	private CsvDataParser csvDataParser;

	@Test
	@DisplayName("csv 파일로 부터 파일을 읽는다.")
	void readFromCsvFile() {
		csvDataParser = new CsvDataParser();
		List<FileLoad> fileLoads = csvDataParser.parse("Tariff_20220331.csv");

		assertAll(
			() -> assertThat(fileLoads).extracting(FileLoad::getCity)
				.containsExactlyInAnyOrder(" 동두천시 ", " 파주시 ", " 광주시 ", " 양주시 ", " 단양군 ", " 서산시 ", " 논산시 ", " 정읍시 ", " 나주시 "),
			() -> assertThat(fileLoads).extracting(FileLoad::getSectionPrice)
				.containsExactlyInAnyOrder(690, 570, 1110, 1312, 890, 1710, 2390, 990, 433)
		);
	}

	@Test
	@DisplayName("csv 파일로 아니면 예외가 발생한다.")
	void throwExceptionWhenNotCsvFileInput() {
		csvDataParser = new CsvDataParser();
		assertThrows(IllegalArgumentException.class, () -> csvDataParser.parse("Tariff_20220331.json"));
	}
}
