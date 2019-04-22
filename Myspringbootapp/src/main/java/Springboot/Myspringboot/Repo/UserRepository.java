package Springboot.Myspringboot.Repo;

import Springboot.Myspringboot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM pr1.user INNER JOIN pr1.user_profile ON pr1.user_profile.user_id = pr1.user.id where pr1.user.id = ?1", nativeQuery = true)
    public List<User> find(@Param("id") int userId);
}

