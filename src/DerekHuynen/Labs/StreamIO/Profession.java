package DerekHuynen.Labs.StreamIO;

public enum Profession {
    ACCOUNTANT, COMPUTER_GEEK, LAWYER, DOCTOR, DENTIST, HAIR_STYLIST, RETIRED, STUDENT,
    UNSPECIFIED, RETAIL_MANAGEMENT, HOME_MAKER, HUMAN_RESOURCES, ENTREMPENEUR, DECEASED, TEACHER;

    @Override
    public String toString () {
        return this.name().substring(0,1) + this.name().substring(1).replaceAll("_", " ").toLowerCase();
    }
}