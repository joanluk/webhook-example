package org.emaginalabs.webhookservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String url;

    private String name;

    @OneToMany(mappedBy = "application", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Message> messages;

    @Column(nullable = false)
    private Boolean online;

    protected Application() {
    }

    public Application(String url) {
        super();
        this.url = url;
        this.online = true;
    }


}
