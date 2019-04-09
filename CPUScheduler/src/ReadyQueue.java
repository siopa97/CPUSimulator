//Chris Callen
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ReadyQueue
{

    private Processes[] process;//array to hold all of the processes in the queue
    private int size;//define the size of the array for the jobs
    private int numOfJobs;//number of processes in the ready queue

    public ReadyQueue(int size) 
    {
        this.size = size;
        this.process = new Processes[this.size];
        this.numOfJobs = 0;
    }
    
    public Processes[] getProcesses()
    {
    return process;    
    }

    public void outputProcesses() 
    {
        System.out.println("");//for spacing purposes
        for (int i = 0; i < numOfJobs; i++) 
        {
            System.out.println("[Process " + (1+i) + " " + process[i] + " ]");
        }
        System.out.println("");//for spacing purposes in the console
    }
    
    //used to sort the array from smallest batch time to the largest
    //for the SJF scheduler
    public void sjfSort(){
        for(int i = 0; i < numOfJobs; i++){
            for(int j = 0; j < numOfJobs; j++)
            {
                if(process[j].getBatchTime() > process[i].getBatchTime())
                {
                   int temp = process[i].getBatchTime();
                   process[i].setBatchTime(process[j].getBatchTime());
                   process[j].setBatchTime(temp);
                }
                else
                {
                    
                }
            }
        }
    }

    //Used to prompt the user to input batch times, or if the user chooses
    //to use the random batch times
    public void input(int numOfJob) 
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1 to enter the batch times manually "
                + "\nEnter 2 for random batch times");
        int choice = in.nextInt();

        if (choice == 1)//Manually entered batch times
        {
            for (int i = 0; i < numOfJob; i++) 
            {
                Processes p = new Processes();
                p.input();//calls the input function in processes
                process[i] = p;
                numOfJobs++;  
            }
        } else if (choice == 2)//Random batch times
        {
            for (int i = 0; i < numOfJob; i++) 
            {
                Random rand = new Random();
                int batchTime = rand.nextInt(12) + 1;//Creates a random batch time between 1 and 12

                Processes p = new Processes(batchTime);
                process[i] = p;
                numOfJobs++;
            }
        }
    }
}
