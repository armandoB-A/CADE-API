package com.bcode.cade.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GRUPO_BCODE")
public class GrupoBcode {
    @Id
    @Column(name = "id_grupo", nullable = false)
    private Integer id;

    @Column(name = "numero_grupo", nullable = false, length = 4)
    private String numeroGrupo;

    @Column(name = "status_grupo", nullable = false)
    private Character statusGrupo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(String numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    public Character getStatusGrupo() {
        return statusGrupo;
    }

    public void setStatusGrupo(Character statusGrupo) {
        this.statusGrupo = statusGrupo;
    }

}