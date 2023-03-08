package com.busecnky.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@javax.persistence.Entity
@javax.persistence.Table(name = "")
public class UserProfile extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Kullanıcı kayır olurken oluşan ve user,pass bilgileri tutulan
     * kayda ait eşleştirmede kullanılıcaktır. ---> authid
     */

    Long authid;
    String username;
    String email;
    String photo;
    String about;
    String phone;
    String age;
    String website;

}


