package com.wissen.ProducerConsumer.Service;

import com.opencsv.CSVWriter;
import com.wissen.ProducerConsumer.Entity.StockData;
import com.wissen.ProducerConsumer.Repository.StockRepository;
import com.wissen.ProducerConsumer.Utility.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class ProducerServiceImpl implements ProducerService{

    @Autowired
    StockRepository stockRepository;

    @Override
    public void produceFile(String fileName, String fileType, String fileLocation) throws IOException {

        CSVWriter csvWriter = null;
        List<String> fileNames = Utility.getFileNames(fileLocation);
        int fileNumber = 0;

        if(fileNames.isEmpty()){
            csvWriter = new CSVWriter(new FileWriter(fileLocation+fileName+fileType));
        }else if(fileNames.size() <= 50){
            fileNumber = fileNumberGenerator(fileNames,fileType,fileName);
            log.info(" fileNumber Count -->" + fileNumber);
            csvWriter = new CSVWriter(new FileWriter(fileLocation+fileName+fileNumber+fileType));
        }

        if(fileNames.size() <= 50){
            boolean dataInsertionDone = dataInsertion(csvWriter);
            if(dataInsertionDone){
                log.info(" Data has been successfully inserted into "+ fileName+fileNumber);
            }

        }

    }

    @Override
    public void save(StockData stockData) {
        stockRepository.save(stockData);
    }


    public int fileNumberGenerator(List<String> fileNames,String fileType,String fileName){
        List<Integer> names = fileNames.stream().map(e->e.replace(fileType,"")
                        .replace(fileName,""))
                .filter(e-> "" !=e)
                .map(e->Integer.parseInt(e)).sorted()
                .collect(Collectors.toList());
        int fileNumber = names.size() == 0 ? 1 : (names.get(names.size()-1))+1;
        return fileNumber;
    }

    public Boolean dataInsertion(CSVWriter csvWriter) throws IOException {
        int row = new Random().nextInt(1,10);

        csvWriter.writeNext(new String[]{"Date","StockName","StockBuy","StockSell","Profit","MarketType"});
        csvWriter.writeNext(new String[]{"","","","",""});

        for(int i =0;i<row;i++){
            int buyingPrice = new Random().nextInt(100,1000);
            int sellingPrice = new Random().nextInt(500,1500);
            String marketType = new Random().nextInt(2) == 0 ? "USA":"Indian";
            csvWriter.writeNext(
                    new String[]{
                            "Day "+new Random().nextInt(1,4),
                            "Stock"+i,
                            ""+buyingPrice,
                            ""+sellingPrice,
                            ""+(sellingPrice-buyingPrice),
                            marketType
                    });
            }
        csvWriter.close();
        return true;
    }

}
