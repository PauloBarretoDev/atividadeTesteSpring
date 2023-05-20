package respository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import model.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {	
	List<ClienteModel> findByEmail(String email);
	ClienteModel findByNomeAndEmail(String nome, String email);
	List<ClienteModel> findByDataNascimentoBetween(LocalDate start, LocalDate end);
	List<ClienteModel> findBySalarioLessThan(Double salario);
	List<ClienteModel> findBySalarioGreaterThan(Double salario);
	List<ClienteModel> findByNomeIsNull();
	List<ClienteModel> findByNomeIsNotNull();
	List<ClienteModel> findByNomeLike(String nome);
	List<ClienteModel> findByNomeNotLike(String nome);
	List<ClienteModel> findByNomeOrderByDataNascimentoDesc(String nome);
	
	// Outros métodos...
	@Modifying
	@Query("UPDATE Cliente c SET c.email = :email WHERE c.id = :id")
	int updateEmailById(Long id, String email);
}