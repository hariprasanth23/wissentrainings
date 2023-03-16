package Stream.parallelStream;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamDemo {
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("Hello ",
                "G", "E", "E", "K", "S!");

        list.parallelStream().forEach(System.out::print);
    }
}
