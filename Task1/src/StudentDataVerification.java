
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class StudentDataVerification {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here  
        String arr[][]=new String[6][3];
        float Sum =0;
        float MinGpa =4;
        float MaxGpa =0;
        
        for (int i=0;i<6;i++)
        {
            System.out.println("Enter Data of Student: "+ (i+1));  
            
            for(int j=0;j<3;j++)
            {
                if(j==0)
                {
                 System.out.println("Enter Name of Student: "+ (i+1));     
                 Scanner input =new Scanner(System.in);
                 String name = input.nextLine();
                 arr[i][j]=name;
                 
                }
                
                if(j==1)
                {
                 System.out.println("Enter Registration No. of Student: "+ (i+1));     
                 Scanner input =new Scanner(System.in);
                 String reg = input.nextLine();
                 for(int k=0;k<=(i-1);k++)
                 {                                    
                    while(Integer.parseInt(arr[k][j])==Integer.parseInt(reg))
                    {
                     System.out.println("Registraion no. already exists. Re enter registration No. "); 
                      System.out.println("Enter Registration No. of Student: "+ (i+1)+ " again");   
                     input =new Scanner(System.in);
                     reg = input.nextLine();
                    }                    
                 }
                 arr[i][j]=reg;
                }
                 
                if(j==2)
                {
                 System.out.println("Enter CGPA of Student: "+ (i+1));     
                 Scanner input =new Scanner(System.in);
                 String cgpa = input.nextLine();
                 while(Float.parseFloat(cgpa)>4)
                 {
                     System.out.println("CGPA is not valid. It should be less than 4");
                     System.out.println("Enter CGPA of Student: "+(i+1)+" again");
                     input =new Scanner(System.in);
                     cgpa = input.nextLine();
                 }
                 arr[i][j]=cgpa;
                 
                 /* if(Float.parseFloat(arr[i][j])<MinGpa)
                  {
                    MinGpa=Float.parseFloat(arr[i][j]);
                  }
                  
                  if(Float.parseFloat(arr[i][j])>MaxGpa)
                  {
                    MaxGpa=Float.parseFloat(arr[i][j]);
                  }
                  */
                  Sum=Sum+Float.parseFloat(cgpa);
                }
                                
                 
            }    
                                
        }
        
        System.out.println(" Name             Registration No.                CGPA");  
       
        for (int i=0;i<6;i++)
        {                     
            System.out.println(arr[i][0]+ "             "+arr[i][1]+"                "+arr[i][2]);             
           
        }
        
        Arrays.sort(arr, new Comparator<String []>()
        {
            @Override 
            public int compare(final String[] int1,final String[] int2)
            {
            final String numOfKeys1 = int1[2];
            final String numOfKeys2 = int2[2];
            return numOfKeys1.compareTo(numOfKeys2);
            }
        });
        
        System.out.println( " Average       "+Sum/6);
        System.out.println( " Min CGPA      "+arr[0][2]);
        System.out.println( " Max CGPA      "+arr[5][2]);
        
        System.out.println( "Students having CGPAs less than Average "+Sum/6+"are: ");
        for (int i=0;i<6;i++)
        {             
           if(Float.parseFloat(arr[i][2])< Sum/6)
           {
                 System.out.println(arr[i][0]);   
           }
                              
        }
        
        System.out.println("Enter 1 for search by name and 2 for search by registration No.");     
        Scanner in =new Scanner(System.in);
        int var = in.nextInt();
        
        if(var==1)
        {
             System.out.println( "Enter name: ");
             Scanner input =new Scanner(System.in);
             String n = input.next();
             boolean flag=false;
             for (int i=0;i<6;i++)
             {      
                 if(arr[i][0].compareTo(n)==0)
                {
                 System.out.println("CGPA"+arr[i][2]+"  Rank"+(arr.length-i));   
                }
                                             
             }
             
             if(flag==false)
             {
                  System.out.println("not Found");
             }
        }
        
        else if(var==2)
        {
            System.out.println( "Enter registration no.: ");
             Scanner input =new Scanner(System.in);
             int n = input.nextInt();
             boolean flag=false;
             for (int i=0;i<6;i++)
             {      
                 if(Integer.parseInt(arr[i][1])== n)
                {
                 System.out.println("CGPA"+arr[i][2]+"  Rank"+(arr.length-i)); 
                 flag=true;
                }
                              
             }
             
             if(flag==false)
             {
                  System.out.println("not Found");
             }
        }
        
        else
        {
            System.out.println("Choice not available");
        }
   }
    
}
