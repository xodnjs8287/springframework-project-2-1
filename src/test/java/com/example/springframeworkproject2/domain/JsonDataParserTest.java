package com.example.springframeworkproject2.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JsonDataParserTest {

	private JsonDataParser jsonDataParser;

	@Test
	@DisplayName("json 파일로 부터 FileLoad 리스트를 읽는다.")
	void readFromJsonFile() {
		jsonDataParser = new JsonDataParser();
		List<FileLoad> fileLoads = jsonDataParser.parse("src/test/resources/Tariff_20220331.json");

		assertAll(
			() -> assertThat(fileLoads).extracting(FileLoad::getCity)
				.containsExactlyInAnyOrder("동두천시", "동두천시", "동두천시", "동두천시", "동두천시", "동두천시", "동두천시", "동두천시", "동두천시", "동두천시", "동두천시", "파주시", "파주시", "파주시", "파주시",
					"파주시", "파주시", "파주시", "파주시", "파주시", "파주시", "파주시", "파주시", "광주시", "광주시", "광주시", "광주시", "광주시", "광주시", "광주시", "광주시", "광주시", "광주시", "광주시", "광주시", "양주시", "양주시", "양주시", "양주시", "양주시",
					"양주시", "양주시", "양주시", "단양군", "단양군", "단양군"),
			() -> assertThat(fileLoads).extracting(FileLoad::getSectionPrice)
				.containsExactlyInAnyOrder(690, 1090, 1530, 1410, 1480, 1560, 1700, 1090, 1200, 510, 640, 570, 760, 1110, 1110, 1330, 1500, 1620, 780, 1050, 1160, 1250, 1110, 400, 570, 920, 890, 1110,
					1250, 1390, 1470, 760, 970, 1110, 1220, 539, 879, 1218, 1125, 1488, 1840, 1312, 726, 890, 1304, 2019)
		);
	}

	@Test
	@DisplayName("json 파일로 아니면 예외가 발생한다.")
	void throwExceptionWhenNotJsonFileInput() {
		jsonDataParser = new JsonDataParser();
		assertThrows(IllegalArgumentException.class, () -> jsonDataParser.parse("Tariff_20220331.csv"));
	}
}
