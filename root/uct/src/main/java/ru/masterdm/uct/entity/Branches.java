package ru.masterdm.uct.entity;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Branches for marshalling.
 */
public class Branches {
    private List<Branch> branches = new ArrayList<>();

    /**
     * Default constructor.
     */
    public Branches() { }

    /**
     * Constructor with branches.
     * @param branches branches
     */
    public Branches(List<Branch> branches) {
        this.branches = branches;
    }

    /**
     * branches field getter.
     * @return branches
     */
    @XmlElement(name = "Branch")
    public List<Branch> getBranches() {
        return branches;
    }

    /**
     * branches field setter.
     * @param branches branches
     */
    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}