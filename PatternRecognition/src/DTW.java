import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
class DTW {
     //not actually used
    //first we need to read in the reference data i.e the candlestick pattern against which
    //we are gonna compare

     static List<Data> readFromCSV(String fileName)
    {
        List<Data> objects= new ArrayList<>();
        try(BufferedReader br= Files.newBufferedReader(Paths.get(fileName),
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            while(line!=null)
            {
                String [] attributes= line.split(",");

                Data object= createobj(attributes);
                objects.add(object);





                line=br.readLine();
            }
        }


        catch (IOException ex) {
            ex.printStackTrace();
        }


     return objects;
    }

    private static Data createobj(String[] metadata)
   {   //System.out.print(metadata[0]);
        String date = metadata[0];
        float open=Float.parseFloat(metadata[1]);
        float high=Float.parseFloat(metadata[1]);
        float low=Float.parseFloat(metadata[2]);
        float close=Float.parseFloat(metadata[3]);
        float volume=Float.parseFloat(metadata[4]);
        float TO=Float.parseFloat(metadata[5]);

        return new Data(date, open, high,low,close,volume,TO);

    }




    }
