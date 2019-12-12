import java.util.List;

 class stats_summary {


    public static double Mean(List<Double> t)
    {   double sum=0;
        for(int i=0;i<t.size();i++)
        {
            sum=sum+t.get(i);
        }
        return sum/t.size();
    }

    public static double std(List<Double>t)
    {
        double sum=0;
        double mean=Mean(t);
        for(Double i:t)
        {
            sum=sum + Math.pow(i-mean,2);
        }
        return Math.sqrt(sum/(t.size()-1));

    }


}
