package uz.zon.crm.lead;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadService {
    private final LeadRepository repository;

    public LeadService(LeadRepository repository) {
        this.repository = repository;
    }

    public Lead create(Lead lead) {
        String status = lead.status();

        if (status == null) {
            status = "NEW";
        }

        Lead toSave = new Lead(null, lead.clientId(), lead.title(), status, lead.amount());

        return repository.save(toSave);
    }

    public Optional<Lead> editById(Long id, Lead lead) {
        return repository.editById(id, lead);
    }

    public List<Lead> findAll() {
        return repository.findAll();
    }

    public Optional<Lead> findById(Long id) {
        return repository.findById(id);
    }

    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }
}