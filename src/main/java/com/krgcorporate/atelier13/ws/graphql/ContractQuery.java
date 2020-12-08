package com.krgcorporate.atelier13.ws.graphql;

import com.krgcorporate.atelier13.domain.Contract;
import com.krgcorporate.atelier13.service.ContractManager;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class ContractQuery implements GraphQLQueryResolver {

    private final ContractManager contractManager;

    ContractQuery(ContractManager contractManager) {
        this.contractManager = contractManager;
    }

    public List<Contract> findAllContracts(long limit, long skip) {
        log.debug("findAllContracts");
        return contractManager.findAll(limit, skip);
    }

    public Optional<Contract> findOneContract(String ref) {
        log.debug("findOneContract");
        return contractManager.findByRef(ref);
    }
}
