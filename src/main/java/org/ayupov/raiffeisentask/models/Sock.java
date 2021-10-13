package org.ayupov.raiffeisentask.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Sock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String color;
    @Min(value = 0)
    private Integer quantity;
    @Min(0)
    @Max(100)
    private Byte cottonPart;
}
