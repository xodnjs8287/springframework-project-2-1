package com.example.springframeworkproject2.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

import com.example.springframeworkproject2.domain.DataParser;
import com.example.springframeworkproject2.domain.FileLoad;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ChargeRepositoryImplTest {

	private ChargeRepositoryImpl chargeRepository;

	@Mock
	private DataParser dataParser;

	@Test
	@DisplayName("요금표 저장소에서 요금을 찾을 때 로드 되지 않았으면 예외를 던진다.")
	void throwExceptionWhenFilesAreNotLoaded() {
		chargeRepository = new ChargeRepositoryImpl(dataParser);

		assertThrows(IllegalStateException.class, () -> chargeRepository.findCharge(123));
	}

	@Test
	@DisplayName("요금표 저장소에서 요금을 찾을때 물 사용량 구간에 해당 되는 요금표들만 찾아준다.")
	void aznicdnnp() {
		List<FileLoad> fileLoads = Arrays.asList(
			new FileLoad(1, "동두천시", "가정용", 1, 1, 20, 690),
			new FileLoad(2, "동두천시", "가정용", 2, 21, 30, 1090),
			new FileLoad(3, "동두천시", "가정용", 3, 31, 999999, 1530),
			new FileLoad(4, "동두천시", "일반용", 1, 1, 100, 1410),
			new FileLoad(5, "동두천시", "일반용", 2, 101, 300, 1480),
			new FileLoad(6, "동두천시", "일반용", 3, 301, 1000, 1560),
			new FileLoad(7, "동두천시", "일반용", 4, 1001, 999999, 1700),
			new FileLoad(8, "동두천시", "일반용(미)", 1, 1, 1000, 1090),
			new FileLoad(9, "동두천시", "일반용(미)", 2, 1001, 9999999, 1200),
			new FileLoad(10, "동두천시", "전용공업용", 1, 1, 999999, 510),
			new FileLoad(11, "동두천시", "발전용", 1, 1, 999999, 640),
			new FileLoad(12, "파주시", "가정용", 1, 1, 20, 570),
			new FileLoad(13, "파주시", "가정용", 2, 21, 30, 760),
			new FileLoad(14, "파주시", "가정용", 3, 31, 9999999, 1110),
			new FileLoad(15, "파주시", "일반용", 1, 1, 50, 1110)
		);
		chargeRepository = new ChargeRepositoryImpl(dataParser);
		given(dataParser.parse(eq("test"))).willReturn(fileLoads);
		chargeRepository.loadData("test");

		List<FileLoad> results = chargeRepository.findCharge(1000);

		assertAll(
			() -> assertThat(results).extracting(FileLoad::getCity).containsExactlyInAnyOrder("동두천시", "동두천시"),
			() -> assertThat(results).extracting(FileLoad::getSector).containsExactlyInAnyOrder("일반용", "일반용(미)"),
			() -> assertThat(results).extracting(FileLoad::getSectionPrice).containsExactlyInAnyOrder(1700, 1200)
		);
	}
}
