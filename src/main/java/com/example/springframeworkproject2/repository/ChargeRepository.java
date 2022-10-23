package com.example.springframeworkproject2.repository;

import com.example.springframeworkproject2.domain.FileLoad;
import java.util.List;

public interface ChargeRepository {


   void loadData(String filePath);

   List<FileLoad> findCharge(int totalWaterUsage);
}
