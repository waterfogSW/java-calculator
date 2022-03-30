package com.waterfogsw.repository;

import com.waterfogsw.domain.Calculation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MemoryCalculationRepository implements CalculationRepository {
    private final Map<Long, Calculation> store = new LinkedHashMap<>();

    private Long calIdx = 0L;

    @Override
    public void save(String formula, String result) {
        Calculation calculation = new Calculation(calIdx, formula, result);
        store.put(calculation.getId(), calculation);
        incrIdx();
    }

    @Override
    public Calculation findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Calculation> findAll() {
        return new ArrayList<>(store.values());
    }

    private void incrIdx() {
        calIdx++;
    }
}
