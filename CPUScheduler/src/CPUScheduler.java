//Collaboration of David Sioppa and Chris Callen
import java.util.Scanner;

public class CPUScheduler 
{
    public static void main(String[] args) 
    {
        int selection = 0;
        do
        {
            //Menu Option for the user
            Scanner in = new Scanner(System.in);
            System.out.println("Select a Scheduler to use:\nEnter 1 for FCFS\nEnter 2 for SJF\nEnter 3 to Quit");
            selection = in.nextInt();
            
            //if else statement for the user to pick either FCFS, SJF or the
            //the option to terminate the program
            if(selection == 1)
            {
                //Prompt the client for the number of jobs
                System.out.println("How many jobs would you like to put in the ready queue");
                int numOfJobs = in.nextInt();//get the number of jobs to put in the ready queue
                ReadyQueue r = new ReadyQueue(numOfJobs);//Create an array in the ready queue to hold the jobs
                
                r.input(numOfJobs);
                r.outputProcesses();
                
                FCFS f = new FCFS();
                
                f.calculateWait(r.getProcesses());
                f.calculateTurnAround(r.getProcesses());
                f.printGant(numOfJobs);
                
                System.out.println(f.averageWait());
                System.out.println(f.averageTurnAround());
                System.out.println("");
                
            }
            else if(selection == 2)
            {
                //Prompt the client for the number of jobs
                System.out.println("How many jobs would you like to put in the ready queue");
                int numOfJobs = in.nextInt();//get the number of jobs to put in the ready queue
                ReadyQueue r = new ReadyQueue(numOfJobs);//Create an array in the ready queue to hold the jobs
                
                r.input(numOfJobs);
                r.sjfSort();
                r.outputProcesses();
                
                SJF s = new SJF();
                
                s.calculateWait(r.getProcesses());
                s.calculateTurnAround(r.getProcesses());
                s.printGant(numOfJobs);
                
                System.out.println(s.averageWait());
                System.out.println(s.averageTurnAround());
                System.out.println("");
                
            }
            else if(selection ==3)
            {
                //do nothing the program will terminate
            }
            else
            {
                //Only used if one of the above selections are not picked
                System.out.println("Invalid Choice!");
            }
            
        }while(selection != 3);
    }
    
}
