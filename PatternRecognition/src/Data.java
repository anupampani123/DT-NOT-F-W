public class Data{

    private String date;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;
    private double TO;

    public Data(String date, double open , double high, double low, double close, double volume, double TO)
    {
        this.date=date;
        this.open=open;
        this.high=high;
        this.low=low;
        this.close=close;
        this.volume=volume;
        this.TO=TO;
    }
    public double getClose()
    {
        return this.close;
    }
    public String getDate() {return date;}
//    @Override
//    public String toString() {
//        return "Data [date=" + date+ ", open=" + open + ", close=" + close + "]";
//    }
    public static Data createobj(String[] metadata)
    {   //System.out.print(metadata[0]);
        String date = metadata[0];
        double open=Double.parseDouble(metadata[1]);
        double high=Double.parseDouble(metadata[1]);
        double low=Double.parseDouble(metadata[2]);
        double close=Double.parseDouble(metadata[3]);
        double volume=Double.parseDouble(metadata[4]);
        double TO=Double.parseDouble(metadata[5]);

        return new Data(date, open, high,low,close,volume,TO);

    }



}
