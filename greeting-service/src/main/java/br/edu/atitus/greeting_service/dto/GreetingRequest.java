package br.edu.atitus.greeting_service.dto;

public class GreetingRequest {
    private String name;

    public GreetingRequest() {
        // Construtor padrão (vazio)
    }

    // Getter para name
    public String getName() {
        return name;
    }

    // Setter para name
    public void setName(String name) {
        this.name = name;
    }
}
