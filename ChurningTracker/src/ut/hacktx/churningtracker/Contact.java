package ut.hacktx.churningtracker;
 
public class Contact {
     
    //private variables
    int _id;
    String _name;
    String _moneySpent;
    String _needToSpend;
    String _bonus;
    String _fee;
    String _timeFrame;
    String _month;
    
     
    // Empty constructor
    public Contact(){
         
    }
    // constructor
    public Contact(int id, String name, String moneySpent, String needToSpend, String bonus, String fee, String timeFrame, String month){
        this._id = id;
        this._name = name;
        this._moneySpent = moneySpent;
        this._needToSpend = needToSpend;
        this._bonus = bonus;
        this._fee = fee;
        this._timeFrame = timeFrame;
        this._month = month;
    }
     
    // constructor
    public Contact(String name, String moneySpent, String needToSpend, String bonus, String fee, String timeFrame, String month){
        this._name = name;
        this._moneySpent = moneySpent;
        this._needToSpend = needToSpend;
        this._bonus = bonus;
        this._fee = fee;
        this._timeFrame = timeFrame;
        this._month = month;
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
    public String getMoneySpent(){
        return this._moneySpent;
    }
     
    // setting phone number
    public void setMoneySpent(String moneySpent){
        this._moneySpent = moneySpent;
    }
    
    // getting name
    public String getNeedToSpend(){
        return this._needToSpend;
    }
     
    // setting name
    public void setNeedToSpend(String needToSpend){
        this._needToSpend = needToSpend;
    }
    // getting name
    public String getBonus(){
        return this._bonus;
    }
     
    // setting name
    public void setBonus(String bonus){
        this._bonus = bonus;
    }
    // getting name
    public String getFee(){
        return this._fee;
    }
     
    // setting name
    public void setFee(String fee){
        this._fee = fee;
    }
    // getting name
    public String getTimeFrame(){
        return this._timeFrame;
    }
     
    // setting name
    public void setTimeFrame(String timeFrame){
        this._timeFrame = timeFrame;
    }
    // getting name
    public String getMonth(){
        return this._month;
    }
     
    // setting name
    public void setMonth(String month){
        this._month = month;
    }
}