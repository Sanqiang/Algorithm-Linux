/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_8_ChatServer;

import CareerCup.ObjectOrientedDesign.Q8_10_HashTable.HashTable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class UserManager {
    
    private static UserManager instance = null;
    
    private UserManager() {
        db = new HashTable<>();
    }
    
    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
    HashTable<BigInteger, User> db;
    
    public void register(String _nickname, String _account) {
        BigInteger id = BigInteger.probablePrime(10, new Random());
        User ur = new User(id, _nickname, _account);
        db.put(id, ur);
    }
    
    public void sendRequest(User _from, User _to) {
        Request r = new Request(_from, _to);
        _to.receive_list.add(r);
    }
    
    public void approveRequest(User _from, User _to) {
        ArrayList<Request> list = _to.receive_list;
        for (Request request : list) {
            if (request.from == _from) {
                request.status = RequestStatusType.Approved;
            }
        }
        _to.contacts.add(_from.getId());
        _from.contacts.add(_to.getId());
    }
    
    public void declineRequest(User _from, User _to) {
        ArrayList<Request> list = _to.receive_list;
        for (Request request : list) {
            if (request.from == _from) {
                request.status = RequestStatusType.Declined;
            }
        }
    }
    
    public static void main(String[] args) {
    }
}
