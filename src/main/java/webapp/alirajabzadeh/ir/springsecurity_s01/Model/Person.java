package webapp.alirajabzadeh.ir.springsecurity_s01.Model;

import javax.persistence.*;
import java.util.*;

@Entity
@NamedQuery(name = "Person.findByNationalID", query = "select s from Person s where Person.nationalIdentity = :nid")
public class Person {

    public void assignPhone(Phone phone){
        this.getPhoneList().add(phone);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public void setNationalIdentity(String nationalIdentity) {
        this.nationalIdentity = nationalIdentity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(Set<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(FIRST_NAME, person.FIRST_NAME) && Objects.equals(LAST_NAME, person.LAST_NAME) && Objects.equals(nationalIdentity, person.nationalIdentity) && Objects.equals(address, person.address) && Objects.equals(phoneList, person.phoneList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, FIRST_NAME, LAST_NAME, nationalIdentity, address, phoneList);
    }

    @Id @GeneratedValue
    private Long id;

    private String FIRST_NAME;

    private String LAST_NAME;

    private String nationalIdentity;

    private String address;

    @OneToMany(mappedBy = "personPhone")
    private Set<Phone> phoneList = new HashSet<Phone>();
}
