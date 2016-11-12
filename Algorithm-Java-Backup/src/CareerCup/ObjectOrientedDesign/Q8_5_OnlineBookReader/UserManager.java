/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_5_OnlineBookReader;

import CareerCup.ObjectOrientedDesign.Q8_10_HashTable.HashTable;
import java.math.BigInteger;

public class UserManager {
    
    public HashTable<BigInteger, User> DB;
    private static UserManager inst;
    
    private UserManager() {
        DB = new HashTable<>();
        entity = BigInteger.ONE;
    }
    
    public static UserManager getInstance() {
        if (inst == null) {
            inst = new UserManager();
        }
        return inst;
    }
    static BigInteger entity;
    
    public void addUser(String _name, short _type) {
        entity = entity.add(BigInteger.ONE);
        BigInteger id = entity;
        User u = new User(id, _name, _type);
        DB.put(id, u);
    }
    
    public void removeUser(BigInteger _id) {
        DB.delete(_id);
    }
    
    public static void main(String[] args) {
    }
}
