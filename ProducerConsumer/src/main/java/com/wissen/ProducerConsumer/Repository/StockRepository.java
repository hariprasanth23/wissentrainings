package com.wissen.ProducerConsumer.Repository;

import com.wissen.ProducerConsumer.Entity.StockData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StockRepository extends JpaRepository<StockData,Integer> {

    List<StockData> findByDate(String date);
}
