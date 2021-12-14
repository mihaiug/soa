package ro.ucv.inf.soa.ws.phonebook.model;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement       //only needed if we also want to generate XML
public class Contact {

  private Long id;
  
  @Size(min = 1, max = 30, message = "The length of name should be between 1 to 30")
  private String name;
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
