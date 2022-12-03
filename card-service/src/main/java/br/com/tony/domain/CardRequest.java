package br.com.tony.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CardRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private Integer requestStatus;

    public CardRequest() {
    }

    public CardRequest(Long customerId, Integer requestStatus) {
        this.customerId = customerId;
        this.requestStatus = requestStatus;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Integer getRequestStatus() {
        return requestStatus;
    }
}
