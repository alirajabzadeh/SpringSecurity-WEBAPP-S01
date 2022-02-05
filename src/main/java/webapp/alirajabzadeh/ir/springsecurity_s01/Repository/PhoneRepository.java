package webapp.alirajabzadeh.ir.springsecurity_s01.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webapp.alirajabzadeh.ir.springsecurity_s01.Model.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
