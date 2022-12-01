/**
 *
 * @author kharileigh
 */

package com.kharileigh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Customer")
public class Customer {
    
    @Id
    @Column(name = "ACCOUNT_ID")
    private int customerId;
    
    
    @Column(name = "NAME")
    private String name;
    
    
    @Column(name = "PASSWORD")
    private String password;
    
    
    @Column(name = "ADDRESS")
    private String address;
    
    
    @Column(name = "PHONE_NUMBER")
    private String number;
    
    
    @Column(name = "BALANCE")
    private double balance;
    
}
