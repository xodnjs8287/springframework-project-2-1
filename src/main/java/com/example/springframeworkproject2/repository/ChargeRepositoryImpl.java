package com.example.springframeworkproject2.repository;

import com.example.springframeworkproject2.domain.DataParser;
import com.example.springframeworkproject2.domain.FileLoad;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;


@Repository
public class ChargeRepositoryImpl implements ChargeRepository {


	private final DataParser dataParser;
	private List<FileLoad> fileLoads;

	public ChargeRepositoryImpl(DataParser dataParser) {
		this.dataParser = dataParser;
	}

	@Override
	public void loadData(String filePath) {
		this.fileLoads = dataParser.parse(filePath);
	}

	@Override
	public List<FileLoad> findCharge(int totalWaterUsage) {
		if (Objects.isNull(fileLoads)) {
			throw new IllegalStateException("파일을 로드하지 않았습니다.");
		}

		List<FileLoad> list = new ArrayList<>();
		for (FileLoad fileLoad : fileLoads) {
			if (totalWaterUsage <= fileLoad.getEndSection() && fileLoad.getStartSection() >= totalWaterUsage) {
				list.add(fileLoad);
			}
		}

		list = fileLoads.stream().sorted((a,b) -> a.getSectionPrice()-b.getSectionPrice()).collect(Collectors.toList());

		return list;

	}


}
