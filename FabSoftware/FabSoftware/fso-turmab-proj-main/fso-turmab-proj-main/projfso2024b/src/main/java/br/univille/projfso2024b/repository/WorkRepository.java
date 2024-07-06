package br.univille.projfso2024b.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.univille.projfso2024b.entity.Graphy;
import br.univille.projfso2024b.entity.Work;

@Repository
public interface WorkRepository 
    extends JpaRepository<Work, Long> {
    
            @Query("SELECT new br.univille.projfso2024b.entity.Graphy(w.funcao, COUNT(w)) " +
           "FROM Work w GROUP BY w.funcao")
    List<Graphy> countWorkByFuncao();
}