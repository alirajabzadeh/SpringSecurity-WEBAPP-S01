package webapp.alirajabzadeh.ir.springsecurity_s01.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import webapp.alirajabzadeh.ir.springsecurity_s01.Model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByNationalID(@Param("nid") String nid);
}
