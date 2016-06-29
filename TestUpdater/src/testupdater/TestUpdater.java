package testupdater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestUpdater {

    public static void main(String[] args) throws IOException {
        kill();
        get();
        start();
    }
    /*
    public static void getUpdate() throws IOException{
        Process process = null;
        String cmd = "wget -P /home/h3694/UpdateTest/ "
                + "https://github.com/Saukonoja/literate-guide/releases/download/0.1.2/dist.tar.gz;"
                + " rm /home/h9073/UpdateTest/UpdateTest.jar;"
                + " cd /home/h9073/UpdateTest;"
                + " tar -vxzf dist.tar.gz;";
        process = Runtime.getRuntime().exec(cmd);
    }
    */
    public static void kill() throws IOException{
        String cmd2 = "/home/h9073/kill.sh";
        Process process2 = new ProcessBuilder(cmd2).start();
    }
    
    public static void get() throws IOException{
        Process p = Runtime.getRuntime().exec("wget -P /home/h9073/Documents/Repos/literate-guide/UpdateTest/ https://github.com/Saukonoja/literate-guide/releases/download/0.1.2/dist.tar.gz");
        try {
            p.waitFor();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    public static void start() throws IOException {
        String cmd3 = "/home/h9073/start.sh";
        Process process3 = new ProcessBuilder(cmd3).start();
    }
    
    
    
    
}
