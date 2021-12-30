package ro.ucv.inf.soa.ws.springboot.phonebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import ro.ucv.inf.soa.ws.springboot.phonebook.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>, JpaSpecificationExecutor<Contact> {

  Contact findByPhone(String phone);

  List<Contact> findByNameContaining(String name);
}
