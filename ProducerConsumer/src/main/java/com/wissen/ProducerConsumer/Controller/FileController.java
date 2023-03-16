package com.wissen.ProducerConsumer.Controller;

import com.opencsv.exceptions.CsvValidationException;
import com.wissen.ProducerConsumer.Entity.StockData;
import com.wissen.ProducerConsumer.Repository.StockRepository;
import com.wissen.ProducerConsumer.Service.ConsumerService;
import com.wissen.ProducerConsumer.Service.ProducerService;
import com.wissen.ProducerConsumer.Utility.Constant;
import com.wissen.ProducerConsumer.Utility.Utility;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class FileController {

    Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    ProducerService producerService;

    @Autowired
    ConsumerService consumerService;

    @Autowired
    StockRepository stockRepository;

    @Scheduled(cron = Constant.PRODUCER_CRON_EXPRESSION)
    public void producerScheduler() throws IOException{

        logger.info("inside producer Scheduler");

        producerService.produceFile(Constant.PRODUCER_FILE_NAME , Constant.PRODUCER_FILE_TYPE , Constant.PRODUCER_FILE_LOCATION);
    }

    @Scheduled(cron = Constant.CONSUMER_CRON_EXPRESSION)
    public void fileConsumer() throws CsvValidationException, IOException {
        List<String> fileNameList = Utility.getFileNames(Constant.CONSUMER_FILE_LOCATION);

        logger.info("inside consumer Scheduler");

        if( fileNameList.size()>0){
            String fileName = fileNameList.get(0);

            logger.info(fileName);

            consumerService.consumeFile(Constant.CONSUMER_FILE_LOCATION + fileName, fileName);

//            File fileToDelete = new File(Constant.CONSUMER_FILE_LOCATION + fileName);
//            fileToDelete.delete();

        }
    }

    @GetMapping(Constant.GET_DAY_PROFITS)
    public int getDayProfits(@PathVariable String day){
        return consumerService.getDayProfits(day);
    }

    @PostMapping("/saveStockData")
    public StockData postStockData(@RequestBody @Valid StockData stockData){
        return stockRepository.save(stockData);
    }

}
