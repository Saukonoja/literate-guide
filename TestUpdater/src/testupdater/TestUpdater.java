package testupdater;

import java.io.IOException;

public class TestUpdater {

    public static void main(String[] args) throws IOException {
        //kill();
        //getUpdate();
        start();
    }
    
    public static void getUpdate() throws IOException{
        Process process = null;
        String cmd = "wget -P /home/h3694/UpdateTest/ "
                + "https://github.com/Saukonoja/literate-guide/releases/download/0.1.2/dist.tar.gz;"
                + " rm /home/h3694/UpdateTest/UpdateTest.jar;"
                + " cd /home/h3694/UpdateTest;"
                + " tar -vxzf dist.tar.gz;";
        process = Runtime.getRuntime().exec(cmd);
    }
    
    public static void kill() throws IOException{
        String cmd2 = "/home/h3694/kill.sh";
        Process process2 = new ProcessBuilder(cmd2).start();
    }
    
    public static void start() throws IOException{
        System.out.println("ennen");
        String cmd3 = "/home/h3694/wget.sh";  
        Process process3 = new ProcessBuilder(cmd3).start();
        System.out.println("jälkeen");
    }
    
    
}
