package com.wissen.ProducerConsumer.Service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.wissen.ProducerConsumer.Entity.StockData;
import com.wissen.ProducerConsumer.Repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ConsumerServiceImpl implements ConsumerService {

    Logger logger = LoggerFactory.getLogger(ConsumerServiceImpl.class);

    @Autowired
    StockRepository stockRepository;

    @Override
    public void consumeFile(String consumerFileLocation,String fileName) throws IOException, CsvValidationException {
        CSVReader reader = new CSVReaderBuilder(new FileReader(consumerFileLocation)).build();
        String [] nextLine;

        logger.info("inside consume file Reader ");

        while ((nextLine = reader.readNext()) != null) {
            if(!nextLine[0].equals("Date") && !(nextLine[0].isEmpty() || nextLine[0].isBlank()) ){
                StockData stockData = new StockData(nextLine[0],fileName,nextLine[1],Integer.parseInt(nextLine[2]),Integer.parseInt(nextLine[3]),Integer.parseInt(nextLine[4]),nextLine[5]);
                stockRepository.save(stockData);
            }
        }
    }

    @Override
    public int getDayProfits(String day) {
        int totalProfit = 0 ;
        List<Integer> allprofits = stockRepository.findByDate(day)
                .stream().map(e->e.getTotalProfit()).collect(Collectors.toList());
        for(int i: allprofits){
            totalProfit = totalProfit + i ;
        }
        return totalProfit;
    }


}
