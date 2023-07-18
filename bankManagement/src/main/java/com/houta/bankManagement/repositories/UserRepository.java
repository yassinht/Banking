package com.houta.bankManagement.repositories;

import com.houta.bankManagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    // select * from _user where firstname = 'yassine
    List<User> findAllByFirstname(String firstname);

    // select * fromu _user like firstname = '%yassine%'
    List<User>findByFirstnameContaining(String firsname);

    // select * from _user ilike firstname = 'yassine
    List<User>findByFirstnameContainingIgnoreCase(String firsname);

    //select * from _user u inner join account a on u.id = a.id_user and a.iban ='ibanexemple'
    List<User>findAllByAccountIban( String iban);

    //select * from _user where firstname = 'yassine45' and email ='yassinhtt@gmail.com'
    User findByFirstnameContainingIgnoreCaseAndEmail(String firsname, String email);

    @Query("from User where firstname= :fn")
    List<User> searchByFirstname( @Param("fn") String firstname);

    @Query("from User where firstname= '%:firstname%'")
    List<User> searchByFirstnameContaining(  String firstname);

    @Query("from User u inner join Account a on u.id = a.user.id where a.iban = :iban")
    List<User> searchByByIban( String iban);

    @Query(value = " select * from _user u inner join Account a on u.id = a.user.id where a.iban = :iban",nativeQuery = true)
    List<User> searchByIbanNative(String Iban);

}
