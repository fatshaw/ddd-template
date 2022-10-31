package com.fatshaw.dddtemplate.infrastructure.repository.po

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.Version

@MappedSuperclass
open class BasePO {

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    var createdAt: Timestamp = Timestamp.valueOf(LocalDateTime.now())

    @LastModifiedDate
    @Column(name = "updated_at")
    lateinit var updatedAt: Timestamp

    @Version
    var version: Long = 0

    @Id
    @Column(name = "id")
    open lateinit var id: String
}
