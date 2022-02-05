package webapp.alirajabzadeh.ir.springsecurity_s01.Exception;

public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(Long id) {
        super("[!] -- Could not found Person With id : " + id);
    }
}
