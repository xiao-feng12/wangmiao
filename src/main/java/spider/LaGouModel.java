package spider;

/**
 * DateTime 2018/8/27 15:25
 *
 * @author db
 **/
public class LaGouModel {
    private String position;
    private String salary;
    private String workYear;
    private String address;
    private String district;
    private String createTime;
    private String companyName;
    private String discription;

    public LaGouModel setPosition(String position) {
        this.position = position;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public LaGouModel setSalary(String salary) {
        this.salary = salary;
        return this;
    }

    public String getSalary() {
        return salary;
    }

    public LaGouModel setWorkYear(String workYear) {
        this.workYear = workYear;
        return this;
    }

    public String getWorkYear() {
        return workYear;
    }

    public LaGouModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public LaGouModel setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public LaGouModel setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public LaGouModel setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LaGouModel setDiscription(String discription) {
        this.discription = discription;
        return this;
    }

    public String getDiscription() {
        return discription;
    }
}
