package services;

public class DatabaseWrapper {
    private Database db;

    public DatabaseWrapper(String type) {
        if (type.equals("hibernate")){
            this.db = new DbHandler();
        }
        else if (type.equals("fileHandler")){
            this.db = new fileHandler();
        }
    }
}
