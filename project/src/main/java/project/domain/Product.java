package project.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "type")
    @NotNull
    private String type;
    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "number")
    @NotNull
    private String number;

    @Column(name = "p_price")
    @NotNull
    private String p_price;

    @Column(name = "created_on")
    private LocalDate createdOn;

    @ManyToMany
    @JoinTable(
            name = "customer_order",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = { @JoinColumn(name = "customer_id")}
    )
    private List<Customer> customers;
    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
