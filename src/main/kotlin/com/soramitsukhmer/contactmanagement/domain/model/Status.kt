package com.soramitsukhmer.contactmanagement.domain.model

import com.soramitsukhmer.contactmanagement.api.request.RequestStatusDTO
import com.soramitsukhmer.contactmanagement.api.request.StaffDTO
import com.soramitsukhmer.contactmanagement.api.request.StatusDTO
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "status")
data class Status(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqStatus")
    @SequenceGenerator(name = "seqStatus", sequenceName = "SEQ_STATUS", initialValue = 3)
    @Column(name = "id")
    var id:Long = 0,
    @Column(name = "name")
    var name:String
)
{
//    @ManyToOne
//    @JoinColumn(name = "status_id")
//    lateinit var status: Status

    fun toDTO() = StatusDTO(
            id = id,
            name = name
    )

    fun updateStatus(requestStatusDTO: RequestStatusDTO) : Status
    {
        return this.apply {
            name = requestStatusDTO.name
        }
    }

    companion object{
        fun fromReqDTO(requestStatusDTO: RequestStatusDTO) : Status
        {
            return Status(
                name = requestStatusDTO.name
            )
        }
    }
}