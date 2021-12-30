package ro.ucv.inf.soa.ws.springboot.phonebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "contacts")
@XmlRootElement(name = "contact")
public class Contact {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", nullable = false, length = 32)
  @NotNull
  @Size(min = 1, max = 32, message = "The length of name should be between 1 to 32")
  private String name;

  @Column(name = "phone", nullable = false, length = 10)
  @NotNull
  @Size(min = 1, max = 10, message = "The length of phone should be between 1 to 10")
  private String phone;

  public Contact() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "Contact [id=" + id + ", name=" + name + ", phone=" + phone + "]";
  }
}
