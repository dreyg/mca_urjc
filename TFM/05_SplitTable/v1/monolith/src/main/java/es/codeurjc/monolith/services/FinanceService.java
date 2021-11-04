package es.codeurjc.monolith.services;

import es.codeurjc.monolith.dtos.requests.CustomerRequestDto;
import es.codeurjc.monolith.dtos.requests.FinanceRequestDto;
import es.codeurjc.monolith.dtos.responses.FinanceResponseDto;

import java.util.Collection;

public interface FinanceService {

    Collection<FinanceResponseDto> findAll();

    FinanceResponseDto save(FinanceRequestDto financeRequestDto);

    FinanceResponseDto findById(long userId);

    FinanceResponseDto delete(long userId);

}
