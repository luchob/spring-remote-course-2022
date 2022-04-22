package bg.softuni.hateoas.model.repository;

import bg.softuni.hateoas.model.entity.StudentEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(
    path = "students-data"
)
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
  List<StudentEntity> findAllByNameContains(@Param("partOfName") String partOfName);
}
