package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Domain;

public interface DomainRepository extends JpaRepository<Domain, Integer>{

}
