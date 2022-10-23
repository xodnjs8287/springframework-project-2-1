package com.example.springframeworkproject2.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

import com.example.springframeworkproject2.domain.FileLoad;
import com.example.springframeworkproject2.repository.ChargeRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WaterUsageChargeServiceImplTest {

	private WaterUsageChargeServiceImpl waterUsageChargeService;

	@Mock
	private ChargeRepository chargeRepository;

	@Test
	@DisplayName("요금 계산을 하면 물사용량과 단위 요금의 곱을 계산한다.")
	void mpboksayx() {
		waterUsageChargeService = new WaterUsageChargeServiceImpl(chargeRepository);
		List<FileLoad> fileLoads = Arrays.asList(
			new FileLoad(6, "동두천시", "일반용", 3, 301, 1000, 1560),
			new FileLoad(9, "동두천시", "일반용(미)", 2, 1001, 9999999, 1200)
		);
		given(chargeRepository.findCharge(eq(1000))).willReturn(fileLoads);

		List<FileLoad> results = waterUsageChargeService.calculate(1000);

		assertThat(results).extracting(FileLoad::getCharge).containsExactlyInAnyOrder(1560000, 1200000);
	}
}
