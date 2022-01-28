package com.andrewborchenko.spring.buycycle.repositories;

import com.andrewborchenko.spring.buycycle.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
