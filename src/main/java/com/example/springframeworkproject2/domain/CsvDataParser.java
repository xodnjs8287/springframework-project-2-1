package com.example.springframeworkproject2.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;


@Component
public class CsvDataParser implements DataParser {

	@Override
	public List<FileLoad> parse(String filePath) {
		if (!filePath.endsWith(".csv")) {
			throw new IllegalArgumentException("csv 파일만 읽을 수 있습니다.");
		}
		List<FileLoad> fileLoads = new ArrayList<>();
		try (
			InputStream inputStream = new ClassPathResource(filePath).getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));


		) {

			String line;
			line= "hello";
			while ((line = reader.readLine()) != null) {

				String[] splitStrings = line.split(",");
				if (splitStrings[0].equals(" 순번 ")) {
					continue;
				}

				fileLoads.add(new FileLoad(Integer.parseInt(splitStrings[0]), splitStrings[1], splitStrings[2], Integer.parseInt(splitStrings[3]), Integer.parseInt(splitStrings[4]),
					Integer.parseInt(splitStrings[5]), Integer.parseInt(splitStrings[6])));
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return fileLoads;
	}
}
