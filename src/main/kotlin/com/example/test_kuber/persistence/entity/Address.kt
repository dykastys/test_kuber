package com.example.test_kuber.persistence.entity

import com.example.test_kuber.persistence.entity.base.BaseAuditEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class Address(
    @Column(nullable = false)
    var city: String,
    @Column(nullable = false)
    var street: String,
    @Column(nullable = false)
    var house: String
): BaseAuditEntity()