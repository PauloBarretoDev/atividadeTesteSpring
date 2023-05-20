package respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.PedidoModel;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}