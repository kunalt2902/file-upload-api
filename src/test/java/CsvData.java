import lombok.Data;

@Data
public class CsvData {
	private String transDate;
	private String description;
	private String amount;
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CsvData [transDate=" + transDate + ", description=" + description + ", amount=" + amount + "]";
	}
	
	
	
}
