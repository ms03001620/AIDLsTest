package baba88.com.aidlstest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class PersonService extends Service {

    private IBinder mIBinder;


    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder = new PersonBinder();
    }

    private final class PersonBinder extends PersonAIDL.Stub {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
        }
        @Override
        public int query(int no) throws RemoteException {
            return no * 10;
        }
    }
}
