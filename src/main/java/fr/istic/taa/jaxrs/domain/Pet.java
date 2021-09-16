package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.checkerframework.checker.signature.qual.Identifier;

import io.swagger.v3.oas.models.tags.Tag;

@Entity
@XmlRootElement(name = "Pet")
public class Pet implements Serializable {
  private long id;
  private String name;

  @Id
  @GeneratedValue
  @XmlElement(name = "id")
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @XmlElement(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
/*
  @XmlElementWrapper(name = "tags")
  @XmlElement(name = "tag")
  @OneToMany(mappedBy = "Pet")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }*/
}