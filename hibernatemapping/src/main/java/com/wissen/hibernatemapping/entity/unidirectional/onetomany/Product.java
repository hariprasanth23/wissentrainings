package com.wissen.hibernatemapping.entity.unidirectional.onetomany;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String sellerName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<Review> reviewList;

    public void addReview(Review review){
        if(reviewList == null){
            reviewList = new ArrayList<>();
        }
        reviewList.add(review);
    }


}
