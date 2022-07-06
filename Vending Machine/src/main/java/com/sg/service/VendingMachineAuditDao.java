package com.sg.service;


import com.sg.dao.VendingMachinePersistenceException;

public interface VendingMachineAuditDao {
    void writeAuditEntry(String entry) throws VendingMachinePersistenceException;
}
