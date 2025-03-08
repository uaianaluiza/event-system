package com.event.system.v2.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "cep")
    private String cep;
    @JsonProperty("logradouro")
    @Column(name = "logradouro")
    private String street;
    @JsonProperty("complemento")
    @Column(name = "complemento")
    private String complement;
    @JsonProperty("unidade")
    @Column(name = "unidade")
    private String unit;
    @JsonProperty("bairro")
    @Column(name = "bairro")
    private String neighborhood;
    @JsonProperty("localidade")
    @Column(name = "localidade")
    private String locality;
    @JsonProperty("uf")
    @Column(name = "uf")
    private String uf;
    @JsonProperty("estado")
    @Column(name = "estado")
    private String state;
    @JsonProperty("regiao")
    @Column(name = "regiao")
    private String region;
    @JsonProperty("ibge")
    @Column(name = "ibge")
    private String ibge;
    @JsonProperty("gia")
    @Column(name = "gia")
    private String gia;
    @Column(name = "ddd")
    @JsonProperty("ddd")
    private String ddd;
    @Column(name = "siafi")
    @JsonProperty("siafi")
    private String siafi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }
}
