package Springboot.Myspringboot.Repo;

import Springboot.Myspringboot.Model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userdetailrepo extends JpaRepository<UserProfile,Integer> {
}
