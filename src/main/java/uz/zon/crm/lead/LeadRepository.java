package uz.zon.crm.lead;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class LeadRepository {
    private final Map<Long, Lead> storage = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public Lead save(Lead lead) {
        Long id = sequence.incrementAndGet();
        Lead saved = lead.withId(id);
        storage.put(id, saved);
        return saved;
    }

    public Optional<Lead> editById(Long id, Lead lead) {
        Optional<Lead> order = findById(id);

        if (order.isEmpty()) {
            return Optional.empty();
        } else {
            Lead saved = lead.withId(id);
            storage.put(id, saved);
            return Optional.of(saved);
        }
    }

    public List<Lead> findAll() {
        return List.copyOf(storage.values());
    }

    public Optional<Lead> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public boolean deleteById(Long id) {
        return storage.remove(id) != null;
    }
}