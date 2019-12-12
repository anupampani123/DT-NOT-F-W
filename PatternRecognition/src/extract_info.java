import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class extract_info {


//used for extracting information from the webpage , string s is the url and num_days is the number of days for which
// data is required
//important- works only for AAstockscharts. For other pages make appropriate changes
    static List<Data> getinfo(String s,String year) throws IOException {

        List<Data> result = new ArrayList<>();
        Document doc = Jsoup.connect(s).get();
        Elements links = doc.select("body");
        String[] arr = links.text().split("\\|");
        for (String a : arr) {
            if (a.contains(year)) {
                String[] arr1 = a.split(";");
                if (arr1.length == 7) {
                    result.add(Data.createobj(arr1));
                }
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Collections.sort(result,(o1,o2)->{
            try {
                return sdf.parse(o1.getDate()).compareTo(sdf.parse(o2.getDate()));
            } catch (Exception e) {
                return -1;
            }

        });

        return result;
    }
}
