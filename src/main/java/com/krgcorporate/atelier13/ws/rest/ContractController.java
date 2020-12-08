package com.krgcorporate.atelier13.ws.rest;

import com.krgcorporate.atelier13.domain.Contract;
import com.krgcorporate.atelier13.service.ContractManager;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("contracts")
@AllArgsConstructor(access = AccessLevel.PACKAGE, onConstructor_ = @Autowired)
public class ContractController {

    private final ContractManager contractManager;

    @GetMapping
    public List<Contract> findAll(
            @RequestParam(value = "limit", defaultValue = "10") long limit,
            @RequestParam(value = "skip", defaultValue = "0") long skip
    ) {
        return contractManager.findAll(limit, skip);
    }

    @GetMapping("/{ref}")
    public Optional<Contract> findOne(@PathVariable String ref) {
        return contractManager.findByRef(ref);
    }

    @PostMapping
    public Contract post(@RequestBody Contract contract) {
        return contractManager.save(contract);
    }
}
