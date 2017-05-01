/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meter1;

/**
 *
 * @author BRAVO
 */
import org.kaaproject.kaa.client.DesktopKaaPlatformContext;
import org.kaaproject.kaa.client.Kaa;
import org.kaaproject.kaa.client.KaaClient;
import org.kaaproject.kaa.client.SimpleKaaClientStateListener;
import org.kaaproject.kaa.client.event.EndpointKeyHash;
import org.kaaproject.kaa.client.event.EventFamilyFactory;
import org.kaaproject.kaa.client.event.registration.OnDetachEndpointOperationCallback;
import org.kaaproject.kaa.client.event.registration.UserAttachCallback;
import org.kaaproject.kaa.client.logging.strategies.RecordCountLogUploadStrategy;
import org.kaaproject.kaa.common.endpoint.gen.SyncResponseResultType;
import org.kaaproject.kaa.common.endpoint.gen.UserAttachResponse;
import org.kaaproject.kaa.demo.ecf.AndroidDemoEcf;
import org.kaaproject.kaa.demo.ecf.TempAnswer;
import org.kaaproject.kaa.demo.ecf.TempRequest;
import org.kaaproject.kaa.demo.tempdata.TempData;

/**
 *
 * @author Janne
 */
public class Meter2 implements Runnable {
   private Thread thread;
    private String threadName = "";
    static KaaClient kaaClient;

    Meter2(String name) {
        threadName = name;   
        System.out.println("Creating " +  threadName );
    }
       
        
    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();
        while (thread == thisThread){
            //receiveEvent();
             
        }
        
        //sendLog();
        //sendTempRequest();
        
    }
    
    public void start(){  
        if (thread == null)
        {
            kaaStart();
            System.out.println("Starting " +  threadName );
            thread = new Thread (this, threadName);
            thread.start();
            attachUser();
           
        }
        
    }
    
    public void stop(){
        System.out.println("Stopping " +  threadName );
        thread = null;
    }
    
    public static void kaaStart(){
         kaaClient = Kaa.newClient(new DesktopKaaPlatformContext(), new SimpleKaaClientStateListener() {
            @Override
            public void onStarted() {          
                kaaClient.setLogUploadStrategy(new RecordCountLogUploadStrategy(1));
            }

            @Override
            public void onStopped() {
             
            }
        });
        kaaClient.start();
    }
    
    public static void sendLog(){
        float temp = 44.0f;
        TempData td = new TempData(temp, "asdadad");
        kaaClient.addLogRecord(td);
    }
    
    public static void receiveEvent(){
        final EventFamilyFactory eventFamilyFactory = kaaClient.getEventFamilyFactory();
        final AndroidDemoEcf tecf = eventFamilyFactory.getAndroidDemoEcf();
        tecf.addListener(new AndroidDemoEcf.Listener() {
            @Override
            public void onEvent(TempAnswer event, String source) {
                System.out.println("Sain");
                
            }

            @Override
            public void onEvent(TempRequest event, String source) {
                //sendTempRequest();
                System.out.println("vastattu");
            }
        });
    }
    
     public static void attachUser(){
            kaaClient.attachUser("asdddd", "asddddd", new UserAttachCallback() {
                @Override
                public void onAttachResult(UserAttachResponse response) {
                  if(response.getResult() == SyncResponseResultType.SUCCESS){
                      System.out.println("terve");
                      receiveEvent();
                      System.out.println(kaaClient.getEndpointKeyHash());
                      
                      
                  }
                  else{
                      kaaClient.stop();
                  } 
                }
            });
        }
     
     public static void sendTempRequest(){
         final EventFamilyFactory eff = kaaClient.getEventFamilyFactory();
         final AndroidDemoEcf aecf = eff.getAndroidDemoEcf();
         aecf.sendEventToAll(new TempRequest("temp"));
         System.out.println("Lähs");
         //sendLog();
     }
     
     public void detachUser(){
         kaaClient.detachEndpoint(new EndpointKeyHash(kaaClient.getEndpointKeyHash()), new OnDetachEndpointOperationCallback() {
             @Override
             public void onDetach(SyncResponseResultType result) {
                 System.out.println("jee");
             }
         });
     }
}
