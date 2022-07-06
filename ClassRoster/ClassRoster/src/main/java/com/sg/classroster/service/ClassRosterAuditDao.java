package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterPersistenceException;

public interface ClassRosterAuditDao {
    void writeAuditEntry(String entry) throws ClassRosterPersistenceException;
}
