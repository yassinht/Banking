package com.houta.bankManagement.repositories;

import com.houta.bankManagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    // select * from User where firstname = 'yassine
    List<User> findAllByFirstname(String firstname);

    // select * from User like firstname = 'yassine
    List<User>findByFirstnameContaining(String firsname);

    // select * from User ilike firstname = 'yassine
    List<User>findByFirstnameContainingIgnoreCase(String firsname);

    //select * from user u inner join account a on u.id = a.id_user and a.iban ='ibanexemple'
    List<User>findAllByAccountIban( String iban);

    //select * from user where firstname = 'yassine45' and email ='yassinhtt@gmail.com'
    User findByFirstnameContainingIgnoreCaseAndEmail(String firsname, String email);

}
