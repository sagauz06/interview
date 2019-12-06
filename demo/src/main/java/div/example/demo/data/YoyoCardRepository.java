package div.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import div.example.demo.YoyoCard;

public interface YoyoCardRepository extends JpaRepository<YoyoCard, Long> {

}
