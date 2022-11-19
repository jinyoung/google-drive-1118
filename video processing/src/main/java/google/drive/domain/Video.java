package google.drive.domain;

import google.drive.domain.VideoProcessed;
import google.drive.VideoProcessingApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Video_table")
@Data

//<<< DDD / Aggregate Root
public class Video  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long fileId;
    
    
    
    
    
    private String url;

    @PostPersist
    public void onPostPersist(){


        VideoProcessed videoProcessed = new VideoProcessed(this);
        videoProcessed.publishAfterCommit();

    }

    public static VideoRepository repository(){
        VideoRepository videoRepository = VideoProcessingApplication.applicationContext.getBean(VideoRepository.class);
        return videoRepository;
    }




//<<< Clean Arch / Port Method
    public static void processVideo(FileUploaded fileUploaded){

        /** Example 1:  new item      */
        Video video = new Video();
        video.setFileId(fileUploaded.getId());
        repository().save(video);

        VideoProcessed videoProcessed = new VideoProcessed(video);
        videoProcessed.publishAfterCommit();
   

        /** Example 2:  finding and process
        
        repository().findById(fileUploaded.get???()).ifPresent(video->{
            
            video // do something
            repository().save(video);

            VideoProcessed videoProcessed = new VideoProcessed(video);
            videoProcessed.publishAfterCommit();

         });
        */

        
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public static void deleteVideo(FileDeleted fileDeleted){

        /** Example 1:  new item 
        Video video = new Video();
        repository().save(video);

        */

        /** Example 2:  finding and process
        
        repository().findById(fileDeleted.get???()).ifPresent(video->{
            
            video // do something
            repository().save(video);


         });
        */

        
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root
