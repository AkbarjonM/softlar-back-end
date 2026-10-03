package uz.zon.crm.lead;

import java.math.BigDecimal;

public record Lead(
        Long id,
        Long clientId,
        String title,
        String status,
        BigDecimal amount
) {
    public Lead withId(Long newId) {
        return new Lead(newId, clientId, title, status, amount);
    }
}