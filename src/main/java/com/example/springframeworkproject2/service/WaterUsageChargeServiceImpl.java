package com.example.springframeworkproject2.service;

import com.example.springframeworkproject2.domain.FileLoad;
import com.example.springframeworkproject2.repository.ChargeRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
public class WaterUsageChargeServiceImpl implements WaterUsageChargeService {

    private final ChargeRepository chargeRepository;

    public WaterUsageChargeServiceImpl(ChargeRepository chargeRepository) {
        this.chargeRepository = chargeRepository;
    }

    @Override
    public List<FileLoad> calculate(int waterUsage) {

        List<FileLoad> charge = chargeRepository.findCharge(waterUsage);

        charge.forEach(e -> e.setCharge(waterUsage * e.getSectionPrice()));

        return charge;
    }

}
