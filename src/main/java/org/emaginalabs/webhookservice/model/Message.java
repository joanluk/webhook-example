package org.emaginalabs.webhookservice.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Message {

    static final long MESSAGE_TIMEOUT = 24 * 60 * 60 * 1000;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String messageBody;

    @Column(nullable = false)
    private String contentType;

    @Column(nullable = false)
    private Timestamp timestamp;

    @ManyToOne(optional = false)
    private Application application;

    protected Message() {
    }

    public Message(String messageBody, String contentType, Application application) {
        super();
        this.messageBody = messageBody;
        this.contentType = contentType;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.application = application;
    }


    public Long getDestinationId() {
        return application.getId();
    }

    public String getDestinationUrl() {
        return application.getUrl();
    }

    public Boolean isMessageTimeout() {
        return timestamp.getTime() < System.currentTimeMillis() - MESSAGE_TIMEOUT;
    }


    @Override
    public String toString() {
        return String.format("Message[id=%d, messageBody='%s', contentType='%s']", id, messageBody, contentType);
    }
}
