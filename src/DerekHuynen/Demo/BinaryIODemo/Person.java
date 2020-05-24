package DerekHuynen.Demo.BinaryIODemo;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 123;
    /** Surname */
    String lName;
    /** Given name */
    String fName;
    /** Their gender */
    Gender gender;
    /** What they do */
    Profession profession;
    /** Father of the person */
    Person father;
    /** Mother of the person */
    Person mother;

    public Person () {
        this.lName = "";
        this.fName = "";
        this.setGender (Gender.UNSPECIFIED);
        this.setProfession (Profession.UNSPECIFIED);

    }

    public Person (String lName, String fName, Gender gender, Profession profession) {
        this.lName = lName;
        this.fName = fName;
        this.gender = gender;
        this.profession = profession;
    }

    public Person getFather () { return this.father; }

    public void setFather (Person father) { this.father = father; }

    public Person getMother () { return this.mother; }

    public void setMother (Person mother) { this.mother = mother; }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public String getlName() {
        return lName;
    }

    public String getfName() {
        return fName;
    }

    @Override
    public String toString () {
        return this.toString(0);
    }

    private String toString (int indent) {
        StringBuffer sr = new StringBuffer();
        for (int i = 0; i < indent; i ++) {
            sr.append("\t");
        }
        if (indent > 0) {
            if (this.getGender() == Gender.FEMALE) {
                sr.append("Mother -- ");
            } else if (this.getGender() == Gender.MALE) {
                sr.append("Father -- ");
            }
        }
        sr.append("Person - Name: " + this.getlName() + ", " + this.getfName() +
                " Gender: " + this.getGender() + " Works as: " + this.getProfession());
        if (this.getMother() != null) {
            sr.append("\n" + this.getMother().toString(indent + 1));
        }
        if (this.getFather() != null) {
            sr.append("\n" + this.getFather().toString(indent + 1));
        }
        return sr.toString();
    }

}