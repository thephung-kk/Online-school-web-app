package com.phungnt.schoolwebapplication.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "holidays")
public class Holiday extends BaseEntity {

    @Id
    private final String day;

    private final String reason;

    @Enumerated(EnumType.STRING)
    private final Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }

}
