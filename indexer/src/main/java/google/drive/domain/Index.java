package google.drive.domain;

import google.drive.domain.FileIndexed;
import google.drive.IndexerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Index_table")
@Data

//<<< DDD / Aggregate Root
public class Index  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long fileId;
    
    
    
    @ElementCollection
    
    private List<String> keywords;

    @PostPersist
    public void onPostPersist(){


        FileIndexed fileIndexed = new FileIndexed(this);
        fileIndexed.publishAfterCommit();

    }

    public static IndexRepository repository(){
        IndexRepository indexRepository = IndexerApplication.applicationContext.getBean(IndexRepository.class);
        return indexRepository;
    }




//<<< Clean Arch / Port Method
    public static void makeIndex(FileUploaded fileUploaded){

        /** Example 1:  new item         */
        Index index = new Index();
        index.setFileId(fileUploaded.getId());
        
        repository().save(index);

        FileIndexed fileIndexed = new FileIndexed(index);
        fileIndexed.publishAfterCommit();


        /** Example 2:  finding and process
        
        repository().findById(fileUploaded.get???()).ifPresent(index->{
            
            index // do something
            repository().save(index);

            FileIndexed fileIndexed = new FileIndexed(index);
            fileIndexed.publishAfterCommit();

         });
        */

        
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root
