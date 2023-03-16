package com.wissen.ProducerConsumer.Service;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public interface ConsumerService {

    void consumeFile(String consumerFileLocation, String fileName) throws IOException, CsvValidationException;
    int getDayProfits(String day);
}
