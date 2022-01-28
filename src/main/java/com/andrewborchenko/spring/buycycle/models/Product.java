package com.andrewborchenko.spring.buycycle.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    // так как hiber автоматически генерирует varchar(355)
    // таким образом отключаем ограничения
    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "city")
    private String city;

    // REFRESH означает что операции entityManager-а ,будут преминены и ко всем связанным сущностям
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn
    private User user;

    // для генерации foreign key требуется создать как manyToOne отношение
    // так и OneToMany
    //mappedBy = "product" означает что каждая фотография ссылается на product
    // с отношением из сущности image (товар связанный с фотографией будет записан в
    // foreign key таблицы images
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
    mappedBy = "product")
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;
    private LocalDateTime dateOfCreated;


    // метод будет вызван перед сохранением объекта в БД

    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }

    @Transactional
    public void addImageToProduct(Image image) {
        image.setProduct(this);
        images.add(image);
    }
}
