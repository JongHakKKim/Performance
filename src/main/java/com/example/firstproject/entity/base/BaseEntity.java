package com.example.firstproject.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
@Getter
@Setter
public class BaseEntity extends BaseTimeEntity {

    //만든이
    @Column(updatable = false)
    @CreatedBy
    private String createBy;
    //수정한이
    @LastModifiedBy
    private String modifiedBy;



}