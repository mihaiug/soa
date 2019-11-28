package ro.ucv.inf.soa.ws.phonebook.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Contact {

  private Long id;
   
  @XmlElement(required = true, nillable = false) 
  private String name;

  @XmlElement(required = true, nillable = false) 
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
