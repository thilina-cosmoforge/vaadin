package com.example.application.entity;


import com.example.application.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ImageUser")
public class ImageUser extends IdFinder {

    @Column(name = "NAME")
    private String name;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] profilePicture;

}
