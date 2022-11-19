package google.drive.domain;

import google.drive.DashboardApplication;
import google.drive.infra.AbstractEvent;

import javax.persistence.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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


    final static ObjectMapper objectMapper = new ObjectMapper();



    public static String makeJson(AbstractEvent event){

        String json;
        try {
            json = objectMapper.writeValueAsString(event);
            return json;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        
    }
    

    public static void addLog(FileUploaded fileUploaded){

        Log log = new Log();
        log.setKey(fileUploaded.getId().toString());
        log.setPayload(makeJson(fileUploaded));
        repository().save(log);
    }

    public static void addLog(FileDeleted event){
        Log log = new Log();
        log.setKey(event.getId().toString());
        log.setPayload(makeJson(event));
        repository().save(log);    
    }

    public static void addLog(FileIndexed event){
        Log log = new Log();
        log.setKey(event.getFileId().toString());
        log.setPayload(makeJson(event));
        repository().save(log);    
    }

    public static void addLog(VideoProcessed  event){
        Log log = new Log();
        log.setKey(event.getFileId().toString());
        log.setPayload(makeJson(event));
        repository().save(log);    
    }

}
