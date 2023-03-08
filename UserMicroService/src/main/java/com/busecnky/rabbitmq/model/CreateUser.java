package com.busecnky.rabbitmq.model;

import lombok.*;

import java.io.Serializable;

/**
 * DİKKAAATTTTT!!!!
 * Burada gönderilecek veriler işlenmelidir. Ancak bu bilgilerin iletilebilmesi için
 * 1-serileştirme işleminin yapılması gereklidir.
 * 2-gönderilen sınıfı karşılayacak olan sınıf için tanımlamalar paket adına varana kadar aynı olmalıdır.
 *  (com.busecnky.rabbitmq.model) package ının tamamını serileştirir, deserilize edildiğinde eşleşmiyosa
 *      null gelir)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateUser implements Serializable {
    Long authid;
    String username;
    String email;

}
