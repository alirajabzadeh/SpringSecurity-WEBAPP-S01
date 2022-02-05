package webapp.alirajabzadeh.ir.springsecurity_s01.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Phone {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPreNumber() {
        return preNumber;
    }

    public void setPreNumber(String preNumber) {
        this.preNumber = preNumber;
    }

    public String getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(String postNumber) {
        this.postNumber = postNumber;
    }

    public Person getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(Person personPhone) {
        this.personPhone = personPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(id, phone.id) && Objects.equals(preNumber, phone.preNumber) && Objects.equals(postNumber, phone.postNumber) && Objects.equals(personPhone, phone.personPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, preNumber, postNumber, personPhone);
    }

    @Id @GeneratedValue
    private Long id;

    private String preNumber;

    private String postNumber;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_person")
    private Person personPhone;
}
