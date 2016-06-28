package testupdater;

import java.io.IOException;

public class TestUpdater {

    public static void main(String[] args) {
        
    }
    
    public void getUpdate() throws IOException{
        Process process = null;
        String cmd = "wget -P /home/h3694/UpdateTest/ "
                + "https://github.com/Saukonoja/literate-guide/releases/download/0.6/Test.tar.gz"
                + " && rm /home/h3694/UpdateTest/UpdateTest.jar"
                + " && tar -vxf /home/h3694/UpdateTest/UpdateTest.tar.gz";
        process = Runtime.getRuntime().exec(cmd);
    }
    
    public void kill() throws IOException{
        Process process2 = null;
        String cmd2 = "pkill -f 'java.*UpdateTest'";
        process2 = Runtime.getRuntime().exec(cmd2);
    }
    
    public void start() throws IOException{
        Process process3 = null;
        String cmd3 = "java -jar /home/h3694/UpdateTest/UpdateTest.jar";
        process3 = Runtime.getRuntime().exec(cmd3);
    }
    
}
