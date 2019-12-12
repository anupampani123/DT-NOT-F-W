import java.util.ArrayList;
import java.util.List;

class accumulated_cost {


    private static double [][]acc_cost= new double [400][400];
    static double warping ( double [][] distance, int t1size,int t2size,String date1, String date2)
{   double hold_path_size;
        acc_cost[0][0]=distance[0][0];
        for(int i=1;i<t2size;i++)
            acc_cost[0][i]=distance[0][i]+acc_cost[0][i-1];
        for(int j=1;j<t1size;j++)
            acc_cost[j][0]=distance[j][0]+acc_cost[j-1][0];

        for(int i=1;i<t2size;i++)
        {
            for(int j=1;j<t1size;j++)
            {
                acc_cost[i][j]= distance[i][j]+ Math.min(acc_cost[i-1][j-1],Math.min(acc_cost[i-1][j],acc_cost[i][j-1]));
            }
        }


        //backtracking
        List<path> objects=new ArrayList<>();

        //holds the path which we are going to take while backtracking to find the least accumulated cost



        double cost=0;
        int i= t2size-1;
        int j=t1size-1;
        path object= new path(i,j);
        objects.add(object);

        while (i>0 || j>0) {
            if (i == 0)
                j = j - 1;
            else {
                if (j == 0)
                    i = i - 1;
                else {
//                    double min= Math.min(acc_cost[i - 1][j], acc_cost[i][j - 1]);
//                    min=Math.min(min,acc_cost[i-1][j-1]);
//                    System.out.print(min);


                    if (acc_cost[i - 1][j] <= acc_cost[i][j - 1] && acc_cost[i - 1][j] <= acc_cost[i-1][j - 1] )
                    {i = i - 1;

                    }
                    else {
                        if (acc_cost[i][j-1] <= acc_cost[i-1][j] && acc_cost[i][j-1] <= acc_cost[i-1][j - 1]) {
                            j = j - 1;

                        }
                        else {
                            i = i - 1;
                            j = j - 1;

                        }
                    }
                }
            }
            path object1 = new path(i, j);
//            System.out.print(acc_cost[i][j]);
            objects.add(object1);
        }

//        path object2= new path(0,0);
//        objects.add(object2);

        hold_path_size=objects.size();
        for (path obj:objects)
        {
            int x=obj.getx();
            int y=obj.gety();
            cost=cost+distance[x][y];
//            System.out.print(x+","+y +"\n");
        }
//        cost=cost/(Math.max(t1size,t2size));


//        System.out.print("Time period: "+date1+" - "+date2+"\t");
//        System.out.print("Cost is :"+ cost+ "\t");
//        System.out.println("Test-normalized cost is : "+ cost/(hold_path_size));
        return cost;

//
//        for(int b=t1size-1;b>=0;b--)
//        {
//            for(int a=0;a<t2size;a++)
//            {
//                System.out.print(acc_cost[a][b]+"    ");
//            }
//            System.out.print("\n");
////            System.out.print("end \n");
//        }


        }








    }




