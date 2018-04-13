package com.ajennings.fizzbuzz;

import java.util.*;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.joining;

public class FizzBuzzGenerator {

    public static final String DELIMITER = " ";
    private static final String REPORT_DELIMITER = " ";
    private static final String REPORT_PREFIX = " ";
    private static final String REPORT_SUFFIX = "";

    public static final String LUCKY = "lucky";
    public static final String FIZZ_BUZZ = "fizzbuzz";
    public static final String FIZZ = "fizz";
    public static final String BUZZ = "buzz";
    public static final String INTEGER = "integer";

    public static final String LUCKY_TRIGGER = "3";

    List<String> mapKeys = Arrays.asList(FIZZ, BUZZ, FIZZ_BUZZ, LUCKY, INTEGER);

    protected int[] constructRange(int start, int end)
    {
        return IntStream.range(start, end).toArray();

    }

    protected String handleFizzBuzz(int start, int end)
    {
        Map<String, Integer> reportHandler = createReport();
        return IntStream.range(start, end + 1)
                .mapToObj(this::parseNumber)
                .peek(stringValue -> updateReport(reportHandler, stringValue))
                .collect(joining(DELIMITER));
    }
    protected String handleFizzBuzzWithReport(int start, int end)
    {
        Map<String, Integer> reportHandler = createReport();
        return IntStream.range(start, end + 1)
                .mapToObj(this::parseNumber)
                .peek(stringValue -> updateReport(reportHandler, stringValue))
                .collect(joining(REPORT_PREFIX, REPORT_SUFFIX, REPORT_DELIMITER))
                .concat(reportWriter(reportHandler));
    }

    private String reportWriter(Map<String, Integer> reportHanlder)
    {
        return mapKeys.stream()
                .map(key -> String.format("%s : %s", key, reportHanlder.get(key)))
                .collect(joining(DELIMITER));
    }

    private Map<String, Integer> createReport()
    {
        Map<String, Integer> report = new HashMap<>();

        mapKeys.forEach(key -> report.put(key, 0));

        return report;
    }

    protected void updateReport(Map<String, Integer> reportHandler, String value)
    {
        switch (value)
        {
            case FIZZ:
            case BUZZ:
            case FIZZ_BUZZ:
            case LUCKY:
                reportHandler.computeIfPresent(value, (key, occurrences) -> occurrences + 1);
                break;
            default:
                reportHandler.computeIfPresent(INTEGER, (key, occurrences) -> occurrences + 1);
        }

    }

    protected String parseNumber(int number)
    {
        if (isLucky(number))
        {
            return LUCKY;
        }
        else if (isFizzBuzz(number))
        {
            return FIZZ_BUZZ;
        }
        else if (isFizz(number))
        {
            return FIZZ;
        }
        else if (isBuzz(number))
        {
            return BUZZ;
        }
        else
        {
            return "" + number;
        }
    }

    protected boolean isFizz(int number)
    {
        return number % 3 == 0;
    }

    protected boolean isBuzz(int number)
    {
        return number % 5 == 0;
    }

    protected boolean isFizzBuzz(int number)
    {
        return number % 15 == 0;
    }

    protected boolean isLucky(Integer number)
    {
        return number.toString().contains(LUCKY_TRIGGER);
    }
}
