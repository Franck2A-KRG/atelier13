package com.krgcorporate.atelier13.ws.graphql;

import com.krgcorporate.atelier13.domain.ActiveStatus;
import com.krgcorporate.atelier13.domain.Contract;
import com.krgcorporate.atelier13.domain.Person;
import com.krgcorporate.atelier13.domain.Status;
import com.krgcorporate.atelier13.domain.TerminatedStatus;
import com.krgcorporate.atelier13.service.ContractManager;
import com.krgcorporate.atelier13.ws.graphql.input.ContractInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContractMutation implements GraphQLMutationResolver {

    private ContractManager contractManager;

    ContractMutation(ContractManager contractManager) {
        this.contractManager = contractManager;
    }

    Contract createContract(ContractInput contractInput) {
        return contractManager.save(Contract.builder()
                .ref(contractInput.getRef())
                .status(ActiveStatus.builder().build())
                .persons(contractInput.getPersons() == null ? Collections.emptyList() : contractInput.getPersons()
                        .stream()
                        .map(personInput -> Person.builder()
                                .firstname(personInput.getFirstname())
                                .lastname(personInput.getLastname())
                                .build())
                        .collect(Collectors.toList()))
                .build());
    }
}
