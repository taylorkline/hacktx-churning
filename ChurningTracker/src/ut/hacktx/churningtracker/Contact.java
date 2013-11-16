package ut.hacktx.churningtracker;
 
public class Contact {
     
    //private variables
    int _id;
    String _name;
    String _moneySpent;
     
    // Empty constructor
    public Contact(){
         
    }
    // constructor
    public Contact(int id, String name, String _moneySpent){
        this._id = id;
        this._name = name;
        this._moneySpent = _moneySpent;
    }
     
    // constructor
    public Contact(String name, String _moneySpent){
        this._name = name;
        this._moneySpent = _moneySpent;
    }
    // getting ID
    public int getID(){
        return this._id;
    }
     
    // setting id
    public void setID(int id){
        this._id = id;
    }
     
    // getting name
    public String getName(){
        return this._name;
    }
     
    // setting name
    public void setName(String name){
        this._name = name;
    }
     
    // getting phone number
    public String getPhoneNumber(){
        return this._moneySpent;
    }
     
    // setting phone number
    public void setPhoneNumber(String moneySpent){
        this._moneySpent = moneySpent;
    }
}