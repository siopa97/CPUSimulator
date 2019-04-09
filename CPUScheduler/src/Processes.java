import java.util.Scanner;
//this class is the Parent to FCFS and SJF but since both algorithims
//are calculated very similarly all methods needed for both classes are defined
//in the parent. It is built this way so that methods don't need to be rewritten,
//as well if more algorithims were to be added in the future the could also be
//children of this class and overwrite methods where needed
public class Processes
{
    private int batchTime;
    private int[] waitTimes;
    private int[] turnAround;
    
    //no parameter constructor
    public Processes()
    {
        
    }
    
    //constructor using batch time
    public Processes(int batchTime)
    {
        this.batchTime = batchTime;
    }
    //David Siopa
    //used for manual input of batch times
    public void input()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the process's batch time");
        batchTime = in.nextInt();
    }
    
    public String toString()
    {
        String msg = "Batch Time: " + batchTime;
        return msg;
    }
    
    public void setBatchTime(int time)
    {
        this.batchTime = time;
    }
    
    public int getBatchTime()
    {
        return batchTime;
    }
    
    //Calculates the wait time for the processes and puts them into an integer array
    public void calculateWait(Processes[] p)
    {
        waitTimes = new int[p.length];
        int sum = 0;
        for(int i = 0; i < p.length; i++)
        {
            if(i == 0)
            {
                waitTimes[i] = 0;
            }
            else
            {
                sum += p[i-1].getBatchTime();
                waitTimes[i] = sum;
            }
        }
    }
    
    //Calculates the average wait time for a set of processes
    public String averageWait()
    {
        String msg;
        double avgWait = 0;
        double sum = 0;
        for(int i = 0; i < waitTimes.length; i++)
        {
            sum += waitTimes[i];
        }
        
        avgWait = sum/waitTimes.length;
        msg = "Average wait time: " + avgWait;
        return msg;
    }
    
    //Calculates the turn around time for the processes and puts them into an integer array
    public void calculateTurnAround(Processes[] p)
    {
        turnAround = new int[p.length];
        for(int i =0; i< p.length; i++)
        {
            turnAround[i] = p[i].getBatchTime() + waitTimes[i];
        }
    }
    
    //Calculates the average turn around time for a set of processes
    public String averageTurnAround()
    {
        String msg;
        double avgTurnAround = 0;
        double sum = 0;
        for(int i = 0; i < turnAround.length; i++)
        {
            sum += turnAround[i];
        }
        
        avgTurnAround = sum/turnAround.length;
        msg = "Average turn around time: " + avgTurnAround;
        return msg;
    }
    
    //Prints the Gant Chart for a set of processes to the console
    public void printGant(int numOfProcesses)
    {
        System.out.println("Gant Chart:");
        for(int i = 0; i < numOfProcesses; i++)
        {
            if(i == numOfProcesses-1)
            {
                System.out.print(waitTimes[i] + "--[Process" + (i+1) + "]--" + turnAround[i]);
            }
            else
            {
                System.out.print(waitTimes[i] + "--[Process" + (i+1) + "]--");
            }
        }
        System.out.println("");
    }
    
    //For Debugging purposes to print the turn around times to the console
    public void outputTurnAround()
    {
        for(int i = 0; i < turnAround.length; i++)
        {
            System.out.println("Turn Around Times:" + turnAround[i]);
        }
        
    }
    
    //For Debugging purposes to print the wait times to the console
    public void outputWait()
    {
        for(int i = 0; i < waitTimes.length; i++)
        {
            System.out.println("Wait Times:" + waitTimes[i]);
        }
        
    }
}
