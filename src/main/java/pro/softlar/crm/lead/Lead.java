package pro.softlar.crm.lead;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "leads")
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;
    private String title;
    private String status;
    private BigDecimal amount;

    public Lead(Long clientId, String title, String status, BigDecimal amount) {
        this.clientId = clientId;
        this.title = title;
        this.status = status;
        this.amount = amount;
    }

    public Lead() {
    }

    public Long getId() {
        return id;
    }

    public Long getClientId() {
        return clientId;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}