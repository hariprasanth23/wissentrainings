package com.wissen.ProducerConsumer.Service;

import com.wissen.ProducerConsumer.Entity.StockData;

import java.io.IOException;

public interface ProducerService {

    void produceFile(String fileName, String fileType, String fileLocation) throws IOException;

    void save(StockData stockData);
}
