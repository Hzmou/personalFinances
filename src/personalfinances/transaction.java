package personalfinances;


public class transaction {

    public Integer checkNumber;
    public Date date;
    public String description;
    public double amount;
    public String type;
    public String category;
    
    
    public transaction(Integer checkNumber, Date date, String description, double amount, String type,
            String category) {
        this.checkNumber = checkNumber;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.category = category;
    }

    public Integer getCheckNumber() {
        return checkNumber;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public String toString() {
        return String.format("%7d %-10s %-30s %15.2f %-7s %s",
                checkNumber, date.toString(), description,
                amount, type, category);

    }

    
}
