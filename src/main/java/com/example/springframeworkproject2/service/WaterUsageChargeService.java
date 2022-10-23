package com.example.springframeworkproject2.service;

import com.example.springframeworkproject2.domain.FileLoad;
import java.io.IOException;
import java.util.List;

public interface WaterUsageChargeService {
    List<FileLoad> calculate(int waterUsage) throws IOException;
}
