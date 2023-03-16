package com.wissen.ProducerConsumer.Utility;

public class Constant {

    private Constant()
    {

    }

    public static final String PRODUCER_FILE_NAME = "producerFile";
    public static final String PRODUCER_FILE_TYPE = ".csv";
    public static final String PRODUCER_CRON_EXPRESSION = "*/3 * * * * *";
    public static final String PRODUCER_FILE_LOCATION = "C:\\Users\\HP Akash\\OneDrive\\wissen projects\\ProducerConsumer\\src\\main\\resources\\producer\\";

    public static final String CONSUMER_FILE_LOCATION = "C:\\Users\\HP Akash\\OneDrive\\wissen projects\\ProducerConsumer\\src\\main\\resources\\producer\\";
    public static final String CONSUMER_FILE_NAME = "producerFile1.csv";
    public static final String FILE_CONSUMER = "/fileConsume";
    public static final String GET_DAY_PROFITS = "/getdayProfits/{day}";
    public static final String CONSUMER_CRON_EXPRESSION = "*/10 * * * * *";

}
