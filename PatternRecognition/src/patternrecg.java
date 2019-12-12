import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;
import java.awt.*;
public class patternrecg {
        public static void main(String[] args) throws IOException {
          int days=90;


        List<Data> objects1 = new ArrayList<>();
        String url1 = "http://chartdata1.internet.aastocks.com/servlet/iDataServlet/getdaily?id=110000.HK&type=24&market=1&level=1&period=56&encoding=utf8";
        objects1 = extract_info.getinfo(url1, "/2019");


        objects1 = objects1.subList(objects1.size() - (days), objects1.size());
        System.out.println("reference time period is - " +objects1.get(0).getDate()+" - "+objects1.get(days-1).getDate());


        List<Double> t1 = new ArrayList<>();
        for (Data object : objects1) {
                //System.out.println(object.getClose());
                t1.add(object.getClose());
        }

        distance_cal.normalize(t1);



                // always set t1 as the curve or the template
                double max_score = 0;
                double hold_cost1;
                double hold_cost2;
                String hold_date = "";
                String stock_code = "";
                double[][] distance;
                String[] years = {"/2019", "/2018", "/2017", "/2016", "/2015"};
                String[] stocks = {"00001.HK",
                        "00002.HK",
                        "00003.HK",
                        "00005.HK",
                        "00006.HK",
                        "00011.HK",
                        "00012.HK",
                        "00016.HK",
                        "00017.HK",
                        "00019.HK",
                        "00027.HK",
                        "00066.HK",
                        "00083.HK",
                        "00101.HK",
                        "00151.HK",
                        "00175.HK",
                        "00267.HK",
                        "00288.HK",
                        "00386.HK",
                        "00388.HK",
                        "00669.HK",
                        "00688.HK",
                        "00700.HK",
                        "00762.HK",
                        "00823.HK",
                        "00857.HK",
                        "00883.HK",
                        "00939.HK",
                        "00941.HK",
                        "01038.HK",
                        "01044.HK",
                        "01088.HK",
                        "01093.HK",
                        "01109.HK",
                        "01113.HK",
                        "01177.HK",
                        "01299.HK",
                        "01398.HK",
                        "01928.HK",
                        "01997.HK",
                        "02007.HK",
                        "02018.HK",
                        "02313.HK",
                        "02318.HK",
                        "02319.HK",
                        "02382.HK",
                        "02388.HK",
                        "02628.HK",
                        "03328.HK",
                        "03988.HK"};


                for (String stock : stocks) {
                        List<Data> objects2 = new ArrayList<>();
                        String url2 = "http://chartdata1.internet.aastocks.com/servlet/iDataServlet/getdaily?id=" + stock + "&type=24&market=1&level=1&period=56&encoding=utf8";
                        for (String year : years) {
                                objects2 = extract_info.getinfo(url2, year);

                                for (int i = 0; i < objects2.size() - days; i++)
                                {
                                        List<Data> objects3;
                                        objects3 = objects2.subList(i, i + days);
                                        List<Double> t2 = new ArrayList<>();
                                        for (Data object : objects3) {
                                                //System.out.println(object.getClose());
                                                t2.add(object.getClose());
                                        }

                                 distance_cal.normalize(t2);

// use this part of the code while reading data from a csv file
//        List<Data> objects1= DTW.readFromCSV("00001.csv");
//        List<Data> objects2=DTW.readFromCSV("00030.csv");


// get the closing prices of the reference
//            for (int i = 0; i < objects2.size() - 10; i = i + 10) {
//                List<Double> t2 = new ArrayList<>();
//                for (Data object : objects2.subList(i, i + 10)) {
//                    //System.out.println(object.getClose());
//                   t2.add(object.getClose());
//                }
                                distance = distance_cal.distance_calculate(t2, t1);
                                hold_cost1 = accumulated_cost.warping(distance, t1.size(), t2.size(), objects3.get(0).getDate(), objects3.get(days-1).getDate());
                                hold_cost2 = max_acc_cost.warping_max(distance, t1.size(), t2.size());
//                                System.out.println("Similarity score is :" + (1 - (hold_cost1 / hold_cost2)));

                                        if (max_score < (1 - (hold_cost1 / hold_cost2)))
                                        {
                                                max_score = (1 - (hold_cost1 / hold_cost2));
                                                hold_date = objects3.get(0).getDate() + " - " + objects3.get(days-1).getDate();
                                                stock_code=stock;
                                        }


                                }
                        }
                }

                        System.out.print(hold_date + "\t");
                        System.out.print("Max similarity score is : " + max_score +"\t");
                        System.out.println("for Stock :"+stock_code);


                }

}



