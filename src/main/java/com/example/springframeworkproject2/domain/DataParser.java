package com.example.springframeworkproject2.domain;

import java.util.List;

public interface DataParser {
    List<FileLoad> parse(String filePath);
}
