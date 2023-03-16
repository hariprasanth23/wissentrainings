package com.wissen.ProducerConsumer.Entity;

import com.wissen.ProducerConsumer.validation.ValidateMarketType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class StockData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String date;
    private String fileName;
    private String stockName;
    private int buyingPrice;
    private int sellingPrice;
    private int totalProfit;

    @ValidateMarketType
    private String marketType;

    public StockData(String date,String fileName,String stockName,int buyingPrice,int sellingPrice,int totalProfit,String marketType){
        this.date = date;
        this.fileName = fileName;
        this.stockName = stockName;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.totalProfit = totalProfit;
        this.marketType = marketType;
    }


}

