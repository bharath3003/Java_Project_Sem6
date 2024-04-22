/*
 * package com.example.demo_thymeleaf.model;
 * 
 * import javax.persistence.Column;
 * import javax.persistence.Entity;
 * import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType;
 * import javax.persistence.Id;
 * import javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "projects")
 * public class Project {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * private long id;
 * 
 * @Column(name = "title")
 * private String title;
 * 
 * @Column(name = "domains")
 * private String domains;
 * 
 * @Column(name = "likes")
 * private Integer likes;
 * 
 * public String getTitle() {
 * return title;
 * }
 * 
 * public void setTitle(String title) {
 * this.title = title;
 * }
 * 
 * public Integer getLikes() {
 * return likes;
 * }
 * 
 * public void setlikes(Integer likes) {
 * this.likes = likes;
 * }
 * 
 * public String getDomains() {
 * return domains;
 * }
 * 
 * public void setDomains(String domains) {
 * this.domains = domains;
 * }
 * }
 */
package com.JavaProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "domain")
    private String domain;

    @Column(name = "likes")
    private Integer likes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}