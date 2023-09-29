import java.util.*;

class Process {
    String name;
    int arrivalTime;
    int burstTime;
    int completionTime;
    int turnaroundTime;
    int waitingTime;

    public Process(String name, int arrivalTime, int burstTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class FCFS {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        
        // Arrival time and burst time
        processes.add(new Process("P1", 0, 6));
        processes.add(new Process("P2", 1, 4));
        processes.add(new Process("P3", 2, 8));
        processes.add(new Process("P4", 3, 3));

        // Arrival time (FCFS)
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        int currentTime = 0;
        for (Process process : processes) {
            // completion time
            process.completionTime = Math.max(currentTime, process.arrivalTime) + process.burstTime;
            
            // turnaround time/waiting time
            process.turnaroundTime = process.completionTime - process.arrivalTime;
            process.waitingTime = process.turnaroundTime - process.burstTime;
            
            currentTime = process.completionTime;
        }

        // Results
        System.out.println("Process\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time");
        for (Process process : processes) {
            System.out.println(process.name + "\t\t" + process.arrivalTime + "\t\t" + process.burstTime + "\t\t" +
                    process.completionTime + "\t\t" + process.turnaroundTime + "\t\t" + process.waitingTime);
        }
    }
}

