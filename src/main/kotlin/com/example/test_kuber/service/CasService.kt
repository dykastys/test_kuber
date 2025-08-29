package com.example.test_kuber.service

import com.example.test_kuber.dto.CasDto
import com.example.test_kuber.persistence.entity.Address
import com.example.test_kuber.persistence.entity.Cas
import com.example.test_kuber.persistence.repository.CasRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CasService(
    val casRepository: CasRepository
) {

    fun findAll(): List<CasDto> {
        return casRepository.findAll().map { it.toCasDto() }
            .also { LOG.info { "found ${it.size} cases" } }
    }

    fun findById(id: Long): CasDto {
        return casRepository.findById(id).orElseThrow().toCasDto()
            .also { LOG.info { "Found cas: $it" } }
    }

    fun save(casDto: CasDto): CasDto {
        val address = Address(
            city = casDto.address.city,
            street = casDto.address.street,
            house = casDto.address.houseNumber
        )
        val cas = Cas(name = casDto.name, address = address)
        return casRepository.save(cas).toCasDto()
            .also { LOG.info { "Cas saved: $it" } }
    }

    fun update(id: Long, casDto: CasDto): CasDto {
        val cas = casRepository.findById(id).orElseThrow()
        cas.updateByCasDto(casDto)
        return casRepository.save(cas).toCasDto()
            .also { LOG.info { "Updated cas: $cas" } }
    }

    fun delete(id: Long) {
        casRepository.deleteById(id)
            .also { LOG.info { "Deleted Case with id $id was successfully deleted" } }
    }

    companion object {
        private val LOG = KotlinLogging.logger {}
    }
}