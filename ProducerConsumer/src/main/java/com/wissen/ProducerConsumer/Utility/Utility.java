package com.wissen.ProducerConsumer.Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utility {

    public static List<String> getFileNames(String filePath) throws IOException {
        Stream<Path> fileList = Files.list(Paths.get(filePath));
        List<String> fileNames = fileList.filter(file -> !Files.isDirectory(file))
                .map(Path::getFileName)
                .map(Path::toString)
                .collect(Collectors.toList());
        return fileNames;
    }

}
