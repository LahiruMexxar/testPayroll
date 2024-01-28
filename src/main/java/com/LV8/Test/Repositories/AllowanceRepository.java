package com.LV8.Test.Repositories;

import com.LV8.Test.Models.Allowance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AllowanceRepository extends JpaRepository<Allowance,Long> {
    List<Allowance> getAllAllowancesByMonth(String month);

    List<Allowance> getAllAllowancesByDateGreaterThanAndDateLessThan(Date startdate,Date enddate);
}
