import java.util.List;
 class CID {

 //complexity estimate for relative comparison
 //refer to paper: https://www.cs.ucr.edu/~eamonn/Complexity-Invariant%20Distance%20Measure.pdf



    public static double complexity_estimate(List<Double>t1)
    {   double CE=0;
        for (int i=0;i<t1.size()-1;i++)
        {
            CE=CE + Math.pow((t1.get(i)-t1.get(i+1)),2);


        }
        CE=Math.sqrt(CE);
//        System.out.println("CE is "+ CE);
        return CE;
    }

    public static double correlation_factor(double CE1, double CE2)
    {
        return ( (Math.max(CE1,CE2)) /(Math.min(CE1,CE2)) );
    }



}
