package google.drive.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import google.drive.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import google.drive.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired LogRepository logRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='FileUploaded'")
    public void wheneverFileUploaded_AddLog(@Payload FileUploaded fileUploaded){

        FileUploaded event = fileUploaded;
        System.out.println("\n\n##### listener AddLog : " + fileUploaded + "\n\n");


        

        // Sample Logic //
        Log.addLog(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='FileDeleted'")
    public void wheneverFileDeleted_AddLog(@Payload FileDeleted fileDeleted){

        FileDeleted event = fileDeleted;
        System.out.println("\n\n##### listener AddLog : " + fileDeleted + "\n\n");


        

        // Sample Logic //
        Log.addLog(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='FileIndexed'")
    public void wheneverFileIndexed_AddLog(@Payload FileIndexed fileIndexed){

        FileIndexed event = fileIndexed;
        System.out.println("\n\n##### listener AddLog : " + fileIndexed + "\n\n");


        

        // Sample Logic //
        Log.addLog(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='VideoProcessed'")
    public void wheneverVideoProcessed_AddLog(@Payload VideoProcessed videoProcessed){

        VideoProcessed event = videoProcessed;
        System.out.println("\n\n##### listener AddLog : " + videoProcessed + "\n\n");


        

        // Sample Logic //
        Log.addLog(event);
        

        

    }

}


