package tecmilenioBackend.com.backendProyect;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRepositoryBooks extends JpaRepository<BookEntity, Integer> {

}
