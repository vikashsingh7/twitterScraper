package personal.projects.twitterProj.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import personal.projects.twitterProj.entity.User;

@CrossOrigin("http://localhost:4200/")
public interface UserRepository extends JpaRepository<User, Integer> {
}
