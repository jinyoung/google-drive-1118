package google.drive.domain;

import google.drive.domain.*;
import google.drive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FileIndexed extends AbstractEvent {

    private Long id;
    private Long fileId;
    private List<String> keywords;

    public FileIndexed(Index aggregate){
        super(aggregate);
    }
    public FileIndexed(){
        super();
    }
}
//>>> DDD / Domain Event