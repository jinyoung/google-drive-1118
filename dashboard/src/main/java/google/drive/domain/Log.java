package google.drive.domain;

import google.drive.DashboardApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Log_table")
@Data

public class Log  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String payload;
    
    
    
    
    
    private String key;


    public static LogRepository repository(){
        LogRepository logRepository = DashboardApplication.applicationContext.getBean(LogRepository.class);
        return logRepository;
    }




    public static void addLog(FileUploaded fileUploaded){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */

        /** Example 2:  finding and process
        
        repository().findById(fileUploaded.get???()).ifPresent(log->{
            
            log // do something
            repository().save(log);


         });
        */

        
    }
    public static void addLog(FileDeleted fileDeleted){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */

        /** Example 2:  finding and process
        
        repository().findById(fileDeleted.get???()).ifPresent(log->{
            
            log // do something
            repository().save(log);


         });
        */

        
    }
    public static void addLog(FileIndexed fileIndexed){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */

        /** Example 2:  finding and process
        
        repository().findById(fileIndexed.get???()).ifPresent(log->{
            
            log // do something
            repository().save(log);


         });
        */

        
    }
    public static void addLog(VideoProcessed videoProcessed){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */

        /** Example 2:  finding and process
        
        repository().findById(videoProcessed.get???()).ifPresent(log->{
            
            log // do something
            repository().save(log);


         });
        */

        
    }


}
