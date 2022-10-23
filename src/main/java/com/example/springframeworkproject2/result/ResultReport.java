package com.example.springframeworkproject2.result;

import com.example.springframeworkproject2.domain.FileLoad;
import java.util.List;

public interface ResultReport {
    List<FileLoad> print(List<FileLoad> charts);
}
