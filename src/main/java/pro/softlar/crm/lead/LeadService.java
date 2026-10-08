package pro.softlar.crm.lead;

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
        String status = lead.getStatus();

        if (status == null) {
            status = "NEW";
        }

        Lead toSave = new Lead(lead.getClientId(), lead.getTitle(), status, lead.getAmount());

        return repository.save(toSave);
    }

    public Optional<Lead> editById(Long id, Lead lead) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setClientId(lead.getClientId());
                    existing.setTitle(lead.getTitle());
                    existing.setStatus(lead.getStatus());
                    existing.setAmount(lead.getAmount());
                    return repository.save(existing);
                });
    }

    public List<Lead> findAll() {
        return repository.findAll();
    }

    public Optional<Lead> findById(Long id) {
        return repository.findById(id);
    }

    public boolean deleteById(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}