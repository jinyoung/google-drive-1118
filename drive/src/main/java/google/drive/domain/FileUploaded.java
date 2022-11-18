package google.drive.domain;

import google.drive.domain.*;
import google.drive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FileUploaded extends AbstractEvent {

    private Long id;
    private String name;
    private String type;
    private Long size;

    public FileUploaded(File aggregate){
        super(aggregate);
    }
    public FileUploaded(){
        super();
    }
}
//>>> DDD / Domain Event