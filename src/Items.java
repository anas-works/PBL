import java.util.ArrayList;

public class Items {
    private DataBase dataBase = new DataBase();

    public String itemName;
    public int rate;
    
    private static ArrayList<Items> itemList = new ArrayList<>();

    public Items() {
        if (itemList.isEmpty()) {
            DataBase dataBase = new DataBase();
            dataBase.selectItems();  // Fetch employees from the database
            itemList = dataBase.getItems();  // Set the list of employees
        }
    }

    public String getitemName() {
        return itemName;
    }

    public int getRate() {
        return rate;
    }

    // Setters
    public void setitemName(String itemName) {
        this.itemName = itemName;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }



    void addItems(String itemName, int rate){
        dataBase.insertItems(itemName, rate);

        Items item = new Items();
        item.setitemName(itemName);
        item.setRate(rate);

        itemList.add(item);
    }
    

    public static ArrayList<Items> getItemList() {
        return itemList;
    }
}
