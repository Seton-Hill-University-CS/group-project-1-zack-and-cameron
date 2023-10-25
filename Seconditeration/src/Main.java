import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int numProcesses = scanner.nextInt();
        ArrayList<Process> processes = new ArrayList<>();
        for (int i = 1; i <= numProcesses; i++) {
            System.out.println("\nProcess " + i + " details:");
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Arrival Time: ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Burst Time: ");
            int burstTime = scanner.nextInt();
            processes.add(new Process(name, arrivalTime, burstTime));
        }

        FCFSScheduler.schedule(processes);

        System.out.println("\nFCFS Scheduling Results:");
        System.out.printf("%-10s %-15s %-15s %-15s %-15s\n", "Process", "Arrival Time", "Burst Time", "Completion Time", "Waiting Time");
        for (Process process : processes) {
            System.out.printf("%-10s %-15d %-15d %-15d %-15d\n", process.name, process.arrivalTime, process.burstTime, process.completionTime, process.waitingTime);
        }
    }
}
