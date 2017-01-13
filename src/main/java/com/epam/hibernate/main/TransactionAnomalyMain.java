package com.epam.hibernate.main;

import com.epam.hibernate.thread.SaveThread;
import com.epam.hibernate.thread.SelectThread;

/**
 * Created by Konstantin_Yalovik on 1/13/2017.
 */
public class TransactionAnomalyMain {
    public static void main(String[] args) {
        SelectThread selectThread = new SelectThread();
        SaveThread saveThread = new SaveThread();

        selectThread.start();

        saveThread.start();
    }
}
