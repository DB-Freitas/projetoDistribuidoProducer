package computacao.paralela.produtor11.repository;

import computacao.paralela.produtor11.dto.Dados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CooperativaRepository extends JpaRepository<Dados,Integer> {
    @Query(value = "SELECT * FROM dados WHERE tipo_cafe_colhido = :tipo_cafe AND cooperativa_id = :cooperativa_id", nativeQuery = true)
    List<Dados> findValidOrder(@Param("tipo_cafe") Integer tipo_cafe, @Param("cooperativa_id") Integer cooperativa_id);
}
