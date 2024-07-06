package br.univille.projfso2024b.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfso2024b.entity.Graphy;
import br.univille.projfso2024b.entity.Work;
import br.univille.projfso2024b.repository.WorkRepository;
import br.univille.projfso2024b.service.WorkService;

@Service
public class WorkServiceImpl
     implements WorkService {
    
    @Autowired
    private WorkRepository repository;

    @Override
    public void save(Work work) {
        repository.save(work);
    }

    @Override
    public Work getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Work> getAll() {
        return repository.findAll();
    }

    @Override
    public Work delete(long id) {
        var work = getById(id);
        repository.deleteById(id);
        return work;
    }
    
        @Override
    public List<Graphy> getWorkCountByFuncao() {
        return repository.countWorkByFuncao();
    }
}
