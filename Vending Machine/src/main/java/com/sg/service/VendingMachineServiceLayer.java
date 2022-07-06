package com.sg.service;


import com.sg.dao.InventoryFileImpl;

public class VendingMachineServiceLayer
{
    private final InventoryFileImpl dao;
    private final VendingMachineAuditDao auditDao;

    public VendingMachineServiceLayer(InventoryFileImpl dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
}
