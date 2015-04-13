
package ohtumini.domain;

import java.util.Scanner;


public class ConsoleIO  {
    
    private Scanner sc;
    
    public ConsoleIO(){
        this.sc = new Scanner(System.in);
    }

    public void start() {
        this.usage();
        
        String command = sc.nextLine();
        
        while(!command.equals("quit")){
            String subcommand = sc.nextLine();
            
            
            
            command = this.sc.nextLine();
            
        } 
        System.out.println("System quitting...");
        System.exit(0);
   }

    private void usage() {
        System.out.println("Usage: <command> <subcommand>");
        System.out.println("Available commands: add <target>, quit");
        System.out.println("Available subcommands: article");
    }
    
}
