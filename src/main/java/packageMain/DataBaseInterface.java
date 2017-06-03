package packageMain;

import org.springframework.data.repository.CrudRepository;

public interface DataBaseInterface extends CrudRepository<Account,Integer> {
	
}
