package com.pio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
//@RedisHash("Product")
@Entity
public class Product implements Serializable {
    @Id
    private long id;
    private String name;
    private long price;
    private long quantity;
}
