package com._like.Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
public class Supplier {

   private Long id;
   private String name;
   private String address;
   private String email;
   private String phoneNumber;
   private String contactPerson;
   private String bank;
   private String paymentManner;
   private Set<Drug> drugs = new HashSet<>();
}
