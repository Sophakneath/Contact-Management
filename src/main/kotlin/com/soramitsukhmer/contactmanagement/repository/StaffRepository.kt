package com.soramitsukhmer.contactmanagement.repository

import com.soramitsukhmer.contactmanagement.domain.model.Staff
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

interface StaffRepository : PagingAndSortingRepository<Staff, Long>, JpaSpecificationExecutor<Staff>, CrudRepository<Staff, Long> {
    fun findByName(@Param("name") name:String):Staff
}