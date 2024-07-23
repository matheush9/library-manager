package henrique.matheus.librarymanager.repositories;

import henrique.matheus.librarymanager.model.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {
}
