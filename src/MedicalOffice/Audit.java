package MedicalOffice;

import java.sql.Timestamp;

public final class Audit {
    private static Audit audit = null;

    private Audit(){}

    public static Audit getAuditInstance(){
        if (audit == null)
            audit = new Audit();
        return audit;
    }

    protected void auditService(String action){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String [] data = {action, timestamp.toString()};
        //Database.writeDataToCsv("auditLog.csv", data);
    }
}