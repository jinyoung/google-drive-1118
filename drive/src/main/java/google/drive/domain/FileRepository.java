package google.drive.domain;

import google.drive.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel="files", path="files")
public interface FileRepository extends PagingAndSortingRepository<File, Long>{

}
//>>> PoEAA / Repository