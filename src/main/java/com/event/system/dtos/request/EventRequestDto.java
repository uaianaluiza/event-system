package com.event.system.dtos.request;

import java.time.LocalDate;

public class EventRequestDto {
    private String name;
    private LocalDate date;
    private String local;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
