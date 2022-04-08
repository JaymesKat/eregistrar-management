package edu.miu.cs.cs425.fairfieldlibrarywebapp.service.impl;

import edu.miu.cs.cs425.fairfieldlibrarywebapp.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibrarywebapp.repository.PublisherRepository;
import edu.miu.cs.cs425.fairfieldlibrarywebapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    private PublisherRepository publisherRepository;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return (List<Publisher>)publisherRepository.findAll();
    }
}
