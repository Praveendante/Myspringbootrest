package Springboot.Myspringboot.Repo;

import Springboot.Myspringboot.Model.modelclass1;
import Springboot.Myspringboot.Model.modelclass2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<modelclass1, Integer> {

}

