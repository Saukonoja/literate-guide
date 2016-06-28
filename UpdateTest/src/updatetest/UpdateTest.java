package updatetest;

public class UpdateTest {

    public static void main(String[] args) throws InterruptedException {
        int result = 1+1;
        int result1 = 1-1;
        while (result == 2 && result1==0){
            System.out.println("All K, go on with your live");     
            Thread.sleep(30000);
        }
        System.out.println("Panic. It's all over for you buddy see you on the other side");
    }
    
}
