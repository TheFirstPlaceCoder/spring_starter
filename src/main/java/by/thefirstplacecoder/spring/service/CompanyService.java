package by.thefirstplacecoder.spring.service;

import by.thefirstplacecoder.spring.database.repository.CompanyRepository;
import by.thefirstplacecoder.spring.dto.CompanyReadDto;
import by.thefirstplacecoder.spring.listener.AccessType;
import by.thefirstplacecoder.spring.listener.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public CompanyService(CompanyRepository companyRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.companyRepository = companyRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository.findById(id).map(entity -> {
            applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.DELETE));
            return new CompanyReadDto(entity.getId());
        });
    }
}
