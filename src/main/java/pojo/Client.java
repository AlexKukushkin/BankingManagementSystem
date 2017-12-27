package pojo;

public class Client {
    private int idClient;
    private String firstName;
    private String familyName;
    private String patronymic;
    private String birthDate;
    private String passport;
    private String registerLocation;
    private String address;
    private String sexType;
    private String phoneNumber;
    private int idUser;

    public Client() {
    }

    public Client(String firstName, String familyName, String patronymic, String birthDate,
                  String passport, String registerLocation, String address, String sexType, String phoneNumber) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.passport = passport;
        this.registerLocation = registerLocation;
        this.address = address;
        this.sexType = sexType;
        this.phoneNumber = phoneNumber;
    }

    public Client(int idClient, String firstName, String familyName, String patronymic,
                  String birthDate, String passport, String registerLocation, String address,
                  String sexType, String phoneNumber) {
        this.idClient = idClient;
        this.firstName = firstName;
        this.familyName = familyName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.passport = passport;
        this.registerLocation = registerLocation;
        this.address = address;
        this.sexType = sexType;
        this.phoneNumber = phoneNumber;
    }

    public Client(int idClient, String firstName, String familyName, String patronymic, String birthDate,
                  String passport, String registerLocation, String address, String sexType, String phoneNumber, int idUser) {
        this.idClient = idClient;
        this.firstName = firstName;
        this.familyName = familyName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.passport = passport;
        this.registerLocation = registerLocation;
        this.address = address;
        this.sexType = sexType;
        this.phoneNumber = phoneNumber;
        this.idUser = idUser;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPassport() {
        return passport;
    }

    public String getRegisterLocation() {
        return registerLocation;
    }

    public String getAddress() {
        return address;
    }

    public String getSexType() {
        return sexType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setRegisterLocation(String registerLocation) {
        this.registerLocation = registerLocation;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSexType(String sexType) {
        this.sexType = sexType;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
