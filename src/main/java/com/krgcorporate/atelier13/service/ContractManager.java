package com.krgcorporate.atelier13.service;

import com.krgcorporate.atelier13.domain.Contract;

import java.util.List;
import java.util.Optional;

public interface ContractManager {

    List<Contract> findAll(long limit, long skip);

    Optional<Contract> findByRef(String ref);

    Contract save(Contract contract);
}
