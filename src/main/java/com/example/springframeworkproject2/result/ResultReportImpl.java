package com.example.springframeworkproject2.result;

import com.example.springframeworkproject2.domain.FileLoad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ResultReportImpl implements ResultReport {
    @Override
    public List<FileLoad> print(List<FileLoad> charts) {

        return charts.stream().sorted((a, b) -> a.getCharge() - b.getCharge()).limit(5).collect(Collectors.toList());

    }

}
