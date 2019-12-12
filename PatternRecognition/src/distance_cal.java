import java.util.ArrayList;
import java.util.List;

class distance_cal {


    //distance calculation with a Z normalization function

    private static double[][] dist=new double [400][400];
    private static double normalize_val1,normalize_val2, normalize_val=0;


//List<Float> distance = new ArrayList<>();

   static  double[][] distance_calculate(List<Double>t2,List<Double>t1)
    {

        double max1=0;
        double min1=0;
        double max2=0;
        double min2=0;

// in case max min normalization is required, wrap the following lines into a different function
//        for(int i=0;i<t2.size();i++)
//        {
////            normalize_val2=normalize_val2+ Math.pow(t2.get(i),2);
//              if(t2.get(i)>max2)
//                  max2=t2.get(i);
//              if(t2.get(i)<min2)
//                  min2=t2.get(i);
//
//
//        }
//
//        // get maximum value of t1
//
//        for(int i=0;i<t1.size();i++)
//        {
//           // normalize_val1=normalize_val1+ Math.pow(t1.get(i),2);
//
//            if(t1.get(i)>max1)
//                max1=t1.get(i);
//
//            if(t1.get(i)<min1)
//                min1=t1.get(i);
//        }
////
//        for(int i=0;i<t1.size();i++)
//        {
//            t1.set(i,(t1.get(i)-min1)/(max1-min1));
//
//        }
//        for(int i=0;i<t2.size();i++)
//        {
//            t2.set(i,(t2.get(i)-min2)/(max2-min2));
//
//        }


//        for(int i=0;i<t1.size();i++)
//        {
//            t1.set(i,(t1.get(i)-(stats_summary.Mean(t1)))/(stats_summary.std(t1)));
//
//        }
//        for(int i=0;i<t2.size();i++)
//        {
//            t2.set(i,(t2.get(i)-(stats_summary.Mean(t2)))/(stats_summary.std(t2)));
//
//        }






        //normalize_val=Math.pow((normalize_val1+normalize_val2),0.5);
//        float max_f= max1*t1.size();
//
//        System.out.println("this is max : " +max_f+ "\n");






        for(int i=0;i<t2.size();i++)
        {
            for(int j=0;j<t1.size();j++)
            {
//                dist[i][j]= (max_f -  Math.abs( t2.get(i) - t1.get(j)) )/ max_f;
//                dist[i][j]= Math.pow( t2.get(i) - t1.get(j),2) ;
                  dist[i][j]= Math.abs(t2.get(i) - t1.get(j));

            }
        }

        return dist;


    }


    //z normalization function
    static void normalize(List<Double>t1)
    {
        for(int i=0;i<t1.size();i++)
        {
            t1.set(i,(t1.get(i)-(stats_summary.Mean(t1)))/(stats_summary.std(t1)));

        }

    }


}
