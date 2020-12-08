package com.krgcorporate.atelier13.service.impl;

import com.krgcorporate.atelier13.domain.Contract;
import com.krgcorporate.atelier13.service.ContractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContractManagerImpl implements ContractManager {

    private final List<Contract> contracts;

    @Autowired
    ContractManagerImpl() {
        this.contracts = new ArrayList<>();
    }

    @Override
    public List<Contract> findAll(long limit, long skip) {
        return contracts
                .stream()
                .skip(skip)
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Contract> findByRef(String ref) {
        return contracts.stream()
                .filter(contract -> contract.getRef().equals(ref))
                .findFirst();
    }

    @Override
    public Contract save(Contract contract) {
        contracts.remove(contract);
        contracts.add(contract);
        return findByRef(contract.getRef())
                .orElseThrow(() -> new IllegalStateException("contract" + contract.getRef() + " not found"));
    }
}
