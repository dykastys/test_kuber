package com.example.test_kuber.web

import com.example.test_kuber.dto.CasDto
import com.example.test_kuber.service.CasService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class CasController(
    val casService: CasService
) {

    @GetMapping("/all")
    fun findAll(): List<CasDto> {
        return casService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CasDto {
        return casService.findById(id)
    }

    @PostMapping("/create")
    fun create(@RequestBody casDto: CasDto): CasDto {
        return casService.save(casDto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody casDto: CasDto): CasDto {
        return casService.update(id, casDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        casService.delete(id)
    }
}