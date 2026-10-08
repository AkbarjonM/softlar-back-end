package pro.softlar.crm.lead;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/leads")
public class LeadController {
    private final LeadService service;

    public LeadController(LeadService service) {
        this.service = service;
    }

    @GetMapping
    public List<Lead> findAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lead create(@RequestBody Lead lead) {
        Lead created = service.create(lead);
        return created;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lead> editById(@PathVariable Long id, @RequestBody Lead lead) {
        Optional<Lead> order = service.editById(id, lead);

        if (order.isPresent()) {
            return ResponseEntity.ok(order.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lead> findById(@PathVariable Long id) {
        Optional<Lead> order = service.findById(id);

        if (order.isPresent()) {
            return ResponseEntity.ok(order.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Lead> deleteById(@PathVariable Long id) {
        boolean orderIsDeleted = service.deleteById(id);

        if (orderIsDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
