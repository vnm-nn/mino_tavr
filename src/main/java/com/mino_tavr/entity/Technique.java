package com.mino_tavr.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "technique")
public class Technique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "reciept_date")
    private String Reciept_date;

    @Column(name = "repair_transfer_date")
    private String Repair_transfer_date;

    @Column(name = "repair_transfer_name")
    private String Repair_transfer_name;

    @Column(name = "return_repair_transfer_date")
    private String Return_repair_transfer_date;

    @Column(name = "return_repair_transfer_name")
    private String Return_repair_transfer_name;

    @Column(name = "return_customer_date")
    private String Return_customer_date;

    @Column(name = "return_customer_name")
    private String Return_customer_name;

    @Column(name = "name")
    private String Name;

    @Column(name = "issue_year")
    private String Issue_year;

    @Column(name = "factory_number")
    private String Factory_number;

    @Column(name = "inventory_number")
    private String Inventory_number;

    @Column(name = "completeness")
    private String Completeness;

    @Column(name = "defect")
    private String Defect;

    @Column(name = "reveal_defect")
    private String Reveal_defect;

    @Column(name = "repair")
    private String Repair;

    @Column(name = "prevent_defect")
    private String Prevent_defect;

    @Column(name = "organization")
    private String Organization;

    @Column(name = "coast")
    private String Coast;

    @Column(name = "payment_method")
    private String Payment_method;

    @Column(name = "note")
    private String Note;

    @Column(name = "refurbishment_task")
    private String Refurbishment_task;

    @Column(name = "refurbishment_material")
    private String Refurbishment_material;

    @Column(name = "refurdishment_description")
    private String Refurdishment_description;

    @Column(name = "product_description")
    private String Product_description;

    @Column(name = "notes")
    private String Notes;

}
