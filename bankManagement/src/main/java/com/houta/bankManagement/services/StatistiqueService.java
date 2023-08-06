package com.houta.bankManagement.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public interface StatistiqueService {
    Map<LocalDate, BigDecimal> findSumTransactionByDate( LocalDate startDate,LocalDate endDate,Integer userId);

    BigDecimal getAccountBalance(Integer userId);

    BigDecimal hiaghestTransfert(Integer userId);

    BigDecimal highestDeposit(Integer userId);
}
