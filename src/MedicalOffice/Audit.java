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

    protected void auditServicePacients(String action){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String [] data = {action, timestamp.toString(),Thread.currentThread().getName()};
        PacientsDatabase.writeDataToCsv("auditLog.csv", data);
    }

    protected void auditServiceDoctors(String action){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String [] data = {action, timestamp.toString(),Thread.currentThread().getName()};
        DoctorsDatabase.writeDataToCsv("auditLog.csv", data);
    }

    protected void auditServiceAppointments(String action){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String [] data = {action, timestamp.toString(),Thread.currentThread().getName()};
        AppointmentsDatabase.writeDataToCsv("auditLog.csv", data);
    }
}