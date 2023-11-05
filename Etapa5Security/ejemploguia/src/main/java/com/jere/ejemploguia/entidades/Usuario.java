package com.jere.ejemploguia.entidades;

import com.jere.ejemploguia.enumeraciones.Rol;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    private String nombre;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private Rol rol;

}
