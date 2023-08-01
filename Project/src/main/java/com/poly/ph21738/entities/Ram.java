package com.poly.ph21738.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "t_rams")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Ram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "ram_code")
    private String ramCode;

    @Column(name = "ram_name")
    private String ramName;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Date createdAt;

    @Column(name = "updated_at", insertable = false)
    private Date updatedAt;

    @Column(name = "is_deleted", insertable = false)
    private Boolean isDeleted;

    @Column(name = "status")
    private Integer status;
}
